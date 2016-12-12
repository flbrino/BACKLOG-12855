package com.poc.spark.controller.sparkevent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fcamara.
 */
public class SparkProperties {
  @SerializedName( "spark.shuffle.spill.compress" )
  private String sparkShuffleSpillCompress = null;
  @SerializedName( "spark.r.command" )
  private String sparkRCommand = null;
  @SerializedName( "spark.port.maxRetries" )
  private String sparkPortMaxRetries = null;
  @SerializedName( "spark.admin.acls.groups" )
  private String sparkAdminACLSGroups = null;
  @SerializedName( "spark.serializer" )
  private String sparkSerializer = null;
  @SerializedName( "spark.streaming.backpressure.enabled" )
  private String sparkStreamingBackpressureEnabled = null;
  @SerializedName( "spark.sql.ui.retainedExecutions" )
  private String sparkSqlUIRetainedExecutions = null;
  @SerializedName( "spark.admin.acls" )
  private String sparAdminACLS = null;

  public String getSparkShuffleSpillCompress() {
    return sparkShuffleSpillCompress;
  }

  public void setSparkShuffleSpillCompress( String sparkShuffleSpillCompress ) {
    this.sparkShuffleSpillCompress = sparkShuffleSpillCompress;
  }

  public String getSparkRCommand() {
    return sparkRCommand;
  }

  public void setSparkRCommand( String sparkRCommand ) {
    this.sparkRCommand = sparkRCommand;
  }

  public String getSparkPortMaxRetries() {
    return sparkPortMaxRetries;
  }

  public void setSparkPortMaxRetries( String sparkPortMaxRetries ) {
    this.sparkPortMaxRetries = sparkPortMaxRetries;
  }

  public String getSparkAdminACLSGroups() {
    return sparkAdminACLSGroups;
  }

  public void setSparkAdminACLSGroups( String sparkAdminACLSGroups ) {
    this.sparkAdminACLSGroups = sparkAdminACLSGroups;
  }

  public String getSparkSerializer() {
    return sparkSerializer;
  }

  public void setSparkSerializer( String sparkSerializer ) {
    this.sparkSerializer = sparkSerializer;
  }

  public String getSparkStreamingBackpressureEnabled() {
    return sparkStreamingBackpressureEnabled;
  }

  public void setSparkStreamingBackpressureEnabled( String sparkStreamingBackpressureEnabled ) {
    this.sparkStreamingBackpressureEnabled = sparkStreamingBackpressureEnabled;
  }

  public String getSparkSqlUIRetainedExecutions() {
    return sparkSqlUIRetainedExecutions;
  }

  public void setSparkSqlUIRetainedExecutions( String sparkSqlUIRetainedExecutions ) {
    this.sparkSqlUIRetainedExecutions = sparkSqlUIRetainedExecutions;
  }

  public String getSparAdminACLS() {
    return sparAdminACLS;
  }

  public void setSparAdminACLS( String sparAdminACLS ) {
    this.sparAdminACLS = sparAdminACLS;
  }
}
