package com.poc.spark.controller.api;

/**
 * Created by fcamara
 */
public interface ApplicationHandle {

  String getApplicationID();

  String getApplicationState();

  void kill();

  void stop();

  boolean isAlive();

  boolean success();

  void processSparkLog();

  void freeResources();

}
