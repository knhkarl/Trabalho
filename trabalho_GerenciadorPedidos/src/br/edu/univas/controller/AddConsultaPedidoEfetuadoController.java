package br.edu.univas.controller;

import java.awt.Component;

import br.edu.univas.dao.ClienteDAO;
import br.edu.univas.dao.ContemDAO;
import br.edu.univas.dao.ProdutoDAO;
import br.edu.univas.view.AddConsultaPedidoEfetuadoPanel;

public class AddConsultaPedidoEfetuadoController {
	
	private AddConsultaPedidoEfetuadoPanel panel;
	private ProdutoDAO daoProduto;
	private ContemDAO daoContem;
	private ClienteDAO daoCliente;
	
	public AddConsultaPedidoEfetuadoController(){
		daoProduto = new ProdutoDAO();
		daoContem = new ContemDAO();
		daoCliente = new ClienteDAO();
		panel = new AddConsultaPedidoEfetuadoPanel();

	}
	
	public Component getComponent(){
		panel.updatePedidosProduto(daoProduto.getAllProduto());
		panel.updatePedidosContem(daoContem.getAllContem());
		panel.updatePedidosCliente(daoCliente.getAllCliente());
		return panel;
		
	}

}
