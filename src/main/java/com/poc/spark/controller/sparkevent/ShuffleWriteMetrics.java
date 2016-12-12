package com.poc.spark.controller.sparkevent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fcamara.
 */
public class ShuffleWriteMetrics {
  @SerializedName( "Shuffle Bytes Written" )
  private Long shuffleBytesWritten = null;
  @SerializedName( "Shuffle Write Time" )
  private Long shuffleWriteTime = null;

  public Long getShuffleBytesWritten() {
    return shuffleBytesWritten;
  }

  public void setShuffleBytesWritten( Long shuffleBytesWritten ) {
    this.shuffleBytesWritten = shuffleBytesWritten;
  }

  public Long getShuffleWriteTime() {
    return shuffleWriteTime;
  }

  public void setShuffleWriteTime( Long shuffleWriteTime ) {
    this.shuffleWriteTime = shuffleWriteTime;
  }

  public Long getShuffleRecordsWritten() {
    return shuffleRecordsWritten;
  }

  public void setShuffleRecordsWritten( Long shuffleRecordsWritten ) {
    this.shuffleRecordsWritten = shuffleRecordsWritten;
  }

  @SerializedName( "Shuffle Records Written" )
  private Long shuffleRecordsWritten = null;
}
