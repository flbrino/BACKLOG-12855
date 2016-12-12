package com.poc.spark.controller.sparkevent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fcamara.
 */
public class ExecutorInfo {
  private String Host = null;
  @SerializedName( "Total Cores" )
  private Integer totalCores;
  @SerializedName( "Log Urls" )
  private LogUrls logUrls;

  public String getHost() {
    return Host;
  }

  public void setHost( String host ) {
    Host = host;
  }

  public Integer getTotalCores() {
    return totalCores;
  }

  public void setTotalCores( Integer totalCores ) {
    this.totalCores = totalCores;
  }

  public LogUrls getLogUrls() {
    return logUrls;
  }

  public void setLogUrls( LogUrls logUrls ) {
    this.logUrls = logUrls;
  }
}
