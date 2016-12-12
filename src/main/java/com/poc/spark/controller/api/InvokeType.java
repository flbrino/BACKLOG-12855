package com.poc.spark.controller.api;

/**
 * Created by fcamara
 */
public enum InvokeType {

  SPARK_SUBMIT("spark-subit");

  private final String key;

  private InvokeType(String key) {
    this.key = key;
  }

  public String getKey() { return key; }
}
