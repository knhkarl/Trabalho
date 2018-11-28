package br.edu.univas.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.dao.PedidoDAO;
import br.edu.univas.listener.PesquisaPedidosClienteListener;
import br.edu.univas.view.AddConsultaPedidoClientePanel;

public class AddConsultaPedidoClienteController {
	
	private AddConsultaPedidoClientePanel addConsultaPedidoClientePanel;
	private PedidoDAO daoPedido;
	
	public AddConsultaPedidoClienteController() throws SQLException{
		daoPedido = new PedidoDAO();
		addConsultaPedidoClientePanel = new AddConsultaPedidoClientePanel();
		
		addConsultaPedidoClientePanel.setListener(new PesquisaPedidosClienteListener() {
			
			@Override
			public void pesquisa() {
				pesquisaPedidosCliente();
			}
		});
	}
	
	public AddConsultaPedidoClientePanel pesquisaPedidosCliente(){
		String cnpjCliente;
		
		cnpjCliente = addConsultaPedidoClientePanel.getNomeClienteTextField().getText();
		if(!daoPedido.verificaCnpjExistente(cnpjCliente)){
			JOptionPane.showMessageDialog(addConsultaPedidoClientePanel, "CNPJ não encontrado!");
		}else{
		addConsultaPedidoClientePanel.updatePedido(daoPedido.getPedido(cnpjCliente));
		clearFields();
		}
		return addConsultaPedidoClientePanel;
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
		addConsultaPedidoClientePanel.updatePedido(daoPedido.getAllPedido());
		return addConsultaPedidoClientePanel;
	}

}
