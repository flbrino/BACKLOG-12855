package com.poc.spark.controller.test;

import com.poc.spark.controller.api.ApplicationHandle;
import com.poc.spark.controller.api.JobClient;
import com.poc.spark.controller.api.JobClientBuilder;
import com.poc.spark.controller.sparksubmit.SparkSubmitJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.poc.spark.controller.api.InvokeType.SPARK_SUBMIT;

/**
 * Created by fcamara
 */
public class VisualSparkWordCountTest {

  private static final Logger LOG = LoggerFactory.getLogger( VisualSparkWordCountTest.class );

  private String applicationName = null;
  private String applicationJar = null;
  private String applicationMainClass = null;
  private String[] applicationArgs = null;

  public VisualSparkWordCountTest( String applicationName, String applicationJar, String applicationMainClass,
      String[] applicationArgs ) {
    this.applicationName = applicationName;
    this.applicationJar = applicationJar;
    this.applicationMainClass = applicationMainClass;
    this.applicationArgs = applicationArgs;
  }

  public void run() {
    try {
      run( new InvokeFunction() {
        @Override void call( JobClient client ) throws Exception {
          ApplicationHandle
              handler =
              client.submit(
                  new SparkSubmitJob( applicationName, applicationJar, applicationMainClass, applicationArgs ) );
          //wait for process
          try {
            while ( handler.isAlive() ) {
              Thread.sleep( 20000 );
            }
          } catch ( Exception e ) {
            /*ignore*/
          }

        }
      } );
    } catch ( Exception e ) {
      LOG.error( e.getMessage(), e );
    }
  }

  private void run( InvokeFunction invokeFunction ) throws Exception {
    JobClient client = null;
    try {
      client = new JobClientBuilder( false, SPARK_SUBMIT ).build();
      // Wait for the context to be up before running the test.
      invokeFunction.call( client );
    } catch ( Exception e ) {
      LOG.error( "Test threw exception.", e );
      throw e;
    } finally {
      if ( client != null ) {
        client.stopProcess();
      }
    }
  }

  private static String[] setArgs() {
    return new String[] { "VisualSparkRunningWordCount", "file:/c://TestNoLibs/pentaho-spark-TRUNK-SNAPSHOT.jar",
        "org.pentaho.di.spark.VisualSpark",
        "hdfs://svqxbdcn6cdh58secure-n2.pentahoqa.com:8020/user/devuser/wordcount/wordcount.ktr" };

  }

  public static void main( String[] args ) {
    args = setArgs();
    if ( args.length < 3 ) {
      System.out.println( "Wrong number of arguments" );
      System.out.println(
          "VisualSparkWordCountTest [applicationName] [applicationJar] [applicationMainClass] [applicationArgs1] ..." );
    }

    String applicationName = args[0];
    String applicationJar = args[1];
    String applicationMainClass = args[2];

    String[] applicationArgs = null;
    if ( args.length > 3 ) {
      applicationArgs = new String[args.length - 3];
      for ( int i = 3; i < args.length; i++ ) {
        applicationArgs[i - 3] = args[i];
      }
    }

    new VisualSparkWordCountTest( applicationName, applicationJar, applicationMainClass, applicationArgs ).run();

  }
}
