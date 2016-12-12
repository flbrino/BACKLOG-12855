package com.poc.spark.controller.hdfsutil;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.security.UserGroupInformation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Named Cluster
 * <p>
 * Handles configuration of a named cluster using Site files and optional overrides.
 * <p>
 * Created by ccaspanello on 11/8/2016.
 */
public class NamedCluster {

  private final String id;
  private String name;
  private String hadoopConfDir;
  private String sparkClient;
  private Map<String, String> overrides;

  // TODO Revisit putting these variables with the named cluster.
  private String sparkHome;
  private String sparkHomeLib;
  private String pdiHome;
  private String jarFile;
  private String mainClass;

  public NamedCluster(String name) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.overrides = new HashMap<>();
  }

  public Configuration configuration() throws IOException{
    Configuration config = new Configuration();
    // Add Original Configuration
    if (hadoopConfDir != null) {
      addResource(config, "core-site.xml");
      addResource(config, "hbase-site.xml");
      addResource(config, "hdfs-site.xml");
      addResource(config, "hive-site.xml");
      addResource(config, "mapred-site.xml");
      addResource(config, "yarn-site.xml");
    }

    // Add Overrides
    for (String key : overrides.keySet()) {
      config.set(key, overrides.get(key));
    }

    org.apache.hadoop.conf.Configuration conf = new
        org.apache.hadoop.conf.Configuration();
    conf.set("hadoop.security.authentication", "Kerberos");
    UserGroupInformation.setConfiguration(conf);
    UserGroupInformation.loginUserFromKeytab("devuser@PENTAHOQA.COM", "C://Users/fcamara/devuser_pentahoqa.keytab");
    return config;
  }

  private void addResource(Configuration config, String filename) {
    try {
      File file = new File(hadoopConfDir, filename);
      InputStream inputStream = new FileInputStream(file);
      config.addResource(inputStream);
    } catch (IOException e) {
      throw new RuntimeException("Unablee to add " + filename + " to Hadoop Configuration.", e);
    }
  }

  public Path sparkHomePath() {
    return new Path(sparkHome);
  }

  public File pdiHomeFile() {
    return new File(pdiHome);
  }

  //<editor-fold desc="Getters & Setters">
  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHadoopConfDir() {
    return hadoopConfDir;
  }

  public void setHadoopConfDir(String hadoopConfDir) {
    this.hadoopConfDir = hadoopConfDir;
  }

  public String getSparkClient() {
    return sparkClient;
  }

  public void setSparkClient(String sparkClient) {
    this.sparkClient = sparkClient;
  }

  public Map<String, String> getOverrides() {
    return overrides;
  }

  public void setOverrides(Map<String, String> overrides) {
    this.overrides = overrides;
  }

  public String getSparkHome() {
    return sparkHome;
  }

  public void setSparkHome(String sparkHome) {
    this.sparkHome = sparkHome;
  }

  public String getSparkHomeLib() {
    return sparkHomeLib;
  }

  public void setSparkHomeLib(String sparkHomeLib) {
    this.sparkHomeLib = sparkHomeLib;
  }

  public String getPdiHome() {
    return pdiHome;
  }

  public void setPdiHome(String pdiHome) {
    this.pdiHome = pdiHome;
  }

  public String getJarFile() {
    return jarFile;
  }

  public void setJarFile(String jarFile) {
    this.jarFile = jarFile;
  }

  public String getMainClass() {
    return mainClass;
  }

  public void setMainClass(String mainClass) {
    this.mainClass = mainClass;
  }
  //</editor-fold>
}
