package com.poc.spark.controller.sparksubmit;

import com.poc.spark.controller.api.JobContext;
import com.poc.spark.controller.api.SubmitJob;

/**
 * Created by fcamara
 */

public class SparkSubmitJob implements SubmitJob{

  private String applicationName;
  private String applicationJar;
  private String applicationMainClass;
  private String[] args;

  public SparkSubmitJob(String applicationName, String applicationJar, String applicationMainClass, String[] args) {
    this.applicationName = applicationName;
    this.applicationJar = applicationJar;
    this.applicationMainClass = applicationMainClass;
    this.args = args;
  }

  @Override
  public String getApplicationName() {
    return applicationName;
  }
  @Override
  public String getApplicationJar() {
    return applicationJar;
  }

  @Override
  public String getApplicationMainClass() {
    return applicationMainClass;
  }

  @Override
  public String[] getArgs() {
    return args;
  }

  @Override
  public Object call( JobContext jc ) throws Exception {
    throw new RuntimeException( "Not Implemented" );
  }
}
