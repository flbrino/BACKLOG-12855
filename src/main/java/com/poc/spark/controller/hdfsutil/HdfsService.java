package com.poc.spark.controller.hdfsutil;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.IOException;


/**
 * HDFS Service
 * <p>
 * Service designed to perform HDFS services using the the Hadoop libraries.  Configurable by injecting a NamedCluster
 * object.
 * <p>
 */
public class HdfsService {

  private static final Logger LOG = LoggerFactory.getLogger(HdfsService.class);

  public FileSystem fs;

  @Inject
  public HdfsService(NamedCluster namedCluster) {
    String clusterName = namedCluster.getName();
    try {
      LOG.info("Creating HDFS Service Cluster: {}", clusterName);
      fs = FileSystem.get(namedCluster.configuration());
    } catch (IOException e) {
      throw new HdfsServiceException("Unable to create HDFS Service for cluster: " + clusterName, e);
    }
  }

  public FileStatus[] list(Path path) {
    try {
      LOG.trace("list(path: {})", path);
      return fs.listStatus(path);
    } catch (IOException e) {
      String msg = String.format("Unexpected error calling: list(%s)", path);
      throw new HdfsServiceException(msg, e);
    }
  }

  public boolean mkdirs(Path path) {
    try {
      LOG.trace("mkdirs(path: {})", path);
      return fs.mkdirs(path);
    } catch (IOException e) {
      String msg = String.format("Unexpected error calling: mkdris(%s)", path);
      throw new HdfsServiceException(msg, e);
    }
  }

  public boolean delete(Path path, boolean recursive) {
    try {
      LOG.trace("delete(path: {})", path);
      return fs.delete(path, recursive);
    } catch (IOException e) {
      String msg = String.format("Unexpected error calling: delete(%s, %s)", path, recursive);
      throw new HdfsServiceException(msg, e);
    }
  }

  public FSDataOutputStream create(Path path) {
    try {
      LOG.trace("create(path: {})", path);
      return fs.create(path);
    } catch (IOException e) {
      String msg = String.format("Unexpected error calling: create(%s)", path);
      throw new HdfsServiceException(msg, e);
    }
  }

  public void copyFromLocalFile(Path source, Path destination) {
    try {
      LOG.trace("copyFromLocalFile(source: {}, destination: {})", source, destination);
      fs.copyFromLocalFile(source, destination);
    } catch (IOException e) {
      String msg = String.format("Unexpected error calling: copyFromLocalFile(%s, %s)", source, destination);
      throw new HdfsServiceException(msg, e);
    }
  }

  public void copyToLocalFile(boolean delSrc, Path source, Path destination) {
    try {
      LOG.trace("copyToLocalFile(source: {}, destination: {})", source, destination);
      fs.copyToLocalFile(delSrc, source, destination);
    } catch (IOException e) {
      String msg = String.format("Unexpected error calling: copyFromLocalFile(%s, %s)", source, destination);
      throw new HdfsServiceException(msg, e);
    }
  }

  public FileStatus getFileStatus(Path path) {
    try {
      LOG.trace("getFileStatus(path: {})", path);
      return fs.getFileStatus(path);
    } catch (IOException e) {
      String msg = String.format("Unexpected error calling: getFileStatus(%s)", path);
      throw new HdfsServiceException(msg, e);
    }
  }


  public boolean exists(Path path) {
    try {
      LOG.trace("exists(path: {})", path);
      return fs.exists(path);
    } catch (IOException e) {
      String msg = String.format("Unexpected error calling: exists(%s)", path);
      throw new HdfsServiceException(msg, e);
    }
  }
}
