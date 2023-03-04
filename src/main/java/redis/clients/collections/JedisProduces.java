package redis.clients.collections;

import javax.enterprise.inject.Produces;

import redis.clients.jedis.Jedis;

public class JedisProduces {
	
	@Produces
	public Jedis create() {
		return new Jedis("localhost");
	}
}
