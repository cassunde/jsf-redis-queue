package br.com.cassunde.redislab;

import java.util.Map;

import org.redisson.Redisson;
import org.redisson.api.RStream;
import org.redisson.api.RedissonClient;
import org.redisson.api.StreamMessageId;
import org.redisson.api.stream.StreamReadGroupArgs;

public class StreamListener {

	public static void main(String[] args) {

		RedissonClient redisson = Redisson.create();
		RStream<String, String> stream = redisson.getStream("dreStream");
		Map<StreamMessageId, Map<String, String>> group = stream.readGroup("groupDre", "consumer1", StreamReadGroupArgs.neverDelivered());
		
		for (Map.Entry<StreamMessageId, Map<String, String>> entry : group.entrySet()) {	 	 			 	 					 	 			

 			try {
 				
 				Map<String, String> message = entry.getValue();
 				System.out.println("Consumindo mensagem " + message);
 				Thread.sleep(20000);
 				System.out.println("terminou de processar mensagem: "+ message);
 				stream.ack("groupDre", entry.getKey());
 				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
			e.printStackTrace();
			}
		}	
		
	}

}
