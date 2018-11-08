package br.edu.univas.controller;

import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.dao.StudentDAO;
import br.edu.univas.listener.PesquisaPedidosClienteListener;
import br.edu.univas.model.Produto;
import br.edu.univas.view.AddConsultaPedidoClientePanel;

public class AddConsultaPedidoClienteController {
	
	private AddConsultaPedidoClientePanel addConsultaPedidoClientePanel;
	private Produto produto;
	private StudentDAO dao;
	
	public AddConsultaPedidoClienteController(){
		addConsultaPedidoClientePanel = new AddConsultaPedidoClientePanel();
		addConsultaPedidoClientePanel.setListener(new PesquisaPedidosClienteListener() {
			
			@Override
			public void pesquisa() {
				pesquisaPedidosCliente();
			}
		});
	}
	
	public void pesquisaPedidosCliente(){
		produto = new Produto();
		
		produto.setDescricao(addConsultaPedidoClientePanel.getNomeClienteTextField().getText());
		
		dao.save(produto);
	}
	
	private void clearFields(){
		List<JTextField> fields = Arrays.asList(
				addConsultaPedidoClientePanel.getNomeClienteTextField());
				
				
		for(JTextField jTextField : fields){
			clearField(jTextField);
		}
	}
	
	private void clearField(JTextField textField){
		textField.setText(null);
	}
	
	public JPanel getComponent(){
		return addConsultaPedidoClientePanel;
	}

}
