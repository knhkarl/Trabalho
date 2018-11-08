package br.edu.univas.controller;

import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.dao.ClienteDAO;
import br.edu.univas.dao.ContemDAO;
import br.edu.univas.dao.ProdutoDAO;
import br.edu.univas.listener.SaveButtonListener;
import br.edu.univas.model.Cliente;
import br.edu.univas.model.Contem;
import br.edu.univas.model.Produto;
import br.edu.univas.view.AddRealizaPedidoPanel;

public class AddRealizaPedidoController {
	
	private AddRealizaPedidoPanel addRealizaPedidoPanel;
	private Produto produto;
	private Contem contem;
	private Cliente cliente;
	private ProdutoDAO daoProduto = new ProdutoDAO();
	private ContemDAO daoContem = new ContemDAO();
	private ClienteDAO daoCliente = new ClienteDAO();

	
	public AddRealizaPedidoController(){
		addRealizaPedidoPanel = new AddRealizaPedidoPanel();
		addRealizaPedidoPanel.setListener(new SaveButtonListener() {
			
			@Override
			public void save() {
				savePedido();
			}
		});
	}
	
	public void savePedido(){
		produto = new Produto();
		contem = new Contem();
		cliente = new Cliente();
		
		produto.setDescricao(addRealizaPedidoPanel.getNomeProdutoTextField().getText());
//		contem.setQuantidade(addRealizaPedidoPanel.getQtdProdutoTextField().getText());
		int qtd = Integer.parseInt(addRealizaPedidoPanel.getQtdProdutoTextField().getText());
		contem.setQuantidade(qtd);
		cliente.setCnpj(addRealizaPedidoPanel.getCnpjClienteTextField().getText());
		
		daoProduto.save(produto);
		daoContem.save(contem);
		daoCliente.save(cliente);
		clearFields();
	}
	
	private void clearFields(){
		List<JTextField> fields = Arrays.asList(
				addRealizaPedidoPanel.getNomeProdutoTextField(),
				addRealizaPedidoPanel.getQtdProdutoTextField(),
				addRealizaPedidoPanel.getCnpjClienteTextField());
				
		for(JTextField jTextField : fields){
			clearField(jTextField);
		}
	}
	
	private void clearField(JTextField textField){
		textField.setText(null);
	}
	
	public JPanel getComponent(){
		return addRealizaPedidoPanel;
	}

}
