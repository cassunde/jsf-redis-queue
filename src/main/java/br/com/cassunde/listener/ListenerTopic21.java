package br.com.cassunde.listener;

import javax.inject.Inject;
import javax.inject.Named;

import org.redisson.api.RedissonClient;

import br.com.cassunde.bean.model.Product;

@Named
public class ListenerTopic21 implements ListenerDefault<Product> {

	@Inject
	private RedissonClient redisson;

	@Override
	public void onMessage(CharSequence channel, Product msg) {
		System.out.println("Iniciando leitura Topic 21: "+Thread.currentThread().getName());
		System.out.println(channel);
		System.out.println(msg);
		System.out.println("Finalizando Leitura Topic 21");
	}
	
	@Override
	public void register() {
		redisson.getTopic("topic21").addListener(Product.class, this);
	}
}
