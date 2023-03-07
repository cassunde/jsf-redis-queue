package br.com.cassunde.redislab;

import org.redisson.Redisson;
import org.redisson.api.RStream;
import org.redisson.api.RedissonClient;
import org.redisson.api.stream.StreamAddArgs;

public class StreamPublisher {

	public static void main(String[] args) throws InterruptedException {
		
		RedissonClient redisson = Redisson.create();		
		RStream<String, String> stream = redisson.getStream("dreStream");
		stream.add(StreamAddArgs.entry("test", "testvalue"));
		
	}
}
