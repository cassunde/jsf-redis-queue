package br.com.cassunde.listener;

import org.redisson.api.listener.MessageListener;

public interface ListenerDefault<T> extends MessageListener<T> {
	void register();
}
