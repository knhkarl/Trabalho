package br.edu.univas.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.edu.univas.listener.CadastraVendedorListener;

public class AddCadastraVendedorPanel extends JPanel{
	
	private CadastraVendedorListener listener;
	private JTextField cpfTextField;
	private JTextField nomeTextField;
	private JTextField emailTextField;
	private JPasswordField passwordField;
	private JTextField perfilTextField;
	
	
	public AddCadastraVendedorPanel(){
		addComponents();
	}

	public void setListener(CadastraVendedorListener listener){
		this.listener = listener;
	}
	
	private void addComponents(){
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel cpfLabel = new JLabel();
		cpfLabel.setText("CPF: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(10,10,10,10);
		this.add(cpfLabel, gbc);
		
		cpfTextField = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(cpfTextField, gbc);
		
		JLabel nomeLabel = new JLabel();
		nomeLabel.setText("Nome: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		this.add(nomeLabel, gbc);
		
		nomeTextField = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		this.add(nomeTextField, gbc);
		
		JLabel emailLabel = new JLabel();
		emailLabel.setText("E-mail: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		this.add(emailLabel, gbc);
		
		emailTextField = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		this.add(emailTextField, gbc);
		
		JLabel passwordLabel = new JLabel();
		passwordLabel.setText("Senha: ");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.0;
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(passwordLabel, gbc);
		
		passwordField = new JPasswordField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		this.add(passwordField, gbc);
		
		JLabel perfilLabel = new JLabel();
		perfilLabel.setText("Perfil: ");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0.0;
		this.add(perfilLabel, gbc);
		
		perfilTextField = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		this.add(perfilTextField, gbc);
		
		JButton saveButton = new JButton();
		saveButton.setText("Salvar");
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listener.cadastra();
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.weightx = 0.0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		this.add(saveButton, gbc);
		
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JTextField getCpfTextField() {
		return cpfTextField;
	}

	public JTextField getNomeTextField() {
		return nomeTextField;
	}

	public JTextField getEmailTextField() {
		return emailTextField;
	}

	public JTextField getPerfilTextField() {
		return perfilTextField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

}
