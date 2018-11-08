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

import br.edu.univas.listener.PesquisaProdutoListener;


public class AddConsultaProdutoPanel extends JPanel{
	
	private PesquisaProdutoListener listener;
	private JTextField nomeProdutoTextField;
	
	public AddConsultaProdutoPanel(){
		addComponents();
	}
	
	public void setListener(PesquisaProdutoListener listener){
		this.listener = listener;
	}
	
	public void addComponents(){
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel nomeProdutoLabel = new JLabel();
		nomeProdutoLabel.setText("Nome do Produto: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(15,10,10,5);
		this.add(nomeProdutoLabel, gbc);
		
		nomeProdutoTextField = new JTextField();
		gbc.gridx = 1;
	    gbc.gridy = 0;
	    gbc.weighty = 0.8;
	    gbc.weightx = 0;
	    gbc.anchor = GridBagConstraints.PAGE_START;
	    gbc.fill = GridBagConstraints.NONE;
		nomeProdutoTextField.setColumns(28);
		this.add(nomeProdutoTextField, gbc);
		
		JButton pesquisaButton = new JButton();
		pesquisaButton.setText("Pesquisar");
		pesquisaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listener.pesquisa();
			}
		});
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.weightx = 0;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(10,10,10,5);
		this.add(pesquisaButton, gbc);
		
	}
	
	public JTextField getNomeProdutoTextField() {
		return nomeProdutoTextField;
	}
	

}
