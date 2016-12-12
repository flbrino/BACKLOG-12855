package com.poc.spark.controller.sparkevent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fcamara.
 */
public class Accumulable {
  private Long ID = null;
  private String Name = null;
  //private Long Update = null;
  //@SerializedName( "Value" )
  private Long ValueNumber = null;
  @SerializedName( "Value" )
  private Value[] value = null;
  private Boolean Internal = null;
  @SerializedName( "Count Failed Values" )
  private Boolean countFailedValues = null;
  @SerializedName( "Update" )
  private Value[] update;
  //@SerializedName( "Update" )
  //private Long updateNumber;
  @SerializedName( "Metadata" )
  private String MetaData = null;

  public Long getID() {
    return ID;
  }

  public void setID( Long ID ) {
    this.ID = ID;
  }

  public String getName() {
    return Name;
  }

  public void setName( String name ) {
    Name = name;
  }

  /*
  public Long getUpdate() {
    return Update;
  }
*/
  public void setUpdate( Value[] update ) {
    this.update = update;
  }

  /*public Long getUpdateNumber() {
    return updateNumber;
  }

  public void setUpdateNumber( Long updateNumber ) {
    this.updateNumber = updateNumber;
  }*/

  public String getMetaData() {
    return MetaData;
  }

  public void setMetaData( String metaData ) {
    MetaData = metaData;
  }
/*
  public void setUpdate( Long update ) {
    Update = update;
  }
*/
  public Long getValueNumber() {
    return ValueNumber;
  }

  public void setValueNumber( Long valueNumber ) {
    ValueNumber = valueNumber;
  }

  public Value[] getValue() {
    return value;
  }

  public void setValue( Value[] value ) {
    this.value = value;
  }

  public Boolean getInternal() {
    return Internal;
  }

  public void setInternal( Boolean internal ) {
    Internal = internal;
  }

  public Boolean getCountFailedValues() {
    return countFailedValues;
  }

  public void setCountFailedValues( Boolean countFailedValues ) {
    this.countFailedValues = countFailedValues;
  }
}
