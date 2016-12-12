package com.poc.spark.controller.sparkevent;

import com.google.gson.annotations.SerializedName;


/**
 * Created by fcamara.
 */
public class JobResult {
  @SerializedName( "Result" )
  private String result = null;
  @SerializedName( "Exception" )
  private SparkException exception = null;

  public String getResult() {
    return result;
  }

  public void setResult( String result ) {
    this.result = result;
  }

  public SparkException getException() {
    return exception;
  }

  public void setException( SparkException exception ) {
    this.exception = exception;
  }
}
