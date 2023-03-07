package br.com.cassunde.listener;

import javax.inject.Inject;
import javax.inject.Named;

import org.redisson.api.RedissonClient;

import br.com.cassunde.bean.model.Product;

@Named
public class ListenerTopic implements ListenerDefault<Product> {

	@Inject
	private RedissonClient redisson;

	@Override
	public void onMessage(CharSequence channel, Product msg) {
		System.out.println("Iniciando leitura: "+Thread.currentThread().getName());
		System.out.println(channel);
		System.out.println(msg);
		System.out.println("Finalizando Leitura");
	}
	
	@Override
	public void register() {
		redisson.getTopic("topic").addListener(Product.class, this);
	}
}
