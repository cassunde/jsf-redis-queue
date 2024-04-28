package br.com.cassunde.thymeleaf;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Item {

	private String rubrica;
	private String conta;
	private String centro;
	private BigDecimal valor;
	private List<Item> itens;
	
	
	public Item(String rubrica, String conta, String centro, BigDecimal valor) {
		super();
		this.rubrica = rubrica;
		this.conta = conta;
		this.centro = centro;
		this.valor = valor;
		this.itens =  new ArrayList<>();
	}
	
	
	
	public Item(String rubrica, String conta) {
		super();
		this.rubrica = rubrica;
		this.conta = conta;
		this.itens =  new ArrayList<>();
	}



	public Item(String rubrica) {
		super();
		this.rubrica = rubrica;
		this.itens =  new ArrayList<>();
	}



	public String getRubrica() {
		return rubrica;
	}
	public void setRubrica(String rubrica) {
		this.rubrica = rubrica;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public String getCentro() {
		return centro;
	}
	public void setCentro(String centro) {
		this.centro = centro;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<Item> getItens() {
		return itens;
	}
	public void addItens(Item item) {
		this.itens.add(item);
	}

}
