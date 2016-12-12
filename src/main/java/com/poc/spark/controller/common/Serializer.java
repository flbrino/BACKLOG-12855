package com.poc.spark.controller.common;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.shaded.org.objenesis.strategy.StdInstantiatorStrategy;

/**
 * Created by fcamara 
 * Utility class to serialize user data using Kryo.
 */

public class Serializer {

  // Kryo docs say 0-8 are taken. Strange things happen if you don't set an ID when registering
  // classes.
  private static final int REG_ID_BASE = 16;

  private final ThreadLocal<Kryo> kryos;

  public Serializer(final Class<?>... klasses) {
    this.kryos = new ThreadLocal<Kryo>() {
      @Override
      protected Kryo initialValue() {
        Kryo kryo = new Kryo();
        int count = 0;
        for (Class<?> klass : klasses) {
          kryo.register(klass, REG_ID_BASE + count);
          count++;
        }
        kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
        kryo.setClassLoader(Thread.currentThread().getContextClassLoader());
        return kryo;
      }
    };
  }

  public Object deserialize(ByteBuffer data) {
    byte[] b = new byte[data.remaining()];
    data.get(b);
    Input kryoIn = new Input(b);
    return kryos.get().readClassAndObject(kryoIn);
  }

  public ByteBuffer serialize(Object data) {
    ByteBufferOutputStream out = new ByteBufferOutputStream();
    Output kryoOut = new Output(out);
    kryos.get().writeClassAndObject(kryoOut, data);
    kryoOut.flush();
    return out.getBuffer();
  }

  private static class ByteBufferOutputStream extends ByteArrayOutputStream {

    public ByteBuffer getBuffer() {
      ByteBuffer result = ByteBuffer.wrap(buf, 0, count);
      buf = null;
      reset();
      return result;
    }

  }

}
