package util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;

@Named
@ApplicationScoped
public class RedisConnection {

	
	
	@Produces
	public RedissonClient createConnection() {
		System.out.println("abriu conexao");
		return Redisson.create();
	}

	public void finaliza(@Disposes RedissonClient client) { 
		client.shutdown();

		System.out.println("fechou conexao");
	} 
}
