package br.edu.univas.model;

import java.util.Date;

public class Pedido {
	
	private int numero;
	private Date prazo;
	private Date dataDoPedido;
	private int status;
	private Vendedor vendedor;
	private Cliente cliente;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getPrazo() {
		return prazo;
	}
	public void setPrazo(Date prazo) {
		this.prazo = prazo;
	}
	public Date getDataDoPedido() {
		return dataDoPedido;
	}
	public void setDataDoPedido(Date dataDoPedido) {
		this.dataDoPedido = dataDoPedido;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getCpfVendedor(){
		int cpf = this.vendedor.getCpf();
		return cpf;
	}
	
	public String getCnpjCliente(){
		String cnpj = this.cliente.getCnpj();
		return cnpj;
	}

}
