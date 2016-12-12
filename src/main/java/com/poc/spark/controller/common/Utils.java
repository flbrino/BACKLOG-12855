package com.poc.spark.controller.common;

import com.poc.spark.controller.conf.KettleConf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;
import java.util.Properties;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by fcamara
 */
public class Utils {
  private static final String SPARK_DEFAULT_FILENAME = "spark-defaults";
  private static final String SPARK_DEFAULT_EXT = ".conf";

  /**
   * Write the configuration to a file readable only by the process's owner.
   */
  public static File writeConfToFile( File parentTempDir, Properties conf ) throws IOException {
    File file = File.createTempFile( SPARK_DEFAULT_FILENAME, SPARK_DEFAULT_EXT, parentTempDir );
    Writer writer = new OutputStreamWriter( new FileOutputStream( file ), UTF_8 );
    try {
      conf.store( writer, "Spark Submit App Context Configuration" );
    } finally {
      writer.close();
    }
    return file;
  }

  public static File writeConfToFile( File parentTempDir, KettleConf conf ) throws IOException {
    Properties confView = new Properties();
    for ( Map.Entry<String, String> e : conf ) {
      String key = e.getKey();
      if ( key.startsWith( KettleConf.SPARK_CONF_PREFIX ) ) {
        confView.setProperty( key, e.getValue() );
      }
    }
    return writeConfToFile( parentTempDir, confView );
  }
}
