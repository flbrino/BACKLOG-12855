package com.poc.spark.controller.conf;

import com.poc.spark.controller.common.EnvironmentProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Created by fcamara
 */
public class KettleConf extends ClientConf<KettleConf> {
  private static final Logger LOG = LoggerFactory.getLogger( KettleConf.class );
  public static final String SPARK_CONF_PREFIX = "spark.";

  public KettleConf( Properties config ) {
    super( config );
    //setSparkDefaults();
    setEnvironmentDefaults();
    setKettleDefaults();
  }

  private void setSparkDefaults() {
    for ( KettleConfEntry conf : KettleConfEntry.values() ) {
      if ( conf.defaultValue() != null ) {
        set( conf, conf.defaultValue() );
      }
    }
  }

  private void setEnvironmentDefaults() {
    for ( EnvironmentProperty env : EnvironmentProperty.values() ) {
      if ( env.defaultValue() != null ) {
        set( env, env.defaultValue() );
      }
    }
  }

  private void setKettleDefaults() {

  }
}
