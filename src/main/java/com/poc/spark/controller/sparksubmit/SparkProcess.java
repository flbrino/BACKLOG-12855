package com.poc.spark.controller.sparksubmit;

import com.poc.spark.controller.hdfsutil.HdfsService;
import com.poc.spark.controller.hdfsutil.NamedCluster;
import com.poc.spark.controller.conf.KettleConf;
import com.poc.spark.controller.sparkevent.Event;
import com.poc.spark.controller.sparkevent.PrintEvents;
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
public class SparkProcess {
  private static final Logger LOG = LoggerFactory.getLogger( SparkProcess.class );

  private final KettleConf conf;
  private final SparkAppHandle sparkAppHandle;
  private final SparkSubmitMonitor monitor;
  private final File confFile;
  private final File confDir;
  private String applicationID = null;

  public String getApplicationID() {
    return monitor.getApplicationID();
  }

  public String getApplicationState() {
    return monitor.getApplicationState().toString();
  }

  public SparkProcess( KettleConf conf, final SparkAppHandle sparkAppHandle, File confFile) {
    this.conf = conf;
    this.sparkAppHandle = sparkAppHandle;
    this.confFile = confFile;
    this.monitor = new SparkSubmitMonitor();
    sparkAppHandle.addListener( monitor );
    this.confDir = confFile.getParentFile();
  }

  public void kill() {
    sparkAppHandle.kill();
    freeResource();

    if ( sparkAppHandle.getState().isFinal() ) {
      return;
    }

    // Last ditch effort.
    if ( !sparkAppHandle.getState().isFinal() ) {
      LOG.warn( "Timed out shutting down remote driver, interrupting..." );
      sparkAppHandle.kill();
    }
  }

  public void stop() {
    try {
      sparkAppHandle.stop();
    }catch ( Exception e ) {
      /*ignore*/
    }
    freeResource();
  }

  private void freeResource() {
    //delete spark default conf file
    try {
      if ( confFile != null && confFile.exists() ) {
        confFile.delete();
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

  public void getSparkLogFile(){
    if( conf.getBoolean( SPARK_EVENTLOG_ENABLED ) )
    {
      String logDirectory = conf.get( SPARK_EVENTLOG_DIR );
      String applicationID = logDirectory + "/" + getApplicationID();
      if ( applicationID != null && applicationID.length() > 0 && !isAlive() ) {
        HdfsService hdfsService = new HdfsService( getNamedCluster() );
        if(copyLogFiles( hdfsService, new Path( confDir.getAbsolutePath() ), applicationID, 1 )) {
          for(File file :confDir.listFiles() ){
            if(file.isFile() && file.getName().startsWith( getApplicationID() ) && !file.getName().endsWith( ".crc" )) {
              ArrayList<Event> sparkEvents = Event.toObject( file.getAbsolutePath() );
              PrintEvents.print( sparkEvents );
            }
          }
        }
      }
    }
  }

  private NamedCluster getNamedCluster(){
    NamedCluster namedCluster = new NamedCluster("CDH 58");
    namedCluster.setHadoopConfDir("C:\\@work\\25\\pdi-ee-client-7.0.0.0\\data-integration\\plugins\\pentaho-big-data-plugin\\hadoop-configurations\\cdh58");
    namedCluster.setSparkClient("C:\\Tools\\spark-2.0.1-bin-hadoop2.7");
    namedCluster.setSparkHome("/opt/pentaho/spark");
    namedCluster.setSparkHomeLib("hdfs://svqxbdcn6cdh58secure-n2.pentahoqa.com:8020/user/devuser/fcamara/sparkLib");
    namedCluster.setPdiHome("C:\\@work\\25\\pdi-ee-client-7.0.0.0");
    return namedCluster;
  }

  public boolean copyLogFiles(HdfsService hdfsService, Path copyToPath, String fileName, int i){
    String aux    = fileName + "_" + i;
    Path hdfsPath = new Path( aux );
    if( hdfsService.exists( hdfsPath ) ){
      hdfsService.copyToLocalFile( true, hdfsPath, copyToPath);
      copyLogFiles( hdfsService, copyToPath, fileName, i+1 );
      return true;
    }
    return false;
  }

}
