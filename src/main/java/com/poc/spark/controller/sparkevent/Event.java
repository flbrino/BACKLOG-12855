package com.poc.spark.controller.sparkevent;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by fcamara.
 */
public class Event {
  @SerializedName("Event")
  private String event = null;
  @SerializedName("Spark Version")
  private String SparkVersion = null;
  @SerializedName("Block Manager ID")
  private BlockManagerId BlockManagerID = null;
  @SerializedName("Maximum Memory")
  private Long MaximumMemory = null;
  @SerializedName( "Timestamp" )
  private Long timestamp = null;
  @SerializedName( "Job ID" )
  private Long jobID = null;
  @SerializedName( "Submission Time" )
  private Long submissionTime = null;
  @SerializedName( "Stage Infos" )
  private StageInfo[] stageInfos = null;
  @SerializedName( "Stage Info" )
  private StageInfo stageInfo = null;
  @SerializedName( "Parent IDs" )
  private Long[] parentID = null;
  @SerializedName( "Details" )
  private String details = null;
  private Accumulable[] Accumulables = null;
  @SerializedName( "Stage IDs" )
  private Long[] stageIDs = null;
  @SerializedName( "Stage ID" )
  private Long stageID = null;
  @SerializedName( "Properties" )
  private Property properties = null;
  @SerializedName( "Completion Time" )
  private Long completionTime = null;
  @SerializedName( "Failure Reason" )
  private String failureReason = null;
  @SerializedName( "Job Result" )
  private JobResult jobResult = null;
  @SerializedName( "App Name" )
  private String appName = null;
  @SerializedName( "App ID" )
  private String appID = null;
  @SerializedName( "App Attempt ID" )
  private String appAttemptID = null;
  @SerializedName( "Driver Logs" )
  private LogUrls driverLogs;
  private String User;
  @SerializedName( "Task Info" )
  private TaskInfo taskInfo;
  private Long executionId = null;
  private String description = null;
  private String physicalPlanDescription = null;
  private SparkPlanInfo sparkPlanInfo = null;
  private Children[] children = null;
  @SerializedName( "Stage Attempt ID" )
  private Long stageAttemptID = null;
  @SerializedName( "Task Type" )
  private String taskType = null;
  @SerializedName( "Task End Reason" )
  private TaskEndReason taskEndReason = null;
  @SerializedName( "Task Metrics" )
  private TaskMetric taskMetrics = null;
  private Long time = null;

  public Long getTime() {
    return time;
  }

  public void setTime( Long time ) {
    this.time = time;
  }

  public String getEvent() {
    return event;
  }

  public void setEvent( String event ) {
    this.event = event;
  }

  public String getSparkVersion() {
    return SparkVersion;
  }

  public void setSparkVersion( String sparkVersion ) {
    SparkVersion = sparkVersion;
  }

  public BlockManagerId getBlockManagerID() {
    return BlockManagerID;
  }

  public void setBlockManagerID( BlockManagerId blockManagerID ) {
    BlockManagerID = blockManagerID;
  }

  public Long getMaximumMemory() {
    return MaximumMemory;
  }

