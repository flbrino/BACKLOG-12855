package com.poc.spark.controller.test;

import com.poc.spark.controller.api.JobClient;

/**
 * Created by fcamara
 */
public abstract class InvokeFunction {

  abstract void call( JobClient client ) throws Exception;
}
