package br.com.cassunde.listener;

import javax.inject.Named;

import org.redisson.api.RedissonClient;

import br.com.cassunde.bean.model.Product;

@Named
public class ListenerTopic20 implements ListenerDefault<Product> {


	@Override
	public void onMessage(CharSequence channel, Product msg) {
		System.out.println("Iniciando leitura Topic 20: "+Thread.currentThread().getName());
		System.out.println(channel);
		System.out.println(msg);
		System.out.println("Finalizando Leitura Topic 20");
	}
	
	@Override
	public void register(RedissonClient redisson) {
		redisson.getTopic("topic20").addListener(Product.class, this);
	}
}
