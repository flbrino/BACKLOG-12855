package com.poc.spark.controller.conf;

/**
 * Created by fcamara
 */
public enum SchedulingMode implements ListValue {
  FIFO( "FIFO" ), FAIR( "FAIR" );

  private String value;

  SchedulingMode( String value ) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
