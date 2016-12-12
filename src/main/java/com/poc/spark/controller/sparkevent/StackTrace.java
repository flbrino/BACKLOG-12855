package com.poc.spark.controller.sparkevent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fcamara.
 */
public class StackTrace {
  @SerializedName( "Declaring Class" )
  private String declaringClass = null;
  @SerializedName( "Method Name" )
  private String methodName = null;
  @SerializedName( "File Name" )
  private String fileName = null;
  @SerializedName( "Line Number" )
  private Integer lineNumber = null;

  public String getDeclaringClass() {
    return declaringClass;
  }

  public void setDeclaringClass( String declaringClass ) {
    this.declaringClass = declaringClass;
  }

  public String getMethodName() {
    return methodName;
  }

  public void setMethodName( String methodName ) {
    this.methodName = methodName;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName( String fileName ) {
    this.fileName = fileName;
  }

  public Integer getLineNumber() {
    return lineNumber;
  }

  public void setLineNumber( Integer lineNumber ) {
    this.lineNumber = lineNumber;
  }
}
