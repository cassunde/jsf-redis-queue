package br.com.cassunde.bean.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private BigDecimal value;
	public Product(String name, BigDecimal value) {
		super();
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public BigDecimal getValue() {
		return value;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", value=" + value + "]";
	}
}
