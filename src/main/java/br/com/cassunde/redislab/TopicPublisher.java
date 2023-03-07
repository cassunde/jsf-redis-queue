package br.com.cassunde.redislab;

import java.math.BigDecimal;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;

import br.com.cassunde.bean.model.Product;

public class TopicPublisher {

	public static void main(String[] args) throws InterruptedException {
		
		RedissonClient redisson = Redisson.create();
		redisson.getTopic("myTopic").publish(new Product("Leite", BigDecimal.TEN));
	}
}
