package com.poc.spark.controller.api;

import java.io.Serializable;

/**
 * Created by fcamara
 */
public interface Job<T>  extends Serializable {

  T call(JobContext jc) throws Exception;

}
