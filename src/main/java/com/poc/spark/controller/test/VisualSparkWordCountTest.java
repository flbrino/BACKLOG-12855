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
  private boolean iskerberos = false;
  private String serverUser = null;
  private String keytab = null;
  private String[] applicationArgs = null;

  public VisualSparkWordCountTest( String applicationName, String applicationJar, String applicationMainClass,
      boolean kerberos, String serverUser, String keytab, String[] applicationArgs ) {
    this.applicationName = applicationName;
    this.applicationJar = applicationJar;
    this.applicationMainClass = applicationMainClass;
    this.iskerberos = kerberos;
    this.serverUser = serverUser;
    this.keytab = keytab;
    this.applicationArgs = applicationArgs;
  }

  public void run() {
    try {
      run( new InvokeFunction() {
        @Override void call( JobClient client ) throws Exception {
          ApplicationHandle
              handler =
              client.submit(
                  new SparkSubmitJob( applicationName, applicationJar, applicationMainClass, iskerberos,  serverUser,
                      keytab, applicationArgs ) );
          //wait for process
          try {
            while ( handler.isAlive() ) {
              Thread.sleep( 20000 );
            }
          } catch ( Exception e ) {
            /*ignore*/
          }
          handler.processSparkLog();
          handler.freeResources();
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

  //easy testing
  private static String[] setArgs() {
    String applicationName = "VisualSparkRunningWordCount";
    String applicationJar = "file:/c://TestNoLibs/pentaho-spark-TRUNK-SNAPSHOT.jar";
    String applicationMainClass = "org.pentaho.di.spark.VisualSpark";
    String applicationArgs = "hdfs://svqxbdcn6cdh58secure-n2.pentahoqa.com:8020/user/devuser/wordcount/wordcount.ktr";
    String kerberos = "true";
    String serverUser = "devuser@PENTAHOQA.COM";
    String keytab = "C://Users/fcamara/devuser_pentahoqa.keytab";

    return new String[] { applicationName, applicationJar, applicationMainClass, kerberos, serverUser,
        keytab, applicationArgs };

  }

  public static void main( String[] args ) {
    String[] argsAux = args;
    if ( argsAux == null || argsAux.length == 0 ) {
      argsAux = setArgs();
    }

    if ( argsAux.length < 4 ) {
      System.out.println( "Wrong number of arguments" );
    }

    String applicationName = argsAux[0];
    String applicationJar = argsAux[1];
    String applicationMainClass = argsAux[2];
    boolean kerberos = "true".equals( argsAux[3] );
    String serverUser = null;
    String keytab = null;
    int fixedArgssize = 6;
    if ( kerberos ) {
      fixedArgssize = 4;
      serverUser = argsAux[4];
      keytab = argsAux[5];
    }

    String[] applicationArgs = null;
    if ( argsAux.length > fixedArgssize ) {
      applicationArgs = new String[argsAux.length - fixedArgssize];
      for ( int i = fixedArgssize; i < argsAux.length; i++ ) {
        applicationArgs[i - fixedArgssize] = argsAux[i];
      }
    }
    new VisualSparkWordCountTest( applicationName, applicationJar, applicationMainClass, kerberos, serverUser, keytab,
        applicationArgs ).run();
  }
}
