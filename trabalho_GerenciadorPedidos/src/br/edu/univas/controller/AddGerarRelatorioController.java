package br.edu.univas.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.dao.PedidoDAO;
import br.edu.univas.listener.PesquisaGerarRelatorioListener;
import br.edu.univas.view.AddGerarRelatorioPanel;

public class AddGerarRelatorioController {
	
	private AddGerarRelatorioPanel addGerarRelatorioPanel;
	private PedidoDAO daoPedido;
	private List<JTextField> fields;
	
	public AddGerarRelatorioController() throws SQLException{
		daoPedido = new PedidoDAO();
		addGerarRelatorioPanel = new AddGerarRelatorioPanel();
		
		addGerarRelatorioPanel.setListener(new PesquisaGerarRelatorioListener() {
			
			@Override
			public void pesquisa() {
				pesquisaRelatorio();
			}
		});
		
		fields = Arrays.asList(
				addGerarRelatorioPanel.getDatainiTextField(),
				addGerarRelatorioPanel.getDatafinTextField());
	}
	
	public AddGerarRelatorioPanel pesquisaRelatorio(){
		if(validaCampos()){
		String dataini;
		String datafin;
		
		dataini = addGerarRelatorioPanel.getDatainiTextField().getText();
		datafin = addGerarRelatorioPanel.getDatafinTextField().getText();
		if(!daoPedido.verificaDataInicial(dataini)){
			JOptionPane.showMessageDialog(addGerarRelatorioPanel, "Data inicial invalida!");
			if(!daoPedido.verificaDataFinal(datafin)){
				JOptionPane.showMessageDialog(addGerarRelatorioPanel, "Data final invalida!");
			}
		}else{
			addGerarRelatorioPanel.updateRelatorio(daoPedido.getPedidoRelatorio(dataini, datafin));
			clearFields();
		}
		}else{
			JOptionPane.showMessageDialog(addGerarRelatorioPanel, "Por favor, digite todos os campos para gerar o relatorio!");
		}
		return addGerarRelatorioPanel;
	}
	
	private boolean validaCampos() {
		for (JTextField jTextField : fields) {
			if (jTextField.getText() == null || jTextField.getText().trim().equals("")) {
				return false;
			}
		}
		return true;
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
		addGerarRelatorioPanel.updateRelatorio(daoPedido.getAllPedido());
		return addGerarRelatorioPanel;
	}

}
