package br.edu.univas.controller;

import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.dao.PedidoDAO;
import br.edu.univas.listener.PesquisaGerarRelatorio;
import br.edu.univas.model.Pedido;
import br.edu.univas.view.AddGerarRelatorioPanel;

public class AddGerarRelatorioController {
	
	private AddGerarRelatorioPanel addGerarRelatorioPanel;
	private Pedido pedido;
	private PedidoDAO dao;
	
	public AddGerarRelatorioController(){
		addGerarRelatorioPanel = new AddGerarRelatorioPanel();
		addGerarRelatorioPanel.setListener(new PesquisaGerarRelatorio() {
			
			@Override
			public void pesquisa() {
				pesquisaRelatorio();
			}
		});
	}
	
	public void pesquisaRelatorio(){
		pedido = new Pedido();
		
		//pedido.setDataDoPedido(addGerarRelatorioPanel.getDatainiTextField().getText());
		//pedido.setDataDoPedido(addGerarRelatorioPanel.getDatafinTextField().getText());
		
		dao.save(pedido);
	}
	
	private void clearFields(){
		List<JTextField> fields = Arrays.asList(
				addGerarRelatorioPanel.getDatainiTextField(),
				addGerarRelatorioPanel.getDatafinTextField());
				
				
		for(JTextField jTextField : fields){
			clearField(jTextField);
		}
	}
	
	private void clearField(JTextField textField){
		textField.setText(null);
	}
	
	public JPanel getComponent(){
		return addGerarRelatorioPanel;
	}

}
