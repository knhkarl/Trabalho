package br.edu.univas.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import br.edu.univas.model.Cliente;
import br.edu.univas.model.Contem;
import br.edu.univas.model.Produto;

public class AddConsultaPedidoEfetuadoPanel extends JPanel{
	
	JTable table;
	
	public AddConsultaPedidoEfetuadoPanel() {
		addComponents();
	}
	
	private void addComponents(){
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel headerLabel = new JLabel();
		headerLabel.setText("Pedidos Efetuados");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(headerLabel, gbc);
		
		Vector<String> columns = new Vector<>();
		columns.add("Nome do Produto");
		columns.add("Quantidade");
		columns.add("CNPJ");
		
		table = new JTable(null, columns);
		
		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		this.add(tableScrollPane, gbc);
	}
	
	public void updatePedidosProduto(ArrayList<Produto> produtos){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		model.setRowCount(0);
		
		for (Produto produto : produtos) {
			model.addRow(new Object[]{
					produto.getDescricao()
			});
		}
	}
	
	public void updatePedidosContem(ArrayList<Contem> contens){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		//model.setRowCount(0);
		
		for (Contem contem : contens) {
			model.addRow(new Object[]{
					contem.getQuantidade()
			});
		}
	}
	
	public void updatePedidosCliente(ArrayList<Cliente> clientes){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		//model.setRowCount(0);
		
		for (Cliente cliente : clientes) {
			model.addRow(new Object[]{
					cliente.getCnpj()
			});
		}
	}

}
