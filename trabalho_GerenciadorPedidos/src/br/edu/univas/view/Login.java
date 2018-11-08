package br.edu.univas.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel{
	
	public Login(){
		addComponents();
	}

	private void addComponents() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel loginLabel = new JLabel();
		loginLabel.setText("LOGIN");
		gbc.insets = new Insets(1,1,10,1);
		gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginLabel.setFont(new Font("Arial", Font.BOLD, 50));
        this.add(loginLabel,gbc);
		
		JLabel cpfLabel = new JLabel();
		cpfLabel.setText("CPF: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
        gbc.weighty = 0.2;
        gbc.weighty = 0;
        gbc.weightx = 0.5;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridwidth = 1;
        gbc.gridy = 1;
		this.add(cpfLabel, gbc);
		
		JTextField cpfTextField = new JTextField();
		gbc.gridx = 1;
	    gbc.gridy = 1;
	    gbc.weightx = 0.5;
	    gbc.anchor = GridBagConstraints.LINE_START;
	    cpfTextField.setColumns(20);
		this.add(cpfTextField, gbc);
		
		JLabel passwordLabel = new JLabel();
		passwordLabel.setText("Senha: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(passwordLabel, gbc);
		
		JPasswordField passwordField = new JPasswordField();
		gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        passwordField.setColumns(20);
        this.add(passwordField, gbc);
        
        JButton entrarButton = new JButton();
        entrarButton.setText("Entrar");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = new GridBagConstraints().CENTER;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(1,75,1,1);
        this.add(entrarButton, gbc);
		
	}
	
	public JPanel getView(){
		return this;
	}

}
