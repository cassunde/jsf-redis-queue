package br.com.cassunde.services;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.redisson.Redisson;
import org.redisson.api.RStream;
import org.redisson.api.RedissonClient;
import org.redisson.api.StreamMessageId;
import org.redisson.api.stream.StreamAddArgs;
import org.redisson.api.stream.StreamReadGroupArgs;

@Named
@ApplicationScoped
public class Redis implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	public void pushStream(String message, String usuario) throws InterruptedException {
		
		RedissonClient redisson = Redisson.create();
		RStream<String, String> stream = redisson.getStream("dreStream");
//		stream.createGroup("groupDre");
		stream.add(StreamAddArgs.entry("DRE1", message + ":"+ usuario));
		System.out.println("thread que postou "+ Thread.currentThread().getId());
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				RedissonClient redisson = Redisson.create();
				RStream<String, String> stream = redisson.getStream("dreStream");
				
				Map<StreamMessageId, Map<String, String>> messages = stream.readGroup("groupDre","consumer1",StreamReadGroupArgs.greaterThan(StreamMessageId.NEVER_DELIVERED));
				
	 	 		for (Map.Entry<StreamMessageId, Map<String, String>> entry : messages.entrySet()) {	 	 			 	 					 	 			
	 	 			Map<String, String> msg = entry.getValue();
	 	 			
	 	 			msg.keySet().stream()
	 	 			.findFirst().ifPresent(messasgem -> {
	 	 				System.out.println("Consumindo mensagem da DRE" + messasgem  + " messasge: " + msg.get(messasgem));
	 	 			});

	 	 			try {
	 	 				Thread.currentThread().sleep(20000L);
	 				} catch (InterruptedException e) {
	 					// TODO Auto-generated catch block
	 					e.printStackTrace();
	 				}
	 	 		  
	 	 			System.out.println("terminou de processar mensagem: "+ msg);
	 	 			stream.ack("groupDre", entry.getKey());
	 	 			stream.remove(entry.getKey());
	 	 		}
	 	 		redisson.shutdown();
				
			}
		}).start();
		redisson.shutdown();
	}
}
