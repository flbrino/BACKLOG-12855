package com.poc.spark.controller.sparksubmit;

import org.slf4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * Created by fcamara
 */
public class Redirector implements Runnable {
  private final Logger logger;
  private final BufferedReader in;

  public Redirector( InputStream in, Logger logger) {
    this.in = new BufferedReader( new InputStreamReader( in ) ); this.logger = logger;
  }

  @Override public void run() {
    try {
      String line = null;
      while ( ( line = in.readLine() ) != null ) {
        logger.info( line );
      }
    } catch ( Exception e ) {
      logger.warn( "Error in redirector thread.", e );
    }

    try {
      in.close();
    } catch ( IOException ioe ) {
      logger.warn( "Error closing child stream.", ioe );
    }
  }

}
