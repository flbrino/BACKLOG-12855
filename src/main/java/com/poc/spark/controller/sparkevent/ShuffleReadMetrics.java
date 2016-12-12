package com.poc.spark.controller.sparkevent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fcamara.
 */
public class ShuffleReadMetrics {
  @SerializedName( "Remote Blocks Fetched" )
  private Long remoteBlocksFetched = null;
  @SerializedName( "Local Blocks Fetched" )
  private Long localBlocksFetched = null;
  @SerializedName( "Fetch Wait Time" )
  private Long fetchWaitTime = null;
  @SerializedName( "Remote Bytes Read" )
  private Long remoteBytesRead = null;
  @SerializedName( "Local Bytes Read" )
  private Long localBytesRead = null;
  @SerializedName( "Total Records Read" )
  private Long totalRecordsRead = null;


}
