package com.poc.spark.controller.api;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.hive.HiveContext;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import java.io.File;

/**
 * Created by fcamara
 */
public interface JobContext {
  /** The shared SparkContext instance. */
  JavaSparkContext sc();

  /** The shared SQLContext inststance. */
  SQLContext sqlctx();

  /** The shared HiveContext inststance. */
  HiveContext hivectx();

  /** Returns the JavaStreamingContext which has already been created. */
  JavaStreamingContext streamingctx();

  /**
   * Creates the SparkStreaming context.
   *
   * @param batchDuration Time interval at which streaming data will be divided into batches,
   *                      in milliseconds.
   */
  void createStreamingContext(long batchDuration);

  /** Stops the SparkStreaming context. */
  void stopStreamingCtx();

  /**
   * Returns a local tmp dir specific to the context
   */
  File getLocalTmpDir();

}