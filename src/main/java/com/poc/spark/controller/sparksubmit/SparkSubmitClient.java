package com.poc.spark.controller.sparksubmit;

import com.google.common.base.Stopwatch;
import com.poc.spark.controller.api.ApplicationHandle;
import com.poc.spark.controller.api.Job;
import com.poc.spark.controller.api.JobClient;
import com.poc.spark.controller.common.Utils;
import com.poc.spark.controller.conf.KettleConf;
import org.apache.spark.launcher.SparkAppHandle;
import org.apache.spark.launcher.SparkLauncher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static com.poc.spark.controller.conf.KettleConfEntry.*;
import static com.poc.spark.controller.common.EnvironmentProperty.*;

/**
 * Created by fcamara
 */
public class SparkSubmitClient implements JobClient {
  private static final Logger LOG = LoggerFactory.getLogger( SparkSubmitClient.class );
  private final KettleConf conf;
  private SparkProcess sparkApplication = null;

  public SparkSubmitClient( KettleConf conf ) {
    this.conf = conf;
  }

  @Override public ApplicationHandle submit( Job job ) {
    try {
      //properties.setProperty(SPARK_YARN_SUBMIT_WAITAPPCOMPLETE.getKey(), "false");

      final File confFile = Utils.writeConfToFile( job.getTempDirectory(), conf );
      final SparkLauncher launcher = new SparkLauncher();

      launcher.setAppName( job.getApplicationName() );
      // Spark 1.x does not support specifying deploy mode in conf and needs special handling.
      String deployMode = conf.get( SPARK_SUBMIT_DEPLOYMODE );
      if ( deployMode != null ) {
        launcher.setDeployMode( deployMode );
      }
      launcher.setSparkHome( conf.get( SPARK_HOME_ENV.key() ) );
      launcher.setAppResource( job.getApplicationJar() );
      launcher.setPropertiesFile( confFile.getAbsolutePath() );
      launcher.setMainClass( job.getApplicationMainClass() );
      if(job.getArgs() != null && job.getArgs().length > 0) {
        launcher.addAppArgs( job.getArgs() );
      }
      launcher.setVerbose( false );

      /*if (properties.getProperty("proxy_user") != null) {
        launcher.addSparkArg("--proxy-user", properties.getProperty("proxy_user"));
      }*/

      Stopwatch stopwatch = Stopwatch.createStarted();
      SparkAppHandle sparkHandle = launcher.startApplication();
      sparkApplication = new SparkProcess( conf, sparkHandle, (SparkSubmitJob) job );
    } catch ( Exception e ) {
      LOG.error( e.getMessage(), e );
    }
    return sparkApplication;
  }

  public void stopProcess() {
    try {
      if ( sparkApplication != null && sparkApplication.isAlive() ) {
        sparkApplication.stop();
      }
    } catch ( Exception e ) {
      /*ignore*/
    }
  }

}
