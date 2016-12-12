package com.poc.spark.controller.sparkevent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by fcamara.
 */
public class PrintEvents {

  private static final Logger LOG = LoggerFactory.getLogger( PrintEvents.class );

  public static void print(ArrayList<Event> events) {
    ArrayList<Event> application = new ArrayList<Event>(  );
    boolean startInclude = false;
    for (Event event : events) {
      if("SparkListenerApplicationStart".equals( event.getEvent() )){
        application.clear();
        application.add( event );
        startInclude = true;
      }
      else if ( "SparkListenerApplicationEnd".equals( event.getEvent() ) ) {
        application.add( event );
        printApplication( application );
        startInclude = false;
      }
      else if(startInclude){
        application.add( event );
      }
    }
  }

  private static String getBlockManager (ArrayList<Event> events) {

    StringBuffer sb = new StringBuffer(  );
    for ( Event event : events ){
      if("SparkListenerBlockManagerAdded".equals( event.getEvent() )){
        if(!"driver".equals( event.getBlockManagerID().getExecutorID() )){
          sb.append( "Executor: " ).append( event.getBlockManagerID().getExecutorID() ).append( " added " ).append( "\n" )
              .append( "    * Host: " ).append( event.getBlockManagerID().getHost() ).append( "\n" )
              .append( "    * Port: " ).append( event.getBlockManagerID().getPort() ).append( "\n" )
              .append( "    * Maximum Memory: " ).append( event.getMaximumMemory() ).append( "\n" )
              .append( "    * At : " ).append( new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format( new Date(event.getTimestamp()) )  ).append( "\n" );
        }
      }
    }
    return sb.toString();
  }

  private static void printApplication(ArrayList<Event> events) {
    ArrayList<Event> job = new ArrayList<Event>(  );
    Long jobID = null;
    boolean startInclude = false;
    printSummary( events );
    for (Event event : events) {
      if("SparkListenerJobStart".equals( event.getEvent() )){
        job.clear();
        job.add( event );
        startInclude = true;
      }
      else if ( "SparkListenerJobEnd".equals( event.getEvent() ) ) {
        job.add( event );
        printJob( job );
        startInclude = false;
      }
      else if(startInclude){
        job.add( event );
      }
    }
    System.out.println( "----------------------------------END APPLICATION SUMMARY-------------------------------------------\n" );
  }

  private static  void printJob(ArrayList<Event> jobEvents) {
    ArrayList<Event> stageEvents = new ArrayList<Event>(  );

    Event jobEvent = jobEvents.get( 0 );
    printJobSummary(jobEvents);
    for ( Long stageID : jobEvent.getStageIDs() ){
      for (Event jobevents2 : jobEvents) {
        if ( "SparkListenerStageSubmitted".equals( jobevents2.getEvent() ) && stageID.longValue() == jobevents2.getStageInfo().getStageID().longValue() ) {
          stageEvents.clear();
          stageEvents.add( jobevents2 );
        } else if ( "SparkListenerStageCompleted".equals( jobevents2.getEvent() ) ) {
          stageEvents.add( jobevents2 );
          printStage(stageEvents);
          break;
        } else if (jobevents2.getStageID() != null && jobevents2.getStageID().longValue() == stageID.longValue() ){
          stageEvents.add( jobevents2 );
        }
      }
    }
    System.out.println( "---------END JOB SUMMARY---------\n" );
  }

  private static  void printStage(ArrayList<Event> stageEvents) {
    ArrayList<Event> taskEvents = new ArrayList<Event>(  );
    ArrayList<Long> treated = new ArrayList<Long>(  );

    Event stageEvent = stageEvents.get( 0 );
    //printStage
    for ( int i = 0; i < stageEvent.getStageInfo().getNumberOfTasks().intValue(); i++ ) {
      long currentTask = -1;
      for (Event stageEvent2 : stageEvents) {
        if ( "SparkListenerTaskStart".equals( stageEvent2.getEvent() ) && currentTask == -1 && !treated.contains( stageEvent2.getTaskInfo().getTaskId() )) {
          taskEvents.clear();
          taskEvents.add( stageEvent2 );
          currentTask = stageEvent2.getTaskInfo().getTaskId();
          treated.add( currentTask );
        } else if ( "SparkListenerTaskEnd".equals( stageEvent2.getEvent() ) &&  stageEvent2.getTaskInfo().getTaskId().longValue() == currentTask ) {
          taskEvents.add( stageEvent2 );
          printTask(taskEvents);
          currentTask = -1;
          break;
        }
      }
    }
  }

