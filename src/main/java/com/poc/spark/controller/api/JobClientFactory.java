package com.poc.spark.controller.api;

import java.util.Properties;

/**
 * Created by fcamara
 */
public interface JobClientFactory {

  JobClient createClient(InvokeType invokeType, Properties config);

}
