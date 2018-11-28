package br.edu.univas.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import br.edu.univas.listener.AdicionarQtdProdutoListener;
import br.edu.univas.listener.PesquisaProdutoListener;
import br.edu.univas.model.Produto;


public class AddConsultaProdutoPanel extends JPanel{
	
	JTable table;
	private PesquisaProdutoListener listener;
	private JTextField nomeProdutoTextField;
	private JTextField adicionaQtdTextField;
	private JTextField codigoTextField;
	private AdicionarQtdProdutoListener listenerAdiciona;
	
	public AddConsultaProdutoPanel(){
		addComponents();
	}
	
	public void setListener(PesquisaProdutoListener listener){
		this.listener = listener;
	}
	
	public void setListener(AdicionarQtdProdutoListener listenerAdiciona){
		this.listenerAdiciona = listenerAdiciona;
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
        gbc.insets = new Insets(30,300,10,5);
		this.add(nomeProdutoLabel, gbc);
		
		nomeProdutoTextField = new JTextField();
		gbc.gridx = 1;
	    gbc.gridy = 0;
	    gbc.weighty = 0.8;
	    gbc.weightx = 0;
	    gbc.insets = new Insets(30,10,100,5);
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
		gbc.insets = new Insets(27,-230,10,5);
		this.add(pesquisaButton, gbc);
		
		JLabel headerLabel = new JLabel();
		headerLabel.setText("Pedidos Consultados");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 4;
		gbc.insets = new Insets(-100,30,30,30);
		gbc.anchor = GridBagConstraints.PAGE_START;
		this.add(headerLabel, gbc);
		
		Vector<String> columns = new Vector<>();
		columns.add("Codigo");
		columns.add("Nome");
		columns.add("Quantidade");
		
		table = new JTable(null, columns);
		
		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setPreferredSize(new Dimension (600, 300));
		tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;
		this.add(tableScrollPane, gbc);
		
		JLabel codigoLabel = new JLabel();
		codigoLabel.setText("Informe o Codigo: ");
		gbc.gridx = 0;
		gbc.gridy = 3;
        //gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        //gbc.gridwidth = 2;
        gbc.insets = new Insets(-180,-300,0,0);
		this.add(codigoLabel, gbc);
		
		codigoTextField = new JTextField();
		gbc.gridx = 0;
		gbc.weightx = 0;
		gbc.anchor = GridBagConstraints.CENTER;
	    gbc.fill = GridBagConstraints.NONE;
	    gbc.insets = new Insets(-180,-70,0,0);
	    codigoTextField.setColumns(10);
		this.add(codigoTextField, gbc);
		
		JLabel adicionaQtdLabel = new JLabel();
		adicionaQtdLabel.setText("Informe a Quantidade: ");
		gbc.gridx = 0;
		gbc.gridy = 4;
        //gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        //gbc.gridwidth = 2;
        gbc.insets = new Insets(-230,-320,0,0);
		this.add(adicionaQtdLabel, gbc);
		
		adicionaQtdTextField = new JTextField();
		gbc.gridx = 0;
		gbc.weightx = 0;
		gbc.anchor = GridBagConstraints.CENTER;
	    gbc.fill = GridBagConstraints.NONE;
	    gbc.insets = new Insets(-230,-67,0,0);
		adicionaQtdTextField.setColumns(10);
		this.add(adicionaQtdTextField, gbc);
		
		JButton adicionaQtdButton = new JButton();
		adicionaQtdButton.setText("Adicionar");
		adicionaQtdButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listenerAdiciona.adicionaQtd();
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(-260,-70,0,0);
		this.add(adicionaQtdButton, gbc);
	}
	
	public void updateProduto(ArrayList<Produto> produtos){
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		model.setRowCount(0);
		
		for (Produto produto : produtos) {
			model.addRow(new Object[]{
					produto.getCodigo(),
					produto.getDescricao(),
					produto.getQuantidade()
					
			});
		}
		
	}
	
	public JTextField getNomeProdutoTextField() {
		return nomeProdutoTextField;
	}

	public JTextField getAdicionaQtdTextField() {
		return adicionaQtdTextField;
	}

	public JTextField getCodigoTextField() {
		return codigoTextField;
	}

}
