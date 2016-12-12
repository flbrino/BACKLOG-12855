package com.poc.spark.controller.sparkevent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fcamara.
 */
public class OutputMetrics {
  @SerializedName( "Bytes Read" )
  private Long bytesRead = null;
  @SerializedName( "Records Written" )
  private Long recordsWritten = null;

  public Long getBytesRead() {
    return bytesRead;
  }

  public void setBytesRead( Long bytesRead ) {
    this.bytesRead = bytesRead;
  }

  public Long getRecordsWritten() {
    return recordsWritten;
  }

  public void setRecordsWritten( Long recordsWritten ) {
    this.recordsWritten = recordsWritten;
  }
}
