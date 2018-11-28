package br.edu.univas.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.dao.UsuarioDAO;
import br.edu.univas.dao.VendedorDAO;
import br.edu.univas.listener.CadastraVendedorListener;
import br.edu.univas.model.Usuario;
import br.edu.univas.model.Vendedor;
import br.edu.univas.view.AddCadastraVendedorPanel;

public class AddCadastraVendedorController {
	
	private AddCadastraVendedorPanel addCadastraVendedorPanel;
	private Vendedor vendedor;
	private Usuario usuario;
	private VendedorDAO daoVendedor;
	private UsuarioDAO daoUsuario;
	private List<JTextField> fields;

	
	public AddCadastraVendedorController() throws SQLException{
		daoVendedor = new VendedorDAO();
		daoUsuario = new UsuarioDAO();
		addCadastraVendedorPanel = new AddCadastraVendedorPanel();
		addCadastraVendedorPanel.setListener(new CadastraVendedorListener() {
			
			@Override
			public void cadastra() {
				saveVendedor();
			}
		});
		
		fields = Arrays.asList(
				addCadastraVendedorPanel.getCpfTextField(),
				addCadastraVendedorPanel.getNomeTextField(),
				addCadastraVendedorPanel.getEmailTextField(),
				addCadastraVendedorPanel.getPasswordField(),
				addCadastraVendedorPanel.getPerfilTextField());
	}
	
	public void saveVendedor(){
		if(validaCampos()){
		vendedor = new Vendedor();
		usuario = new Usuario();
		
		vendedor.setCpf(addCadastraVendedorPanel.getCpfTextField().getText());
		vendedor.setNome(addCadastraVendedorPanel.getNomeTextField().getText());
		vendedor.setEmail(addCadastraVendedorPanel.getEmailTextField().getText());
		
		String senha = "";
		
		char[] pass = addCadastraVendedorPanel.getPasswordField().getPassword();
		for (char c : pass) {
			senha+= c;
		}
		usuario.setSenha(senha);
		int perfil = Integer.parseInt(addCadastraVendedorPanel.getPerfilTextField().getText());
		usuario.setPerfil(perfil);
		
		daoVendedor.save(vendedor);
		
		String cpf = vendedor.getCpf();
		daoUsuario.save(usuario, cpf);
		
		clearFields();
		JOptionPane.showMessageDialog(addCadastraVendedorPanel, "Cadastro Realizado Com Sucesso!");
		}else{
			JOptionPane.showMessageDialog(addCadastraVendedorPanel, "Por favor, digite todos os campos para cadastrar um novo Vendedor!");
			
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
				addCadastraVendedorPanel.getCpfTextField(),
				addCadastraVendedorPanel.getNomeTextField(),
				addCadastraVendedorPanel.getEmailTextField(),
				addCadastraVendedorPanel.getPasswordField(),
				addCadastraVendedorPanel.getPerfilTextField());
				
		for(JTextField jTextField : fields){
			clearField(jTextField);
		}
	}
	
	private void clearField(JTextField textField){
		textField.setText(null);
	}
	
	public JPanel getComponent(){
		return addCadastraVendedorPanel;
	}

}
