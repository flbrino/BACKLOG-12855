package com.poc.spark.controller.sparksubmit;

import org.apache.spark.launcher.SparkAppHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fcamara
 */
public class SparkSubmitMonitor implements SparkAppHandle.Listener {
  private static final Logger LOG = LoggerFactory.getLogger( SparkProcess.class );
  private String applicationID = null;
  private SparkProcess sparkProcess = null;
  private SparkAppHandle.State applicationState = null;

  public String getApplicationID() {
    return applicationID;
  }

  public SparkAppHandle.State getApplicationState() {
    return applicationState;
  }

  @Override public void stateChanged( SparkAppHandle sparkAppHandle ) {
    LOG.info(
        "Spark App Id [" + sparkAppHandle.getAppId() + "] State Changed.  State [" + sparkAppHandle.getState() + "]" );
    System.out.println(
        "Spark App Id [" + sparkAppHandle.getAppId() + "] State Changed.  State [" + sparkAppHandle.getState() + "]" );
    applicationState = sparkAppHandle.getState();
  }

  @Override public void infoChanged( SparkAppHandle sparkAppHandle ) {
    LOG.info(
        "Spark App Id [" + sparkAppHandle.getAppId() + "] Info Changed.  State [" + sparkAppHandle.getState() + "]" );
    System.out.println(
        "Spark App Id [" + sparkAppHandle.getAppId() + "] Info Changed.  State [" + sparkAppHandle.getState() + "]" );
    if ( sparkAppHandle.getAppId() != null && !sparkAppHandle.getAppId().isEmpty() && applicationID == null ) {
      this.applicationID = sparkAppHandle.getAppId();
    }
  }
}
