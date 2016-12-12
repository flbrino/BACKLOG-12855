package com.poc.spark.controller.conf;

/**
 * Created by fcamara
 */
public enum RollingTimeInterval implements ListValue{
  DAILY( "daily" ),
  HOURLY( "hourly" ),
  MINUTELY( "minutely" );

  private String value;

  RollingTimeInterval( String value ) {
    this.value = value;
  }

  RollingTimeInterval( int seconds ) {
    value = String.valueOf( seconds );
  }
  public String getValue() {
    return value;
  }
}
