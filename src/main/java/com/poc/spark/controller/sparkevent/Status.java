package com.poc.spark.controller.sparkevent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fcamara.
 */
public class Status {
  @SerializedName( "Storage Level" )
  private StorageLevel storageLevel = null;
  @SerializedName( "Memory Size" )
  private Long memorySize = null;
  @SerializedName( "Disk Size" )
  private Long diskSize = null;
}
