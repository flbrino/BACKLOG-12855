package com.poc.spark.controller.api;

/**
 * Created by fcamara
 */
public interface SubmitJob extends Job {
  String getApplicationName();

  String getApplicationJar();

  String getApplicationMainClass();

  String[] getArgs();
}
