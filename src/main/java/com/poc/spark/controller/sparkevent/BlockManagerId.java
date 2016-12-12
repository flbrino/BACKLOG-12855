package com.poc.spark.controller.sparkevent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fcamara.
 */
public class BlockManagerId {
  @SerializedName( "Executor ID" )
  private String executorID = null;
  @SerializedName( "Host" )
  private String host = null;
  @SerializedName( "Port" )
  private Long port = null;

  public String getExecutorID() {
    return executorID;
  }

  public void setExecutorID( String executorID ) {
    this.executorID = executorID;
  }

  public String getHost() {
    return host;
  }

  public void setHost( String host ) {
    this.host = host;
  }

  public Long getPort() {
    return port;
  }

  public void setPort( Long port ) {
    this.port = port;
  }
}
