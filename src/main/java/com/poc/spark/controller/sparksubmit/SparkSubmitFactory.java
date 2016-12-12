package com.poc.spark.controller.sparksubmit;

import com.poc.spark.controller.api.InvokeType;
import com.poc.spark.controller.api.JobClient;
import com.poc.spark.controller.api.JobClientFactory;
import com.poc.spark.controller.conf.KettleConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

import static com.poc.spark.controller.api.InvokeType.*;

/**
 * Created by fcamara
 */
public class SparkSubmitFactory implements JobClientFactory {
  private static final Logger LOG = LoggerFactory.getLogger(SparkSubmitFactory.class);

  @Override public JobClient createClient( InvokeType invokeType, Properties config ) {
    if(invokeType == null || !SPARK_SUBMIT.getKey().equals( invokeType.getKey() ) ) {
      return null;
    }

    //Kettle Configuration
    KettleConf kettleConf = new KettleConf( config );

    return new SparkSubmitClient( kettleConf );
  }
}
