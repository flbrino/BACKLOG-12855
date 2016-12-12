package com.poc.spark.controller.conf;

import com.poc.spark.controller.common.EnvironmentProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Properties;

/**
 * Created by fcamara
 */
public class KettleConf extends ClientConf<KettleConf>{
  private static final Logger LOG = LoggerFactory.getLogger(KettleConf.class);
  public static final String SPARK_CONF_PREFIX = "spark.";

  public KettleConf(Properties config) {
    super(config);
    //setSparkDefaults();
    setEnvironmentDefaults();
    setKettleDefaults();
  }

  private void setSparkDefaults() {
    for ( KettleConfEntry conf : KettleConfEntry.values() ) {
      if( conf.defaultValue() != null) {
        set( conf, conf.defaultValue() );
      }
    }
  }

  private void setEnvironmentDefaults() {
    for ( EnvironmentProperty env : EnvironmentProperty.values() ) {
      if( env.defaultValue() != null) {
        set( env, env.defaultValue() );
      }
    }
  }

  private void setKettleDefaults() {
    //SET KETTLE
    set( KettleConfEntry.SPARK_JARS, "file:////C://TestNoLibs/kettle-engine-7.1-SNAPSHOT.jar,file:////C://TestNoLibs/kettle-core-7.1-SNAPSHOT.jar,file:////C://TestNoLibs/commons-vfs2-2.1-20150824.jar,file:////C://TestNoLibs/metastore-7.1-SNAPSHOT.jar,file:////C://TestNoLibs/esapi-2.0.1.jar" );

    //EVENT LOG
    set( KettleConfEntry.SPARK_EVENTLOG_ENABLED, Boolean.TRUE);
    set( KettleConfEntry.SPARK_EVENTLOG_DIR, "hdfs://svqxbdcn6cdh58secure-n2.pentahoqa.com:8020/user/devuser/eventLog");

    //YARN MODE
    set(KettleConfEntry.SPARK_MASTER, "yarn");

    //SPARK LIBS
    set(KettleConfEntry.SPARK_YARN_ARCHIVE , "hdfs://svqxbdcn6cdh58secure-n2.pentahoqa.com:8020/user/devuser/fcamara/sparkLib");

    //DEPLOY MODE
    set(KettleConfEntry.SPARK_SUBMIT_DEPLOYMODE, "cluster");
  }
}
