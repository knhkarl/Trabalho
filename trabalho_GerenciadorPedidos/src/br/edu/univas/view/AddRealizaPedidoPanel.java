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

import br.edu.univas.listener.SaveButtonListener;

public class AddRealizaPedidoPanel extends JPanel{
	
	private SaveButtonListener listener;
	private JTextField nomeProdutoTextField;
	private JTextField qtdProdutoTextField;
	private JTextField cnpjClienteTextField;
	
	public AddRealizaPedidoPanel(){
		addComponents();
	}

	public void setListener(SaveButtonListener listener){
		this.listener = listener;
	}
	
	private void addComponents(){
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel nomeProdutoLabel = new JLabel();
		nomeProdutoLabel.setText("Nome do Produto: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(10,10,10,10);
		this.add(nomeProdutoLabel, gbc);
		
		nomeProdutoTextField = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(nomeProdutoTextField, gbc);
		
		JLabel qtdProdutoLabel = new JLabel();
		qtdProdutoLabel.setText("Quantidade: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		this.add(qtdProdutoLabel, gbc);
		
		qtdProdutoTextField = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		this.add(qtdProdutoTextField, gbc);
		
		JLabel cnpjClienteLabel = new JLabel();
		cnpjClienteLabel.setText("CNPJ do Cliente: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		this.add(cnpjClienteLabel, gbc);
		
		cnpjClienteTextField = new JTextField();
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		this.add(cnpjClienteTextField, gbc);
		
		JButton saveButton = new JButton();
		saveButton.setText("Salvar");
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listener.save();
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

	public JTextField getNomeProdutoTextField() {
		return nomeProdutoTextField;
	}



	public JTextField getQtdProdutoTextField() {
		return qtdProdutoTextField;
	}



	public JTextField getCnpjClienteTextField() {
		return cnpjClienteTextField;
	}

}
