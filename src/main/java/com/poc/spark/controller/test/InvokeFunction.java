package com.poc.spark.controller.example;

import com.poc.spark.controller.api.JobClient;
import com.poc.spark.controller.conf.ClientConf;

/**
 * Created by fcamara
 */
public abstract class InvokeFunction {

    abstract void call( JobClient client ) throws Exception;
}
