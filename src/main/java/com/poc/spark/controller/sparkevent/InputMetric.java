package com.poc.spark.controller.sparkevent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fcamara.
 */
public class InputMetric {
  @SerializedName( "Bytes Read" )
  private Long bytesRead = null;
  @SerializedName( "Records Read" )
  private Long recordsRead = null;

  public Long getBytesRead() {
    return bytesRead;
  }

  public void setBytesRead( Long bytesRead ) {
    this.bytesRead = bytesRead;
  }

  public Long getRecordsRead() {
    return recordsRead;
  }

  public void setRecordsRead( Long recordsRead ) {
    this.recordsRead = recordsRead;
  }
}
