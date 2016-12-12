package com.poc.spark.controller.api;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.ServiceLoader;
import static java.nio.charset.StandardCharsets.UTF_8;
import static com.poc.spark.controller.api.InvokeType.*;

/**
 * Created by fcamara
 */
public final class JobClientBuilder {

  private final Properties config;
  private static final String SPARK_CONF = "spark-defaults.conf";
  private final InvokeType invokeType;

  /**
   * Creates a new builder that will automatically load the Spark configuration
   * from the classpath.
   */
  public JobClientBuilder(InvokeType invokeType) throws IOException {
    this(true, invokeType);
  }

  public JobClientBuilder(boolean loadDefaults, InvokeType invokeType) throws IOException {
    this.config = new Properties();
    this.invokeType = invokeType;

    if (loadDefaults) {
      URL url = classLoader().getResource(SPARK_CONF);
      if (url != null) {
        Reader r = new InputStreamReader(url.openStream(), UTF_8);
        try {
          config.load(r);
        } finally {
          r.close();
        }
      }
    }
  }

  public JobClientBuilder setConf(String key, String value) {
    if (value != null) {
      config.setProperty(key, value);
    } else {
      config.remove(key);
    }
    return this;
  }

  public JobClientBuilder setAll(Map<String, String> props) {
    config.putAll(props);
    return this;
  }

  public JobClientBuilder setAll(Properties props) {
    config.putAll(props);
    return this;
  }

  public JobClient build() {
    JobClient client = null;
    ServiceLoader<JobClientFactory> loader = ServiceLoader.load(JobClientFactory.class,
        classLoader());
    if (!loader.iterator().hasNext()) {
      throw new IllegalStateException("No Clients implementation was found.");
    }

    for (JobClientFactory factory : loader) {
      try {
        client = factory.createClient( invokeType, config );
      } catch ( Exception e ) {
        if ( !( e instanceof RuntimeException ) ) {
          e = new RuntimeException( e );
        }
        throw (RuntimeException) e;
      }
      if ( client != null ) {
        break;
      }
    }
    return client;
  }

  private ClassLoader classLoader() {
    ClassLoader cl = Thread.currentThread().getContextClassLoader();
    if (cl == null) {
      cl = getClass().getClassLoader();
    }
    return cl;
  }

}
