package com.poc.spark.controller.api;

import com.poc.spark.controller.hdfsutil.NamedCluster;

import java.io.File;
import java.io.Serializable;

/**
 * Created by fcamara
 */
public interface Job extends Serializable {

  NamedCluster getNamedCluster();

  String getApplicationName();

  String getApplicationJar();

  String getApplicationMainClass();

  String[] getArgs();

  File getTempDirectory();

}
