package com.poc.spark.controller.sparksubmit;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by fcamara
 */
public class SparkRestApiClient {

  public static boolean getLogAndUnzip( String applicationID, String restApiUrl, File tempdir ) throws IOException {
    HttpUriRequest request = new HttpGet( restApiUrl + "applications/" + applicationID + "/logs" );
    HttpResponse response = HttpClientBuilder.create().build().execute( request );

    if ( response.getStatusLine().getStatusCode() != HttpStatus.SC_OK ) {
      return false;
    }

    InputStream is = response.getEntity().getContent();
    FileOutputStream fos = new FileOutputStream( tempdir.getAbsolutePath() + File.separator + applicationID + ".zip" );
    int read = 0;
    byte[] buffer = new byte[32768];
    while ( ( read = is.read( buffer ) ) > 0 ) {
      fos.write( buffer, 0, read );
    }
    fos.close();
    is.close();

    ZipInputStream
        zis =
        new ZipInputStream(
            new FileInputStream( tempdir.getAbsolutePath() + File.separator + applicationID + ".zip" ) );

    ZipEntry ze = null;
    while ( ( ze = zis.getNextEntry() ) != null ) {
      String fileName = ze.getName();
      File newFile = new File( tempdir + File.separator + fileName );

      System.out.println( "file unzip : " + newFile.getAbsoluteFile() );
      fos = new FileOutputStream( newFile );

      int len;
      while ( ( len = zis.read( buffer ) ) > 0 ) {
        fos.write( buffer, 0, len );
      }
      fos.close();
    }
    zis.close();
    return true;
  }
}
