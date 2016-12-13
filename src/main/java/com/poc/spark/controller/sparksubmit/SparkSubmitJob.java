package com.poc.spark.controller.sparksubmit;

import com.google.common.io.Files;
import com.poc.spark.controller.api.Job;
import com.poc.spark.controller.hdfsutil.NamedCluster;

import java.io.File;

/**
 * Created by fcamara
 */

public class SparkSubmitJob implements Job {

  private NamedCluster namedCluster;
  private String applicationName;
  private String applicationJar;
  private String applicationMainClass;
  private boolean kerberos = false;
  private String serverUser = null;
  private String keytab = null;
  private String[] args;
  private File tempDirectory;

  public SparkSubmitJob( String applicationName, String applicationJar, String applicationMainClass, boolean kerberos,
      String serverUser, String keytab, String[] args ) {
    this.applicationName = applicationName;
    this.applicationJar = applicationJar;
    this.applicationMainClass = applicationMainClass;
    this.kerberos = kerberos;
    this.serverUser = serverUser;
    this.keytab = keytab;
    this.args = args;
  }

  @Override public NamedCluster getNamedCluster() {
    return namedCluster;
  }

  @Override public String getApplicationName() {
    return applicationName;
  }

  @Override public String getApplicationJar() {
    return applicationJar;
  }

  @Override public String getApplicationMainClass() {
    return applicationMainClass;
  }

  @Override public String[] getArgs() {
    return args;
  }

  @Override public File getTempDirectory() {
    if ( tempDirectory == null ) {
      tempDirectory = Files.createTempDir();
    }
    return tempDirectory;
  }

  public boolean isKerberos() {
    return kerberos;
  }

  public String getServerUser() {
    return serverUser;
  }

  public String getKeytab() {
    return keytab;
  }
}
