package com.poc.spark.controller.common;

import com.poc.spark.controller.conf.ConfEntry;

/**
 * Created by fcamara
 */
public enum EnvironmentProperty implements ConfEntry {

  SPARK_HOME_ENV( "SPARK_HOME", System.getenv( "SPARK_HOME" ) ), HADOOP_CONF_DIR_ENV( "HADOOP_CONF_DIR",
      System.getenv( "HADOOP_CONF_DIR" ) ), SPARK_CONF_DIR_ENV( "SPARK_CONF_DIR",
      System.getenv( "SPARK_CONF_DIR" ) ), HADOOP_HOME_ENV( "HADOOP_HOME",
      System.getenv( "HADOOP_HOME" ) ), SPARK_LIBS_ON_CLUSTER_ENV( "SPARK_LIBS_ON_CLUSTER",
      System.getenv( "SPARK_LIBS_ON_CLUSTER" ) ), SPARK_HOME_ON_CLUSTER_ENV( "SPARK_HOME_ON_CLUSTER",
      System.getenv( "SPARK_HOME_ON_CLUSTER" ) ), PDI_HOME_ENV( "PDI_HOME", System.getenv( "PDI_HOME" ) );

  private final String key;
  private final Object defaultValue;

  EnvironmentProperty( String key, Object defaultValue ) {
    this.key = key;
    this.defaultValue = defaultValue;
  }

  @Override public String key() {
    return key;
  }

  @Override public Object defaultValue() {
    return defaultValue;
  }
}