  public void setMaximumMemory( Long maximumMemory ) {
    MaximumMemory = maximumMemory;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp( Long timestamp ) {
    this.timestamp = timestamp;
  }

  public Long getJobID() {
    return jobID;
  }

  public void setJobID( Long jobID ) {
    this.jobID = jobID;
  }

  public Long getSubmissionTime() {
    return submissionTime;
  }

  public void setSubmissionTime( Long submissionTime ) {
    this.submissionTime = submissionTime;
  }

  public StageInfo[] getStageInfos() {
    return stageInfos;
  }

  public void setStageInfos( StageInfo[] stageInfos ) {
    this.stageInfos = stageInfos;
  }

  public StageInfo getStageInfo() {
    return stageInfo;
  }

  public void setStageInfo( StageInfo stageInfo ) {
    this.stageInfo = stageInfo;
  }

  public Long[] getParentID() {
    return parentID;
  }

  public void setParentID( Long[] parentID ) {
    this.parentID = parentID;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails( String details ) {
    this.details = details;
  }

  public Accumulable[] getAccumulables() {
    return Accumulables;
  }

  public void setAccumulables( Accumulable[] accumulables ) {
    Accumulables = accumulables;
  }

  public Long[] getStageIDs() {
    return stageIDs;
  }

  public void setStageIDs( Long[] stageIDs ) {
    this.stageIDs = stageIDs;
  }

  public Long getStageID() {
    return stageID;
  }

  public void setStageID( Long stageID ) {
    this.stageID = stageID;
  }

  public Property getProperties() {
    return properties;
  }

  public void setProperties( Property properties ) {
    this.properties = properties;
  }

  public Long getCompletionTime() {
    return completionTime;
  }

  public void setCompletionTime( Long completionTime ) {
    this.completionTime = completionTime;
  }

  public String getFailureReason() {
    return failureReason;
  }

  public void setFailureReason( String failureReason ) {
    this.failureReason = failureReason;
  }

  public JobResult getJobResult() {
    return jobResult;
  }

  public void setJobResult( JobResult jobResult ) {
    this.jobResult = jobResult;
  }

  public String getAppName() {
    return appName;
  }

  public void setAppName( String appName ) {
    this.appName = appName;
  }

  public String getAppID() {
    return appID;
  }

  public void setAppID( String appID ) {
    this.appID = appID;
  }

  public String getAppAttemptID() {
    return appAttemptID;
  }

  public void setAppAttemptID( String appAttemptID ) {
    this.appAttemptID = appAttemptID;
  }

  public LogUrls getDriverLogs() {
    return driverLogs;
  }

  public void setDriverLogs( LogUrls driverLogs ) {
    this.driverLogs = driverLogs;
  }

  public String getUser() {
    return User;
  }

  public void setUser( String user ) {
    User = user;
  }

  public TaskInfo getTaskInfo() {
    return taskInfo;
  }

  public void setTaskInfo( TaskInfo taskInfo ) {
    this.taskInfo = taskInfo;
  }

  public Long getExecutionId() {
    return executionId;
  }

  public void setExecutionId( Long executionId ) {
    this.executionId = executionId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription( String description ) {
    this.description = description;
  }

  public String getPhysicalPlanDescription() {
    return physicalPlanDescription;
  }

  public void setPhysicalPlanDescription( String physicalPlanDescription ) {
    this.physicalPlanDescription = physicalPlanDescription;
  }

  public SparkPlanInfo getSparkPlanInfo() {
    return sparkPlanInfo;
  }

  public void setSparkPlanInfo( SparkPlanInfo sparkPlanInfo ) {
    this.sparkPlanInfo = sparkPlanInfo;
  }

  public Children[] getChildren() {
    return children;
  }

  public void setChildren( Children[] children ) {
    this.children = children;
  }

  public Long getStageAttemptID() {
    return stageAttemptID;
  }

  public void setStageAttemptID( Long stageAttemptID ) {
    this.stageAttemptID = stageAttemptID;
  }

  public String getTaskType() {
    return taskType;
  }

  public void setTaskType( String taskType ) {
    this.taskType = taskType;
  }

  public TaskEndReason getTaskEndReason() {
    return taskEndReason;
  }

  public void setTaskEndReason( TaskEndReason taskEndReason ) {
    this.taskEndReason = taskEndReason;
  }

  public TaskMetric getTaskMetrics() {
    return taskMetrics;
  }

  public void setTaskMetrics( TaskMetric taskMetrics ) {
    this.taskMetrics = taskMetrics;
  }

  public static ArrayList<Event> toObject(String path){
    FileReader fileReader = null;
    ArrayList<Event> events = null;
    try {
      Gson gson = new Gson();
      events = new ArrayList<>(  );
      fileReader = new FileReader( path );
      try(BufferedReader br = new BufferedReader(fileReader)) {
        for(String line; (line = br.readLine()) != null; ) {
          if(!line.trim().isEmpty()) {
            events.add( gson.fromJson( line, Event.class ) );
          }
        }
      }
    }catch ( Exception e ) {
      e.printStackTrace();
    } finally {
      try {
        if ( fileReader != null ) {
          fileReader.close();
        }
      }catch(Exception e){}
    }
    return events;
  }

  public static void main(String[] args){
    ArrayList<Event> events = toObject( "C://temp/a.json" );
    PrintEvents.print( events );
  }
}
