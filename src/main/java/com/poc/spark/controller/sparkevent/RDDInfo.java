package com.poc.spark.controller.sparkevent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fcamara.
 */
public class RDDInfo {
  @SerializedName( "RDD ID" )
  private Long rddID;
  @SerializedName( "Name" )
  private String name;
  @SerializedName( "Scope" )
  private String scope = null;
  @SerializedName( "Callsite" )
  private String callsite = null;
  @SerializedName( "Parent IDs" )
  private Long[] parentID = null;
  @SerializedName( "Storage Level" )
  private StorageLevel storageLevel = null;
  @SerializedName( "Number of Partitions" )
  private Integer numberOfPartitions;
  @SerializedName( "Number of Cached Partitions" )
  private Integer numberOfCachedPartitions;
  @SerializedName( "Memory Size" )
  private Long memorySize;
  @SerializedName( "Disk Size" )
  private Long diskSize;

  public Long getRddID() {
    return rddID;
  }

  public void setRddID( Long rddID ) {
    this.rddID = rddID;
  }

  public String getName() {
    return name;
  }

  public void setName( String name ) {
    this.name = name;
  }

  public String getScope() {
    return scope;
  }

  public void setScope( String scope ) {
    this.scope = scope;
  }

  public String getCallsite() {
    return callsite;
  }

  public void setCallsite( String callsite ) {
    this.callsite = callsite;
  }

  public Long[] getParentID() {
    return parentID;
  }

  public void setParentID( Long[] parentID ) {
    this.parentID = parentID;
  }

  public StorageLevel getStorageLevel() {
    return storageLevel;
  }

  public void setStorageLevel( StorageLevel storageLevel ) {
    this.storageLevel = storageLevel;
  }

  public Integer getNumberOfPartitions() {
    return numberOfPartitions;
  }

  public void setNumberOfPartitions( Integer numberOfPartitions ) {
    this.numberOfPartitions = numberOfPartitions;
  }

  public Integer getNumberOfCachedPartitions() {
    return numberOfCachedPartitions;
  }

  public void setNumberOfCachedPartitions( Integer numberOfCachedPartitions ) {
    this.numberOfCachedPartitions = numberOfCachedPartitions;
  }

  public Long getMemorySize() {
    return memorySize;
  }

  public void setMemorySize( Long memorySize ) {
    this.memorySize = memorySize;
  }

  public Long getDiskSize() {
    return diskSize;
  }

  public void setDiskSize( Long diskSize ) {
    this.diskSize = diskSize;
  }
}
