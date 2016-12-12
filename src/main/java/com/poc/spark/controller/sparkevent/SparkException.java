package com.poc.spark.controller.sparkevent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fcamara.
 */
public class SparkException {
  @SerializedName( "Message" )
  private String message = null;
  @SerializedName( "Stack Trace" )
  private StackTrace[] stackTrace;

  public String getMessage() {
    return message;
  }

  public void setMessage( String message ) {
    this.message = message;
  }

  public StackTrace[] getStackTrace() {
    return stackTrace;
  }

  public void setStackTrace( StackTrace[] stackTrace ) {
    this.stackTrace = stackTrace;
  }
}
