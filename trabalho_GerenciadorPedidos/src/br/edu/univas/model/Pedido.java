package br.edu.univas.model;

import java.sql.Date;

public class Pedido {
	
	private int numero;
	private String produto;
	private int codigo;
	private int quantidade;
	private String status;
	private Date dataDoPedido;
	private Date dataDaPrevisao;
	private Date dataDaEntrega;
	private String cliente;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDataDoPedido() {
		return dataDoPedido;
	}
	public void setDataDoPedido(Date dataDoPedido) {
		this.dataDoPedido = dataDoPedido;
	}
	public Date getDataDaPrevisao() {
		return dataDaPrevisao;
	}
	public void setDataDaPrevisao(Date dataDaPrevisao) {
		this.dataDaPrevisao = dataDaPrevisao;
	}
	public Date getDataDaEntrega() {
		return dataDaEntrega;
	}
	public void setDataDaEntrega(Date dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
}


