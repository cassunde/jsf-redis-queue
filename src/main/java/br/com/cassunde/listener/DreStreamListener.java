package br.com.cassunde.listener;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.redisson.api.RStream;
import org.redisson.api.RedissonClient;
import org.redisson.api.StreamMessageId;
import org.redisson.api.stream.StreamReadGroupArgs;

@Named
public class DreStreamListener implements ListenerDefault<String> {

	@Inject
	private RedissonClient redisson;
	
	@Override
	public String getPattern() {
		return "__keyspace@0__:dreStream";
	}

	@Override
	public Class<?> getType() {
		return String.class;
	}


	@Override
	public void onMessage(CharSequence pattern, CharSequence channel, String msg) {
		RStream<String, String> stream = redisson.getStream("dreStream");
		
		Map<StreamMessageId, Map<String, String>> messages = stream.readGroup("groupDre","consumer1",StreamReadGroupArgs.greaterThan(StreamMessageId.NEVER_DELIVERED));
										
			for (Map.Entry<StreamMessageId, Map<String, String>> entry : messages.entrySet()) {	 	 			 	 					 	 			

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
