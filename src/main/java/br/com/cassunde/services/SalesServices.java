package br.com.cassunde.services;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.cassunde.bean.model.ItemVenda;
import redis.clients.collections.RedisStrutureBuilder;
import redis.clients.collections.SetStructure;
import redis.clients.jedis.Jedis;

@Named
public class SalesServices implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Inject
	private Jedis jedis;

	public void createData() {
		
		String competencia052022 = "05/2022";
		List<ItemVenda> itensVenda = new ArrayList<ItemVenda>();
		for(int i=0; i<= 500000; i++) {
			ItemVenda itemVenda = new ItemVenda(competencia052022,"Cliente "+i,"COD"+i,BigDecimal.TEN, Long.valueOf(i));
			itensVenda.add(itemVenda);
		}
		
		persistDados(itensVenda, competencia052022);
		System.out.println("Itens 05 persistidos");
		
		
		String competencia062022 = "06/2022";
		List<ItemVenda> itensVenda06 = new ArrayList<ItemVenda>();
		for(int i=0; i<= 500000; i++) {
			ItemVenda itemVenda = new ItemVenda(competencia062022,"Cliente "+i,"COD"+i,BigDecimal.TEN, Long.valueOf(i));
			itensVenda06.add(itemVenda);
		}
		
		persistDados(itensVenda06, competencia062022);
		System.out.println("Itens 06 persistidos");
	}
	
	public void persistDados(List<ItemVenda> itensDeVenda, String competencia) {
		
		SetStructure<ItemVenda> itemDreStructure = RedisStrutureBuilder.ofSet(jedis, ItemVenda.class).withNameSpace("CACHE_VENDAS").build();
		Set<ItemVenda> itensDre = itemDreStructure.createSet(competencia);
		itensDeVenda.stream().forEach(i -> itensDre.add(i));
	}
	
	public void getAllData(String competencia) {
		SetStructure<ItemVenda> itemDreStructure = RedisStrutureBuilder.ofSet(jedis, ItemVenda.class).withNameSpace("CACHE_VENDAS").build();
		Set<ItemVenda> itensVenda = itemDreStructure.createSet(competencia);
		System.out.println(itensVenda.size());
		itensVenda.stream().forEach(i -> System.out.println(i));
	}
}
