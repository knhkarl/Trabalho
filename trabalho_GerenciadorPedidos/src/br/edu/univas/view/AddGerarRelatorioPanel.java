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

import br.edu.univas.listener.PesquisaGerarRelatorio;

public class AddGerarRelatorioPanel extends JPanel{
	
	private PesquisaGerarRelatorio listener;
	private JTextField datainiTextField;
	private JTextField datafinTextField;
	
	public AddGerarRelatorioPanel(){
		addComponents();
	}
	
	public void setListener(PesquisaGerarRelatorio listener){
		this.listener = listener;
	}
	
	public void addComponents(){
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel datainiLabel = new JLabel();
		datainiLabel.setText("Informe a data Inicial: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(15,10,10,5);
        this.add(datainiLabel, gbc);
        
        datainiTextField = new JTextField();
        gbc.gridx = 1;
	    gbc.gridy = 0;
	    //gbc.weighty = 0.8;
	    gbc.weightx = 0;
	    gbc.anchor = GridBagConstraints.PAGE_START;
	    gbc.fill = GridBagConstraints.NONE;
	    datainiTextField.setColumns(15);
		this.add(datainiTextField, gbc);
		
		JLabel datafinLabel = new JLabel();
		datafinLabel.setText("Informe a data Final: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 0.2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(15,10,10,5);
        this.add(datafinLabel, gbc);
        
        datafinTextField = new JTextField();
        gbc.gridx = 1;
	    gbc.gridy = 0;
	    //gbc.weighty = 0.1;
	    gbc.weightx = 0;
	    gbc.anchor = GridBagConstraints.CENTER;
	    gbc.fill = GridBagConstraints.NONE;
	    datafinTextField.setColumns(15);
	    this.add(datafinTextField, gbc);
	    
	    JButton pesquisaButton = new JButton();
		pesquisaButton.setText("Pesquisar");
		pesquisaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listener.pesquisa();
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.weightx = 0;
		gbc.weighty = 2;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(-30,10,10,5);
		this.add(pesquisaButton, gbc);
	}

	public JTextField getDatainiTextField() {
		return datainiTextField;
	}

	public JTextField getDatafinTextField() {
		return datafinTextField;
	}

}
