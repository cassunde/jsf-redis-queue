package br.com.cassunde.listener;

import org.redisson.api.listener.PatternMessageListener;

public interface ListenerDefault<T> extends PatternMessageListener<T> {
	String getPattern();
	Class<?> getType();
}
