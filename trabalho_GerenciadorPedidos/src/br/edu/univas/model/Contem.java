package br.edu.univas.model;

public class Contem {
	
	private Produto produto;
	private Pedido pedido;
	private int quantidade;
	
	public int getCodidoProduto(){
		int codigoProduto = this.produto.getCodigo();
		return codigoProduto;
	}
	
	public int getNumeroPedido(){
		int numeroPedido = this.pedido.getNumero();
		return numeroPedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int num) {
		this.quantidade = num;
	}
	

}
