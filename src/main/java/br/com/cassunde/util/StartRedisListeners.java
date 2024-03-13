package br.com.cassunde.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;

import org.redisson.api.RedissonClient;

import br.com.cassunde.listener.ListenerDefault;

@Named
@ApplicationScoped
public class StartRedisListeners {
	
	@Inject
	private RedissonClient redissonClient;
	
	@Inject
	private Instance<ListenerDefault<?>> listeners;

	public void dynamicStartTopicListener(@Observes @Initialized(ApplicationScoped.class) Object init) {
		new Thread(()-> {
			for(ListenerDefault<?> listener : listeners ) {
				listener.register(redissonClient);
				System.out.println(listener.getClass());
			}
			System.out.println("listeners configurado");
		}).start();
	}
}
