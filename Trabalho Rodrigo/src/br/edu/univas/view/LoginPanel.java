package br.edu.univas.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.edu.univas.listener.LoginEntrarListener;

public class LoginPanel extends JPanel{
	
	private LoginEntrarListener listener;
	private JButton entrarButton;
	private JTextField cpfTextField;
	private JPasswordField passwordField;
	//private JPanel content;
	private String caminho = "/br/edu/univas/imagens/";
	private ImageIcon imgBemVindo = new ImageIcon(getClass().getResource(caminho + "bem-vindo.png"));
	private JLabel bemVindo = new JLabel(imgBemVindo);
	private GridBagConstraints gbc;
	
	public LoginPanel(){
		addImagens();
		addComponents();
	}
	
	public void setListener(LoginEntrarListener listener){
		this.listener = listener;
	}
	
	public void addImagens(){
		//this.setPreferredSize(new Dimension (500, 200));
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		//gbc.weightx = 0.2;
		//gbc.insets = new Insets(1,-500,10,200);
		gbc.anchor = GridBagConstraints.CENTER;
		ajustarImagem(bemVindo, imgBemVindo);
		this.add(bemVindo, gbc);
		
	}
	
	public void ajustarImagem(JLabel imgLabel, ImageIcon imgIcon){
		imgLabel.setIcon(new ImageIcon(imgIcon.getImage().getScaledInstance(500, 250, Image.SCALE_DEFAULT)));
	}

	private void addComponents() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel loginLabel = new JLabel();
		loginLabel.setText("LOGIN");
		gbc.insets = new Insets(1,1,10,1);
		gbc.gridx = 0;
        gbc.gridy = 1;
        //gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        loginLabel.setFont(new Font("Arial", Font.BOLD, 35));
        this.add(loginLabel,gbc);
		
		JLabel cpfLabel = new JLabel();
		cpfLabel.setText("CPF: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
        gbc.weighty = 0.2;
        gbc.weighty = 0;
        gbc.weightx = 0.5;
        gbc.insets = new Insets(1,1,10,270);
        gbc.anchor = GridBagConstraints.CENTER;
        //gbc.gridwidth = 1;
        this.add(cpfLabel, gbc);
		
		cpfTextField = new JTextField();
		gbc.gridx = 0;
	    gbc.gridy = 2;
	    gbc.weightx = 0.5;
	    gbc.insets = new Insets(1,-30,10,350);
	    gbc.anchor = GridBagConstraints.LINE_END;
	    cpfTextField.setColumns(20);
	    this.add(cpfTextField, gbc);
		
		JLabel passwordLabel = new JLabel();
		passwordLabel.setText("Senha: ");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(1,1,10,270);
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(passwordLabel, gbc);
		
		passwordField = new JPasswordField();
		gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(1,-30,10,350);
        gbc.anchor = GridBagConstraints.LINE_END;
        passwordField.setColumns(20);
        this.add(passwordField, gbc);
        
        entrarButton = new JButton();
        entrarButton.setText("Entrar");
        entrarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.enter();	
			}
		});
        gbc.gridx = 0;
        gbc.gridy = 4;
        //gbc.fill = new GridBagConstraints().CENTER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(1,1,1,1);
        this.add(entrarButton, gbc);
	}

	public JTextField getCpfTextField() {
		return cpfTextField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setCpfTextField(JTextField cpfTextField) {
		this.cpfTextField = cpfTextField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
	
	public JPanel getLogin(){
		return this;
	}

}
