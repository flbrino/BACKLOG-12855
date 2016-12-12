package com.poc.spark.controller.common;

import com.poc.spark.controller.conf.KettleConf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;
import java.util.Properties;

import static java.nio.charset.StandardCharsets.UTF_8;
import static com.poc.spark.controller.common.EnvironmentProperty.*;
/**
 * Created by fcamara
 */
public class Utils {
  private static final String SPARK_DEFAULT_FILENAME = "spark-defaults";
  private static final String SPARK_DEFAULT_EXT = ".conf";
  public static RuntimeException propagate(Throwable t) {
    if (t instanceof RuntimeException) {
      throw (RuntimeException) t;
    } else {
      throw new RuntimeException(t);
    }
  }

  /**
   * Write the configuration to a file readable only by the process's owner.
   */
  public static File writeConfToFile(Properties conf) throws IOException {
    File file = File.createTempFile(SPARK_DEFAULT_FILENAME, SPARK_DEFAULT_EXT);
    Writer writer = new OutputStreamWriter(new FileOutputStream(file), UTF_8);
    try {
      conf.store(writer, "Spark Submit App Context Configuration");
    } finally {
      writer.close();
    }
    return file;
  }

  public static File writeConfToFile(KettleConf conf) throws IOException {
    Properties confView = new Properties();
    for (Map.Entry<String, String> e : conf) {
      String key = e.getKey();
      if (key.startsWith(KettleConf.SPARK_CONF_PREFIX)) {
        confView.setProperty(key, e.getValue());
      }
    }
    return writeConfToFile( confView );
  }
}
