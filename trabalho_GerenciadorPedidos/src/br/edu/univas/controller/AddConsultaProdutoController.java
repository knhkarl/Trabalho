package br.edu.univas.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import br.edu.univas.dao.ProdutoDAO;
import br.edu.univas.listener.AdicionarQtdProdutoListener;
import br.edu.univas.listener.PesquisaProdutoListener;
import br.edu.univas.view.AddConsultaProdutoPanel;

public class AddConsultaProdutoController {
	
	private AddConsultaProdutoPanel addConsultaProdutoPanel;
	private ProdutoDAO daoProduto;
	private List<JTextField> fields;

	
	public AddConsultaProdutoController() throws SQLException{
		daoProduto = new ProdutoDAO();
		addConsultaProdutoPanel = new AddConsultaProdutoPanel();
		
		
		addConsultaProdutoPanel.setListener(new PesquisaProdutoListener() {
			
			@Override
			public void pesquisa() {
				pesquisaPedido();
				
			}
		});
		
		addConsultaProdutoPanel.setListener(new AdicionarQtdProdutoListener() {
			
			@Override
			public void adicionaQtd() {
				adicionar();
				
			}
		});
		
		fields = Arrays.asList(
				addConsultaProdutoPanel.getCodigoTextField(),
				addConsultaProdutoPanel.getAdicionaQtdTextField());
	}
	
	public AddConsultaProdutoPanel pesquisaPedido(){
		String produto;
		produto = addConsultaProdutoPanel.getNomeProdutoTextField().getText();
		boolean verifica = daoProduto.verificaNomeProdutoExistente(produto);
		if(verifica){
		addConsultaProdutoPanel.updateProduto(daoProduto.getProduto(produto));
		clearFields();
		}else{
			JOptionPane.showMessageDialog(addConsultaProdutoPanel, "Produto não encontrado!");
		}
	
		return addConsultaProdutoPanel;
	}
	
	private boolean validaCampos() {
		for (JTextField jTextField : fields) {
			if (jTextField.getText() == null || jTextField.getText().trim().equals("")) {
				return false;
			}
		}
		return true;
	}
	
	public AddConsultaProdutoPanel adicionar(){
		if(validaCampos()){
			int codigo = 0;
			int qtd = 0;
			codigo = Integer.parseInt(addConsultaProdutoPanel.getCodigoTextField().getText());
			qtd = Integer.parseInt(addConsultaProdutoPanel.getAdicionaQtdTextField().getText());
			addConsultaProdutoPanel.updateProduto(daoProduto.adicionaQuantidade(codigo, qtd));
			clearFields();
			JOptionPane.showMessageDialog(addConsultaProdutoPanel, "Quantidade adicionada com sucesso!");
			getComponent();
		}else{
			JOptionPane.showMessageDialog(addConsultaProdutoPanel, "Por favor, digite todos os campos para cadastrar um novo Produto!");
		}
		return addConsultaProdutoPanel;
	}
	
	private void clearFields(){
		List<JTextField> fields = Arrays.asList(
				addConsultaProdutoPanel.getNomeProdutoTextField(),
				addConsultaProdutoPanel.getCodigoTextField(),
				addConsultaProdutoPanel.getAdicionaQtdTextField());
				
		for(JTextField jTextField : fields){
			clearField(jTextField);
		}
	}
	
	private void clearField(JTextField textField){
		textField.setText(null);
	}
	
	public JPanel getComponent(){
		addConsultaProdutoPanel.updateProduto(daoProduto.getAllProduto());
		SwingUtilities.updateComponentTreeUI(addConsultaProdutoPanel);
		return addConsultaProdutoPanel;
	}
	


}
