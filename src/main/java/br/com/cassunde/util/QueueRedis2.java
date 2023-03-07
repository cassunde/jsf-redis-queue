package br.com.cassunde.util;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;

public class QueueRedis2 {

	public static void main(String[] args) throws InterruptedException {
		
		RedissonClient redisson = Redisson.create();
		redisson.getTopic("myTopic").publish(new String("oi"));
		redisson.getTopic("myTopic").publish(new String("oi 2"));
		
		Thread.sleep(1000);
		redisson.getTopic("myTa").publish(new String("oi 3"));
		
	}
}
