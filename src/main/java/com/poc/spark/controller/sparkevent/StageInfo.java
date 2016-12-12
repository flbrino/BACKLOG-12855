package com.poc.spark.controller.sparkevent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fcamara.
 */
public class StageInfo {
  @SerializedName( "Stage ID" )
  private Long stageID;
  @SerializedName( "Stage Attempt ID" )
  private Integer stageAttemptID;
  @SerializedName( "Stage Name" )
  private String stageName;
  @SerializedName( "Number of Tasks" )
  private Integer numberOfTasks;
  @SerializedName( "RDD Info" )
  private RDDInfo[] rddInfo;

  public Long getStageID() {
    return stageID;
  }

  public void setStageID( Long stageID ) {
    this.stageID = stageID;
  }

  public Integer getStageAttemptID() {
    return stageAttemptID;
  }

  public void setStageAttemptID( Integer stageAttemptID ) {
    this.stageAttemptID = stageAttemptID;
  }

  public String getStageName() {
    return stageName;
  }

  public void setStageName( String stageName ) {
    this.stageName = stageName;
  }

  public Integer getNumberOfTasks() {
    return numberOfTasks;
  }

  public void setNumberOfTasks( Integer numberOfTasks ) {
    this.numberOfTasks = numberOfTasks;
  }

  public RDDInfo[] getRddInfo() {
    return rddInfo;
  }

  public void setRddInfo( RDDInfo[] rddInfo ) {
    this.rddInfo = rddInfo;
  }

}
