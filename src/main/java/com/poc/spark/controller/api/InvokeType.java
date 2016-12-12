package com.poc.spark.controller.api;

/**
 * Created by fcamara
 */
public enum InvokeType {

  SPARK_SUBMIT( "spark-submit" );

  private final String key;

  InvokeType( String key ) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }
}
