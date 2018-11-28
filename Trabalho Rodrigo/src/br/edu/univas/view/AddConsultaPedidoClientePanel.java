package br.edu.univas.view;

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

import br.edu.univas.listener.PesquisaPedidosClienteListener;
import br.edu.univas.model.Pedido;

public class AddConsultaPedidoClientePanel extends JPanel{
	
	JTable table;
	
	private PesquisaPedidosClienteListener listener;
	private JTextField nomeClienteTextField;
	
	
	public AddConsultaPedidoClientePanel() {
		addComponents();
	}
	
	public void setListener(PesquisaPedidosClienteListener listener){
		this.listener = listener;
	}
	
	public void addComponents(){
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel nomeClienteLabel = new JLabel();
		nomeClienteLabel.setText("Informe o cnpj do cliente: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(30,300,10,5);
		this.add(nomeClienteLabel, gbc);
		
		nomeClienteTextField = new JTextField();
		gbc.gridx = 1;
	    gbc.gridy = 0;
	    gbc.weighty = 0.8;
	    gbc.weightx = 0;
	    gbc.insets = new Insets(30,10,100,5);
	    gbc.anchor = GridBagConstraints.PAGE_START;
	    gbc.fill = GridBagConstraints.NONE;
	    nomeClienteTextField.setColumns(28);
		this.add(nomeClienteTextField, gbc);
		
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
		columns.add("CNPJ do Cliente");
		columns.add("Numero do Pedido");
		columns.add("Produto");
		columns.add("Codigo");
		columns.add("Quantidade");
		columns.add("Status");
		columns.add("Data do Pedido");
		columns.add("Data de Previsao");
		columns.add("Data de Entrega");
		
		
		
		table = new JTable(null, columns);
		
		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;
		this.add(tableScrollPane, gbc);
	}
	
	public void updatePedido(ArrayList<Pedido> pedidos){
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		model.setRowCount(0);
		
		for (Pedido pedido : pedidos) {
			model.addRow(new Object[]{
					pedido.getCliente(),
					pedido.getNumero(),
					pedido.getProduto(),
					pedido.getCodigo(),
					pedido.getQuantidade(),
					pedido.getStatus(),
					pedido.getDataDoPedido(),
					pedido.getDataDaPrevisao(),
					pedido.getDataDaEntrega()
					
			});
		}
		
	}

	public JTextField getNomeClienteTextField() {
		return nomeClienteTextField;
	}

}