  private static  void printTask(ArrayList<Event> taskEvents) {
    StringBuffer sb = new StringBuffer(  );
    long startTime = 0;
    Event taskEvent = taskEvents.get( 1 );
    TaskInfo tinfo = taskEvent.getTaskInfo();

    sb.append( "Task ID: "  ).append( taskEvent.getTaskInfo().getTaskId() ).append( "\n" )
        .append( "Stage ID: "  ).append( taskEvent.getStageID() ).append( "\n" )
        .append( "Started: " ).append( (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format( new Date(startTime = tinfo.getLaunchTime()) ) ).append( "\n" );
    long endTimestamp = tinfo.getFinishTime();
    long elapsed = endTimestamp - startTime;
    sb.append( "Ended: " ).append( (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format( new Date(endTimestamp) ) ).append(" (").append(elapsed/1000).append("s) ").append( "\n" );
    sb.append( "Result: " ).append( taskEvent.getTaskEndReason().getReason() ).append( "\n" );
    sb.append( "Executor ID: " ).append( tinfo.getExecutorID() ).append( "\n" );
    sb.append( "Host: " ).append( tinfo.getHost() ).append( "\n" );

    System.out.println(sb.toString());

  }

  private static  void printSummary(ArrayList<Event> events) {
    long startTimestamp = 0;
    StringBuffer sb = new StringBuffer( "----------------------------------START APPLICATION SUMMARY-------------------------------------------\n" );
    for (Event event : events) {
      if("SparkListenerApplicationStart".equals( event.getEvent() )){
            sb.append( "Name: " ).append( event.getAppName() ).append( "\n" )
            .append( "User: " ).append( event.getUser() ).append( "\n" )
            .append( "ID: " ).append( event.getAppID() ).append( "\n" )
            //.append( "State: " ).append( process.getApplicationState() ).append( "\n" )
            //.append( "Final Status: " ).append( process.success() ? "SUCCESS" : "FAILED" ).append( "\n" ) //to validate
            .append( "Started: " ).append( (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format( new Date(startTimestamp = event.getTimestamp()) ) ).append( "\n" )
                .append( "Stdout: " ).append( event.getDriverLogs().getStdout() ).append( "\n" )
                .append( "Stderr: " ).append( event.getDriverLogs().getStderr() ).append( "\n" );
      }
      else if("SparkListenerApplicationEnd".equals( event.getEvent() )) {
        long endTimestamp = event.getTimestamp();
        long elapsed = endTimestamp - startTimestamp;
        sb.append( "Ended: " ).append( (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format( new Date(endTimestamp) ) ).append(" (").append(elapsed/1000).append("s) ").append( "\n" );
      }
    }
    sb.append(getBlockManager( events ));
    System.out.println( sb.toString() );
  }


  private static  void printJobSummary(ArrayList<Event> events) {
    long submissionTime = 0;
    StringBuffer sb = new StringBuffer( "---------START JOB SUMMARY---------\n" );
    for (Event event : events) {
      if("SparkListenerJobStart".equals( event.getEvent() )){
        sb.append( "ID: " ).append( event.getJobID() ).append( "\n" )
            .append( "Submission Time: " ).append( (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format( new Date(submissionTime = event.getSubmissionTime()) ) ).append( "\n" );

        for (StageInfo info : event.getStageInfos() ) {
          sb.append( "Stage: " ).append( info.getStageID() ).append( "\n" )
          .append( "    *Description: " ).append( info.getStageName() ).append( "\n" )
          .append( "    *Number of task: " ).append( info.getNumberOfTasks() ).append( "\n" );
          for (RDDInfo rddInfo : info.getRddInfo() ){
            sb.append( "    *RDD INFO (ID/Name): ").append( rddInfo.getRddID() ).append( "/" ).append( rddInfo.getName() ).append( "\n" );
          }
        }
      }
      else if("SparkListenerJobEnd".equals( event.getEvent() )) {
        long endTimestamp = event.getCompletionTime();
        long elapsed = endTimestamp - submissionTime;
        sb.append( "Ended: " ).append( (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format( new Date(endTimestamp) ) ).append(" (").append(elapsed/1000).append("s) ").append( "\n" )
          .append( "Job Result: " ).append( event.getJobResult().getResult() ).append( "\n" );
        if ( event.getJobResult().getException() != null ){
          sb.append( "Exception: " ).append( event.getJobResult().getException().getMessage() ).append( "\n" );
        }
      }
    }
    System.out.println(sb.toString());
  }
}
