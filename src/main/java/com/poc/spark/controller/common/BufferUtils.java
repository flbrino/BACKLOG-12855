package com.poc.spark.controller.common;

import java.nio.ByteBuffer;

/**
 * Created by fcamara
 * Utility methods for dealing with byte buffers and byte arrays.
 */
public class BufferUtils {

  public static byte[] toByteArray(ByteBuffer buf) {
    byte[] bytes;
    if (buf.hasArray() && buf.arrayOffset() == 0 &&
        buf.remaining() == buf.array().length) {
      bytes = buf.array();
    } else {
      bytes = new byte[buf.remaining()];
      buf.get(bytes);
    }
    return bytes;
  }
}
