package br.edu.univas.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.dao.ProdutoDAO;
import br.edu.univas.listener.CadastraProdutoListener;
import br.edu.univas.model.Produto;
import br.edu.univas.view.AddCadastraProdutoPanel;

public class AddCadastraProdutoController {
	
	private AddCadastraProdutoPanel addCadastraProdutoPanel;
	private Produto produto;
	private ProdutoDAO daoProduto = new ProdutoDAO();
	private List<JTextField> fields;

	
	public AddCadastraProdutoController() throws SQLException{
		addCadastraProdutoPanel = new AddCadastraProdutoPanel();
		addCadastraProdutoPanel.setListener(new CadastraProdutoListener() {
			
			@Override
			public void cadastra() {
				saveProduto();
			}
		});
		
		fields = Arrays.asList(
				addCadastraProdutoPanel.getNomeProdutoTextField(),
				addCadastraProdutoPanel.getCodigoTextField(),
				addCadastraProdutoPanel.getQtdProdutoTextField());
	}
	
	public void saveProduto(){
		if(validaCampos()){
		produto = new Produto();
		
		produto.setDescricao(addCadastraProdutoPanel.getNomeProdutoTextField().getText());
		int codigo = Integer.parseInt(addCadastraProdutoPanel.getCodigoTextField().getText());
		produto.setCodigo(codigo);
		
		int qtd = Integer.parseInt(addCadastraProdutoPanel.getQtdProdutoTextField().getText());
		produto.setQuantidade(qtd);
		
			if(!daoProduto.verificaProdutoExistente(codigo)){
				daoProduto.save(produto);
				clearFields();
				JOptionPane.showMessageDialog(addCadastraProdutoPanel, "Cadastro Realizado Com Sucesso!");
			}else{
				JOptionPane.showMessageDialog(addCadastraProdutoPanel, "Produto ja cadastrado!");	
			}
			
		}else{
			JOptionPane.showMessageDialog(addCadastraProdutoPanel, "Por favor, digite todos os campos para cadastrar um novo Produto!");
		}
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
				addCadastraProdutoPanel.getNomeProdutoTextField(),
				addCadastraProdutoPanel.getCodigoTextField(),
				addCadastraProdutoPanel.getQtdProdutoTextField());
				
		for(JTextField jTextField : fields){
			clearField(jTextField);
		}
	}
	
	private void clearField(JTextField textField){
		textField.setText(null);
	}
	
	public JPanel getComponent(){
		return addCadastraProdutoPanel;
	}

}
