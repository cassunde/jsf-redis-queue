package br.com.cassunde.services;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.redisson.api.RStream;
import org.redisson.api.RedissonClient;
import org.redisson.api.stream.StreamAddArgs;

@Named
@ApplicationScoped
public class Redis implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private RedissonClient redisson;

	
	public void pushStream(String message, String usuario) throws InterruptedException {
		
		RStream<String, String> stream = redisson.getStream("dreStream");
//		stream.createGroup("groupDre");
		stream.add(StreamAddArgs.entry("DRE1", message + ":"+ usuario));
		System.out.println("thread que postou "+ Thread.currentThread().getId());
	}
}
