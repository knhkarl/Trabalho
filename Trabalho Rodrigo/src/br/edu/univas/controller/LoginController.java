package br.edu.univas.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.univas.dao.UsuarioDAO;
import br.edu.univas.listener.LoginEntrarListener;
import br.edu.univas.view.LoginPanel;
import br.edu.univas.view.MainView;

public class LoginController {
	
	private LoginPanel loginPanel;
	private MainController mainController;
	private MainView mainView;
	private UsuarioDAO daoUsuario;
	private List<JTextField> fields;
	private int perfil;
	
	
	public LoginController() throws SQLException{
		loginPanel = new LoginPanel();
		mainView = new MainView(perfil);
		
		
		loginPanel.setListener(new LoginEntrarListener() {
			
			@Override
			public void enter() {
				try {
					entrarLogin();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		fields = Arrays.asList(
				loginPanel.getCpfTextField(),
				loginPanel.getPasswordField());
		
		iniciarApp();
	}
	
	public void iniciarApp(){
		mainView.setPanel(loginPanel);
		mainView.setVisible(true);
	}
	
	public void entrarLogin() throws SQLException{
		if(validaCampos()){
			getPerfil();
			if(autenticarLogin()){
				clearFields();
				mainView.dispose();
				mainController = new MainController(perfil);
				mainController.initApp();
			}else{
				JOptionPane.showMessageDialog(null, "Cpf ou Senha inválidos!");
			}
		}else{
			JOptionPane.showMessageDialog(loginPanel, "Por favor, digite todos os campos!");
		}
	}
	
	public int getPerfil(){
		try {
			daoUsuario = new UsuarioDAO();
			String cpfUsuario = loginPanel.getCpfTextField().getText();
			perfil = daoUsuario.getPerfilUsuario(cpfUsuario);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return perfil;
	}
	
	public boolean autenticarLogin(){
		try {
			daoUsuario = new UsuarioDAO();
			
			String cpfUsuario = loginPanel.getCpfTextField().getText();
			String senha = "";
			char[] password = loginPanel.getPasswordField().getPassword();
			for (char c : password){
				senha += c;
			}
			if(daoUsuario.autenticarUsuario(cpfUsuario, senha)){
				return true;
			}else{
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
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
				loginPanel.getCpfTextField(),
				loginPanel.getPasswordField());
				
		for(JTextField jTextField : fields){
			clearField(jTextField);
		}
	}
	
	private void clearField(JTextField textField){
		textField.setText(null);
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}

}
