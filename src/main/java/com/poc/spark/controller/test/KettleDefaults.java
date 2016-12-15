package com.poc.spark.controller.test;

import com.poc.spark.controller.conf.KettleConfEntry;

import java.util.Properties;

/**
 * Created by fcamara
 */
public class KettleDefaults {
  public static Properties getKettleDefaults(String eventLogDir) {
    Properties prop = new Properties();
    //SET KETTLE
    prop.setProperty( KettleConfEntry.SPARK_JARS.key(),
        "file:////C://TestNoLibs/kettle-engine-7.1-SNAPSHOT.jar,file:////C://TestNoLibs/kettle-core-7.1-SNAPSHOT.jar,file:////C://TestNoLibs/commons-vfs2-2.1-20150824.jar,file:////C://TestNoLibs/metastore-7.1-SNAPSHOT.jar,file:////C://TestNoLibs/esapi-2.0.1.jar" );

    //EVENT LOG
    prop.setProperty( KettleConfEntry.SPARK_EVENTLOG_ENABLED.key(), Boolean.TRUE.toString() );
    prop.setProperty( KettleConfEntry.SPARK_EVENTLOG_DIR.key(),
        (eventLogDir == null || eventLogDir.isEmpty()) ?
            "hdfs://svqxbdcn6cdh58secure-n2.pentahoqa.com:8020/user/spark/applicationHistory" :
        eventLogDir
         );

    //YARN MODE
    prop.setProperty( KettleConfEntry.SPARK_MASTER.key(), "yarn" );

    //SPARK LIBS
    prop.setProperty( KettleConfEntry.SPARK_YARN_ARCHIVE.key(),
        "hdfs://svqxbdcn6cdh58secure-n2.pentahoqa.com:8020/user/devuser/fcamara/sparkLib" );

    //DEPLOY MODE
    prop.setProperty( KettleConfEntry.SPARK_SUBMIT_DEPLOYMODE.key(), "cluster" );

    //SPARK REST API
    prop.setProperty( "SPARK_RST_API",
        "http://svqxbdcn6cdh58secure-n2.pentahoqa.com:18088/api/v1/" );

    return prop;
  }
}
