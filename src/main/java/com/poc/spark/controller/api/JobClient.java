package com.poc.spark.controller.api;

import java.io.File;
import java.net.URI;
import java.util.concurrent.Future;

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
  <T> void submit(Job<T> job);

  void waitForProcess();

  void stopProcess();

}
