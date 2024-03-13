package br.com.cassunde.listener;

import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;

public interface ListenerDefault<T> extends MessageListener<T> {
	void register(RedissonClient redisson);
}
