package br.com.cassunde.bean.model;

import java.math.BigDecimal;

public class ItemVenda {
	
	private String codCompetencia;
	private String cliente;
	private String codProduto;
	private BigDecimal valorVenda;
	private Long quantidade;

	public ItemVenda(String codCompetencia, String cliente, String codProduto, BigDecimal valorVenda, Long quantidade) {
		super();
		this.codCompetencia = codCompetencia;
		this.cliente = cliente;
		this.codProduto = codProduto;
		this.valorVenda = valorVenda;
		this.quantidade = quantidade;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}
	public BigDecimal getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public String getCodCompetencia() {
		return codCompetencia;
	}
	public void setCodCompetencia(String codCompetencia) {
		this.codCompetencia = codCompetencia;
	}
	@Override
	public String toString() {
		return "ItemVenda [codCompetencia=" + codCompetencia + ", cliente=" + cliente + ", codProduto=" + codProduto
				+ ", valorVenda=" + valorVenda + ", quantidade=" + quantidade + "]";
	}
}
