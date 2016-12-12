package com.poc.spark.controller.conf;

/**
 * Created by fcamara
 */
public interface ConfEntry {
  /**
   * Property key
   */
  String key();

  /**
   * Property default value. Types:
   * String, Integer, Long, Boolean ...
   */
  Object defaultValue();
}
