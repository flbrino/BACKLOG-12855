package com.poc.spark.controller.api;

/**
 * Created by fcamara
 */
public interface JobClient {

  /**
   * Submits a job
   *
   * @param job The job to execute.
   * @return A handle that be used to monitor the job.
   */
  ApplicationHandle submit( Job job );

  void stopProcess();

}
