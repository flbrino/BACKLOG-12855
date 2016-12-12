package com.poc.spark.controller.conf;

/**
 * Created by fcamara
 */
public enum IntInfinity implements ListValue {
  INFINITY("infinity");

  private String value;


  IntInfinity( String value){
    this.value = value;
  }
  IntInfinity( int value){
    this.value = String.valueOf( value );
  }
  public String getValue() {
    return value;
  }
}
