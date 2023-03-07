package br.com.cassunde.redislab;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;

import br.com.cassunde.bean.model.Product;

public class TopicListener {

	public static void main(String[] args) {

		RedissonClient redisson = Redisson.create();
		redisson.getTopic("myTopic")
			.addListener(Product.class, new MessageListener<Product>() {

				@Override
				public void onMessage(CharSequence channel, Product msg) {
					System.out.println("Iniciando leitura: "+Thread.currentThread().getName());
					System.out.println(channel);
					System.out.println(msg);
					System.out.println("Finalizando Leitura");
				}
			});
	}

}
