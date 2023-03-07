package br.com.cassunde.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.PatternMessageListener;
import org.redisson.client.codec.StringCodec;

import br.com.cassunde.listener.ListenerDefault;

@Named
public class QueueRedis {

	@Inject
	private Instance<ListenerDefault<?>> listeners;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void startListeners(@Observes @Initialized(ApplicationScoped.class) Object init) throws InterruptedException {
		new Thread(()->{
			RedissonClient redisson = Redisson.create();
			for(ListenerDefault<?> listener : listeners) {
				redisson.getPatternTopic(listener.getPattern(), StringCodec.INSTANCE)
				.addListener(listener.getType(), (PatternMessageListener) listener);
				
			}
			System.out.println("listeners configurado");
		}).start();
	}
}
