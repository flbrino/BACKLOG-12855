package com.poc.spark.controller.sparkevent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fcamara.
 */
public class StorageLevel {
  @SerializedName( "Use Disk" )
  private boolean useDisk;
  @SerializedName( "Use Memory" )
  private boolean useMemory;
  @SerializedName( "Deserialized" )
  private boolean deserialized;
  @SerializedName( "Replication" )
  private int replication;

  public boolean isUseDisk() {
    return useDisk;
  }

  public void setUseDisk( boolean useDisk ) {
    this.useDisk = useDisk;
  }

  public boolean isUseMemory() {
    return useMemory;
  }

  public void setUseMemory( boolean useMemory ) {
    this.useMemory = useMemory;
  }

  public boolean isDeserialized() {
    return deserialized;
  }

  public void setDeserialized( boolean deserialized ) {
    this.deserialized = deserialized;
  }

  public int getReplication() {
    return replication;
  }

  public void setReplication( int replication ) {
    this.replication = replication;
  }


}
