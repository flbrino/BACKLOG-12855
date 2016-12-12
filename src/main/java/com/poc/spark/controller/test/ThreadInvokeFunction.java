package com.poc.spark.controller.example;

import com.poc.spark.controller.api.JobClient;

/**
 * Created by fcamara
 */
public abstract class ThreadInvokeFunction implements Runnable{

    abstract void call( JobClient client ) throws Exception;
    abstract void setClient (JobClient client);
}
