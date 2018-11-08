package br.edu.univas.controller;

import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.dao.StudentDAO;
import br.edu.univas.listener.PesquisaProdutoListener;
import br.edu.univas.model.Produto;
import br.edu.univas.view.AddConsultaProdutoPanel;

public class AddConsultaProdutoController {
	
	private AddConsultaProdutoPanel addConsultaProdutoPanel;
	private Produto produto;
	private StudentDAO dao;
	
	public AddConsultaProdutoController(){
		addConsultaProdutoPanel = new AddConsultaProdutoPanel();
		addConsultaProdutoPanel.setListener(new PesquisaProdutoListener() {
			
			@Override
			public void pesquisa() {
				pesquisaPedido();
				
			}
		});
	}
	
	public void pesquisaPedido(){
		produto = new Produto();
		
		produto.setDescricao(addConsultaProdutoPanel.getNomeProdutoTextField().getText());
		
		dao.save(produto);
	}
	
	private void clearFields(){
		List<JTextField> fields = Arrays.asList(
				addConsultaProdutoPanel.getNomeProdutoTextField());
				
				
		for(JTextField jTextField : fields){
			clearField(jTextField);
		}
	}
	
	private void clearField(JTextField textField){
		textField.setText(null);
	}
	
	public JPanel getComponent(){
		return addConsultaProdutoPanel;
	}

}
