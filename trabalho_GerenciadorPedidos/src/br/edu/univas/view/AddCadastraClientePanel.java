package br.edu.univas.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.listener.CadastraClienteListener;

public class AddCadastraClientePanel extends JPanel{
	
	private CadastraClienteListener listener;
	private JTextField cnpjTextField;
	private JTextField razaoSocialTextField;
	private JTextField cpfTextField;
	
	public AddCadastraClientePanel(){
		addComponents();
	}

	public void setListener(CadastraClienteListener listener){
		this.listener = listener;
	}
	
	private void addComponents(){
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel cnpjLabel = new JLabel();
		cnpjLabel.setText("CNPJ: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(10,10,10,10);
		this.add(cnpjLabel, gbc);
		
		cnpjTextField = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(cnpjTextField, gbc);
		
		JLabel razaoSocialLabel = new JLabel();
		razaoSocialLabel.setText("Razão Social: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		this.add(razaoSocialLabel, gbc);
		
		razaoSocialTextField = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		this.add(razaoSocialTextField, gbc);
		
		JLabel cpfLabel = new JLabel();
		cpfLabel.setText("CPF do vendedor : ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		this.add(cpfLabel, gbc);
		
		cpfTextField = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		this.add(cpfTextField, gbc);
		
		JButton saveButton = new JButton();
		saveButton.setText("Salvar");
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listener.cadastra();
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.weightx = 0.0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		this.add(saveButton, gbc);
		
	}

	public JTextField getCnpjTextField() {
		return cnpjTextField;
	}

	public JTextField getRazaoSocialTextField() {
		return razaoSocialTextField;
	}

	public JTextField getCpfTextField() {
		return cpfTextField;
	}

}
