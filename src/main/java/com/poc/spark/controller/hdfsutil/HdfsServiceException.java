package com.poc.spark.controller.hdfsutil;

/**
 * HDFS Service Exception
 * <p>
 * Created by ccaspanello on 11/8/2016.
 */
public class HdfsServiceException extends RuntimeException {

  public HdfsServiceException(String msg) {
    super(msg);
  }

  public HdfsServiceException(String msg, Throwable throwable) {
    super(msg, throwable);
  }

}
