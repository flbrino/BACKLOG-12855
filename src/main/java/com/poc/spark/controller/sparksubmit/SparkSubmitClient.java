package com.poc.spark.controller.sparksubmit;

import com.google.common.base.Stopwatch;
import com.poc.spark.controller.api.Job;
import com.poc.spark.controller.api.JobClient;
import com.poc.spark.controller.api.SubmitJob;
import com.poc.spark.controller.common.Utils;
import com.poc.spark.controller.conf.KettleConf;
import org.apache.spark.launcher.SparkAppHandle;
import org.apache.spark.launcher.SparkLauncher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URI;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import static com.poc.spark.controller.conf.KettleConfEntry.*;
import static com.poc.spark.controller.common.EnvironmentProperty.*;
/**
 * Created by fcamara
 */
public class SparkSubmitClient implements JobClient {
  private static final Logger LOG = LoggerFactory.getLogger(SparkSubmitClient.class);
  private static final AtomicInteger EXECUTOR_GROUP_ID = new AtomicInteger();
  private static final long TIMEOUT = 2*60*1000;
  private final KettleConf conf;

  private SparkProcess sparkProcess;

  public SparkSubmitClient(KettleConf conf) {
    this.conf = conf;
  }

  @Override public <T> void submit( Job<T> job ) {
    try {
      SubmitJob submitJob = (SubmitJob)job;
      // Let the launcher go away when launcher in yarn cluster mode. This avoids keeping lots
      // of "small" Java processes lingering on the Livy server node.
      //properties.setProperty(SPARK_YARN_SUBMIT_WAITAPPCOMPLETE.getKey(), "false");
      final File confFile = Utils.writeConfToFile(conf);
      final SparkLauncher launcher = new SparkLauncher();

      launcher.setAppName( submitJob.getApplicationName() );
      // Spark 1.x does not support specifying deploy mode in conf and needs special handling.
      String deployMode = conf.get(SPARK_SUBMIT_DEPLOYMODE);
      if (deployMode != null) {
        launcher.setDeployMode(deployMode);
      }
      launcher.setSparkHome(conf.get( SPARK_HOME_ENV.key() ));
      launcher.setAppResource(submitJob.getApplicationJar());
      launcher.setPropertiesFile(confFile.getAbsolutePath());
      launcher.setMainClass(submitJob.getApplicationMainClass());
      launcher.addAppArgs( submitJob.getArgs() );
      launcher.setVerbose( false );

      /*if (properties.getProperty("proxy_user") != null) {
        launcher.addSparkArg("--proxy-user", properties.getProperty("proxy_user"));
      }*/

      Stopwatch stopwatch = Stopwatch.createStarted();
      SparkAppHandle sparkHandle = launcher.startApplication( );
      sparkProcess = new SparkProcess(conf, sparkHandle, confFile);
      waitForProcess();
      sparkLogTreat();
    } catch ( Exception e ) {
      LOG.error( e.getMessage(), e );
    }
  }

  public void waitForProcess() {
    try {
      while ( sparkProcess.isAlive() ) {
        Thread.sleep( 20000 );
      }
    }catch ( Exception e ) {
      /*ignore*/
    }
  }

  public void stopProcess() {
    try {
      int times = 3;
      while ( sparkProcess.isAlive() && times > 0) {
        sparkProcess.stop();
        Thread.sleep( 10000 );
        times--;
      }
      if ( sparkProcess.isAlive() ) {
        sparkProcess.kill();
      }
    }catch ( Exception e ) {
      /*ignore*/
    }
  }

  private void sparkLogTreat(){
    sparkProcess.getSparkLogFile();
  }
}
