package com.poc.spark.controller.sparkevent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fcamara.
 */
public class TaskInfo {

  @SerializedName( "Task ID" )
  private Long taskId = null;
  @SerializedName( "Index" )
  private Integer index = null;
  @SerializedName( "Attempt" )
  private Integer attempt = null;
  @SerializedName( "Launch Time" )
  private Long launchTime = null;
  @SerializedName( "Executor ID" )
  private Long executorID = null;
  @SerializedName( "Host" )
  private String host = null;
  @SerializedName( "Locality" )
  private String locality = null;
  @SerializedName( "Speculative" )
  private String speculative = null;
  @SerializedName( "Getting Result Time" )
  private Long gettingResulttime = null;
  @SerializedName( "Finish Time" )
  private Long finishTime = null;
  @SerializedName( "Failed" )
  private Boolean failed = null;
  //@SerializedName( "Accumulables" )
  private Accumulable[] accumulables = null;

  public Long getTaskId() {
    return taskId;
  }

  public void setTaskId( Long taskId ) {
    this.taskId = taskId;
  }

  public Integer getIndex() {
    return index;
  }

  public void setIndex( Integer index ) {
    this.index = index;
  }

  public Integer getAttempt() {
    return attempt;
  }

  public void setAttempt( Integer attempt ) {
    this.attempt = attempt;
  }

  public Long getLaunchTime() {
    return launchTime;
  }

  public void setLaunchTime( Long launchTime ) {
    this.launchTime = launchTime;
  }

  public Long getExecutorID() {
    return executorID;
  }

  public void setExecutorID( Long executorID ) {
    this.executorID = executorID;
  }

  public String getHost() {
    return host;
  }

  public void setHost( String host ) {
    this.host = host;
  }

  public String getLocality() {
    return locality;
  }

  public void setLocality( String locality ) {
    this.locality = locality;
  }

  public String getSpeculative() {
    return speculative;
  }

  public void setSpeculative( String speculative ) {
    this.speculative = speculative;
  }

  public Long getGettingResulttime() {
    return gettingResulttime;
  }

  public void setGettingResulttime( Long gettingResulttime ) {
    this.gettingResulttime = gettingResulttime;
  }

  public Long getFinishTime() {
    return finishTime;
  }

  public void setFinishTime( Long finishTime ) {
    this.finishTime = finishTime;
  }

  public Boolean getFailed() {
    return failed;
  }

  public void setFailed( Boolean failed ) {
    this.failed = failed;
  }

  public Accumulable[] getAccumulables() {
    return accumulables;
  }

  public void setAccumulables( Accumulable[] accumulables ) {
    this.accumulables = accumulables;
  }
}
