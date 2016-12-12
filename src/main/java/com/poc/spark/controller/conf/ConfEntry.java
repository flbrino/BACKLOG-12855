package com.poc.spark.controller.conf;

/**
 * Created by fcamara
 */
public interface ConfEntry {
  /**
   * Property key
   */
  public String key();

  /**
   * Property default value. Types:
   * String, Integer, Long, Boolean.
   */
  public Object defaultValue();
}
