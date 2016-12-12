package com.poc.spark.controller.common;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.poc.spark.controller.api.JobHandle;

/**
 * Created by fcamara
 */
public abstract class AbstractJobHandle<T> implements JobHandle<T> {

  protected final List<Listener<T>> listeners;
  protected volatile State state;

  protected AbstractJobHandle() {
    this.listeners = new LinkedList<>();
    this.state = State.SENT;
  }

  @Override
  public State getState() {
    return state;
  }

  @Override
  public void addListener(Listener<T> l) {
    synchronized (listeners) {
      listeners.add(l);
      fireStateChange(state, l);
    }
  }

  /**
   * Changes the state of this job handle
   * Fires events appropriately.
   *
   */
  public boolean changeState(State newState) {
    synchronized (listeners) {
      if (newState.ordinal() > state.ordinal() && state.ordinal() < State.CANCELLED.ordinal()) {
        state = newState;
        for (Listener<T> l : listeners) {
          fireStateChange(newState, l);
        }
        return true;
      }
      return false;
    }
  }

  protected abstract T result();
  protected abstract Throwable error();

  private void fireStateChange(State s, Listener<T> l) {
    switch (s) {
      case SENT:
        break;
      case QUEUED:
        l.onJobQueued(this);
        break;
      case STARTED:
        l.onJobStarted(this);
        break;
      case CANCELLED:
        l.onJobCancelled(this);
        break;
      case FAILED:
        l.onJobFailed(this, error());
        break;
      case SUCCEEDED:
        try {
          l.onJobSucceeded(this, result());
        } catch (Exception e) {
          // Shouldn't really happen.
          throw new IllegalStateException(e);
        }
        break;
      default:
        throw new IllegalStateException();
    }
  }
}
