package com.poc.spark.controller.sparksubmit;

import com.poc.spark.controller.api.ApplicationHandle;
import com.poc.spark.controller.common.EnvironmentProperty;
import com.poc.spark.controller.hdfsutil.HdfsService;
import com.poc.spark.controller.hdfsutil.NamedCluster;
import com.poc.spark.controller.conf.KettleConf;
import com.poc.spark.controller.sparkevent.Event;
import com.poc.spark.controller.sparkevent.PrintEvents;
import org.apache.commons.io.FileUtils;
import org.apache.hadoop.fs.Path;
import org.apache.spark.launcher.SparkAppHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.poc.spark.controller.conf.KettleConfEntry.*;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by fcamara
 */
public class SparkProcess implements ApplicationHandle {
  private static final Logger LOG = LoggerFactory.getLogger( SparkProcess.class );

  private final KettleConf conf;
  private final SparkAppHandle sparkAppHandle;
  private final SparkSubmitMonitor monitor;
  private final SparkSubmitJob job;
  private final File tempDirectory;

  public String getApplicationID() {
    return monitor.getApplicationID();
  }

  public String getApplicationState() {
    return monitor.getApplicationState().toString();
  }

  public SparkProcess( KettleConf conf, final SparkAppHandle sparkAppHandle, SparkSubmitJob job ) {
    this.conf = conf;
    this.sparkAppHandle = sparkAppHandle;
    this.tempDirectory = job.getTempDirectory();
    this.monitor = new SparkSubmitMonitor();
    this.job = job;

    sparkAppHandle.addListener( monitor );
  }

  public void kill() {
    sparkAppHandle.kill();
    freeResources();

    if ( sparkAppHandle.getState().isFinal() ) {
      return;
    }
    // Last effort.
    if ( !sparkAppHandle.getState().isFinal() ) {
      LOG.warn( "Timed out shutting down remote driver, interrupting..." );
      sparkAppHandle.kill();
    }
  }

  public void stop() {
    try {
      int times = 3;
      if ( isAlive() && times > 0 ) {
        sparkAppHandle.stop();
        Thread.sleep( 10000 );
        times--;
      }
      if ( isAlive() ) {
        sparkAppHandle.kill();
      }
    } catch ( Exception e ) {
      /*ignore*/
    }
    freeResources();
  }

  public void freeResources() {
    //delete spark default conf file
    try {
      if ( tempDirectory != null && tempDirectory.exists() ) {
        FileUtils.deleteDirectory( tempDirectory );
      }
    } catch ( Exception e ) {
      LOG.error( e.getMessage(), e );
    }
  }

  public boolean isAlive() {
    return !sparkAppHandle.getState().isFinal();
  }

  public boolean success() {
    return SparkAppHandle.State.FINISHED == sparkAppHandle.getState();
  }

  public void processSparkLog() {
    if ( conf.getBoolean( SPARK_EVENTLOG_ENABLED ) ) {
      String logDirectory = conf.get( SPARK_EVENTLOG_DIR );
      if(logDirectory == null || logDirectory.endsWith( "/applicationHistory" )){ //is default history directory
        //so lets get log files from REST API
        try {//Get Spark Rest API
          if ( SparkRestApiClient.getLogAndUnzip( getApplicationID(), conf.get( "SPARK_RST_API" ), tempDirectory ) ) {
            processSparkLogFiles();
          }
        } catch(Exception e) {
          LOG.error( e.getMessage(), e );
        }
      }
      else {//Get From HDFS
        String applicationID = logDirectory + "/" + getApplicationID();
        if ( applicationID != null && applicationID.length() > 0 && !isAlive() ) {
          HdfsService hdfsService = new HdfsService( getNamedCluster() );
          if ( copyLogFiles( hdfsService, new Path( tempDirectory.getAbsolutePath() ), applicationID, 1 ) ) {
            processSparkLogFiles();
          }
        }
      }
    }
  }

  private void processSparkLogFiles(){
    for ( File file : tempDirectory.listFiles() ) {
      if ( file.isFile() && file.getName().startsWith( getApplicationID() ) && !file.getName()
          .endsWith( ".crc" ) &&  !file.getName().endsWith( ".zip" ) && !file.getName().endsWith( ".conf" )) {
        ArrayList<Event> sparkEvents = Event.toObject( file.getAbsolutePath() );
        PrintEvents.print( sparkEvents );
      }
    }
  }

  private NamedCluster getNamedCluster() {
    NamedCluster namedCluster = new NamedCluster( "Cluster", job.isKerberos(), job.getServerUser(), job.getKeytab() );
    namedCluster.setHadoopConfDir(
        conf.get( EnvironmentProperty.HADOOP_CONF_DIR_ENV ));
    namedCluster.setSparkClient( conf.get( EnvironmentProperty.SPARK_HOME_ENV ) );
    namedCluster.setSparkHome( conf.get( EnvironmentProperty.SPARK_LIBS_ON_CLUSTER_ENV ) );
    namedCluster.setSparkHomeLib( conf.get( EnvironmentProperty.SPARK_HOME_ON_CLUSTER_ENV ) );
    namedCluster.setPdiHome( conf.get( EnvironmentProperty.PDI_HOME_ENV ) );
    return namedCluster;
  }

  private boolean copyLogFiles( HdfsService hdfsService, Path copyToPath, String fileName, int i ) {
    String aux = fileName + "_" + i;
    Path hdfsPath = new Path( aux );
    if ( hdfsService.exists( hdfsPath ) ) {
      hdfsService.copyToLocalFile( false, hdfsPath, copyToPath );
      copyLogFiles( hdfsService, copyToPath, fileName, i + 1 );
      return true;
    }
    return false;
  }

}
