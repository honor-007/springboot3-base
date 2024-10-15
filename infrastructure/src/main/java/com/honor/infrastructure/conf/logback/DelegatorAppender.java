package com.honor.infrastructure.conf.logback;

import ch.qos.logback.core.Appender;
import ch.qos.logback.core.UnsynchronizedAppenderBase;

import java.util.ArrayList;
import java.util.List;

public class DelegatorAppender<E> extends UnsynchronizedAppenderBase<E> {

    private final List<E> logBuffer = new ArrayList<>(1024);
    private Appender<E> delegate;

    @Override
    protected void append(E event) {
        synchronized (logBuffer) {
            if (delegate != null) {
                delegate.doAppend(event);
            } else {
                logBuffer.add(event);
            }
        }
    }

    public void setDelegateAndReplayBuffer(Appender<E> delegate) {
        synchronized (logBuffer) {
            this.delegate = delegate;
            for (E event : this.logBuffer) {
                delegate.doAppend(event);
            }
            this.logBuffer.clear();
        }
    }

}