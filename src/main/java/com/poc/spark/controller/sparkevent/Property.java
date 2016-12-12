package com.poc.spark.controller.sparkevent;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by fcamara.
 */
public class Property {
  @SerializedName( "spark.sql.execution.id" )
  private Long sparkSQLExecutionID = null;

  public Long getSparkSQLExecutionID() {
    return sparkSQLExecutionID;
  }

  public void setSparkSQLExecutionID( Long sparkSQLExecutionID ) {
    this.sparkSQLExecutionID = sparkSQLExecutionID;
  }

}
