package br.edu.univas.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.dao.ClienteDAO;
import br.edu.univas.listener.CadastraClienteListener;
import br.edu.univas.model.Cliente;
import br.edu.univas.view.AddCadastraClientePanel;

public class AddCadastraClienteController {
	
	private AddCadastraClientePanel addCadastraClientePanel;
	private Cliente cliente;
	private ClienteDAO daoCliente;
	private List<JTextField> fields;

	
	public AddCadastraClienteController() throws SQLException{
		daoCliente = new ClienteDAO();
		addCadastraClientePanel = new AddCadastraClientePanel();
		addCadastraClientePanel.setListener(new CadastraClienteListener() {
			
			@Override
			public void cadastra() {
				saveCliente();
			}
		});
		
		fields = Arrays.asList(
				addCadastraClientePanel.getCnpjTextField(),
				addCadastraClientePanel.getRazaoSocialTextField(),
				addCadastraClientePanel.getCpfTextField());
	}
	
	public void saveCliente(){
		if(validaCampos()){
		cliente = new Cliente();
		String cpf = null;
		
		cliente.setCnpj(addCadastraClientePanel.getCnpjTextField().getText());
		cliente.setRazaoSocial(addCadastraClientePanel.getRazaoSocialTextField().getText());
		cpf = addCadastraClientePanel.getCpfTextField().getText();
		cliente.setCpf_vend(cpf);;
		
			if(daoCliente.verificaCpfVendedorExistente(cpf)){
				daoCliente.save(cliente);
				clearFields();
				JOptionPane.showMessageDialog(addCadastraClientePanel, "Cadastro Realizado Com Sucesso!");
			}else{
				JOptionPane.showMessageDialog(addCadastraClientePanel, "CPF do vendedor ainda não cadastrado!");	
			}
	
		}else{
			JOptionPane.showMessageDialog(addCadastraClientePanel, "Por favor, digite todos os campos para cadastrar um novo Cliente!");
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
				addCadastraClientePanel.getCnpjTextField(),
				addCadastraClientePanel.getRazaoSocialTextField(),
				addCadastraClientePanel.getCpfTextField());
			
		for(JTextField jTextField : fields){
			clearField(jTextField);
		}
	}
	
	private void clearField(JTextField textField){
		textField.setText(null);
	}
	
	public JPanel getComponent(){
		return addCadastraClientePanel;
	}

}
