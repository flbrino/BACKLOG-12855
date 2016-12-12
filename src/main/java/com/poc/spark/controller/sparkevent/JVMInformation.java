package com.poc.spark.controller.sparkevent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fcamara.
 */
public class JVMInformation {
  @SerializedName( "Java Home" )
  private String javaHome = null;
  @SerializedName( "Java Version" )
  private String javaVersion = null;
  @SerializedName( "Scala Version" )
  private String scalaVersion = null;

  public String getJavaHome() {
    return javaHome;
  }

  public void setJavaHome( String javaHome ) {
    this.javaHome = javaHome;
  }

  public String getJavaVersion() {
    return javaVersion;
  }

  public void setJavaVersion( String javaVersion ) {
    this.javaVersion = javaVersion;
  }

  public String getScalaVersion() {
    return scalaVersion;
  }

  public void setScalaVersion( String scalaVersion ) {
    this.scalaVersion = scalaVersion;
  }
}
