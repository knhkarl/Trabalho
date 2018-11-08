package br.edu.univas.model;

import java.util.Date;

public class Realiza {
	
	private Date dataDaPrevisao;
	private Date dataDeEntrega;
	private Pedido pedido;
	private Vendedor vendedor;
	private Cliente cliente;
	
	public Date getDataDaPrevisao() {
		return dataDaPrevisao;
	}
	public void setDataDaPrevisao(Date dataDaPrevisao) {
		this.dataDaPrevisao = dataDaPrevisao;
	}
	public Date getDataDeEntrega() {
		return dataDeEntrega;
	}
	public void setDataDeEntrega(Date dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
	}
	
	public int getCpfVendedor(){
		int cpf = this.vendedor.getCpf();
		return cpf;
	}
	
	public String getCnpjCliente(){
		String cnpj = this.cliente.getCnpj();
		return cnpj;
	}
	
	public int getNumeroPedido(){
		int numeroPedido = this.pedido.getNumero();
		return numeroPedido;
	}
	
	

}
