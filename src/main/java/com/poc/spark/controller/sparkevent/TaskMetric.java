package com.poc.spark.controller.sparkevent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fcamara.
 */
public class TaskMetric {
  @SerializedName( "Executor Deserialize Time" )
  private Long executorDeserializeTime = null;
  @SerializedName( "Executor Run Time" )
  private Long executorRunTime = null;
  @SerializedName( "Result Size" )
  private Long resultSize = null;
  @SerializedName( "JVM GC Time" )
  private Long jvmGCTime = null;
  @SerializedName( "Result Serialization Time" )
  private Long resultSerializationTime = null;
  @SerializedName( "Memory Bytes Spilled" )
  private Long memoryBytesSpilled = null;
  @SerializedName( "Disk Bytes Spilled" )
  private Long diskBytesSpilled = null;
  @SerializedName( "Shuffle Read Metrics" )
  private ShuffleReadMetrics shuffleReadMetrics;
  @SerializedName( "Shuffle Write Metrics" )
  private ShuffleWriteMetrics shuffleWriteMetrics;
  @SerializedName( "Input Metrics" )
  private InputMetric inputMetrics;
  @SerializedName( "Output Metrics" )
  private InputMetric outputMetrics;
  @SerializedName( "Updated Blocks" )
  private InputMetric[] updatedBlocks;

}
