package br.com.cassunde.services;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.redisson.api.RedissonClient;

import br.com.cassunde.bean.model.Product;

@Named
@ApplicationScoped
public class Redis implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private RedissonClient redisson;

	
	public void pushStream(String message, String usuario) throws InterruptedException {
		
//		RStream<String, String> stream = redisson.getStream("dreStream");
//		stream.createGroup("groupDre");
//		stream.add(StreamAddArgs.entry("DRE1", message + ":"+ usuario));
//		System.out.println("thread que postou "+ Thread.currentThread().getId());
		
		redisson.getTopic("topic").publish(new Product("Leite", BigDecimal.TEN));

		Thread.sleep(10000);
		redisson.getTopic("topic20")
		.publish(new Product("Nescal", BigDecimal.valueOf(20.50)));
//	
	}
}
