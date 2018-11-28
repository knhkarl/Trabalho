package br.edu.univas.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import br.edu.univas.controller.AddConsultaPedidoEfetuadoController;
import br.edu.univas.listener.AtualizaDataListener;
import br.edu.univas.listener.AtualizaStatus;
import br.edu.univas.listener.PesquisaPedidosEmAberto;
import br.edu.univas.model.Pedido;

public class AddConsultaPedidoEfetuadoPanel extends JPanel{
	
	JTable table;
	private PesquisaPedidosEmAberto listener;
	private AtualizaStatus listenerAtualiza;
	private AtualizaDataListener listenerAtualizaData;
	private JTextField cnpjTextField;
	private JTextField numPedidoTextField;
	private JTextField dataEntregaTextField;
	private JComboBox<String> courseCombobox;
	private AddConsultaPedidoEfetuadoController addConsultaPedidoEfetuadoController;
	GridBagConstraints gbc = new GridBagConstraints();
	private JButton atualizaDataButton = new JButton();
	private JLabel dataEntregaLabel = new JLabel();
	
	public AddConsultaPedidoEfetuadoPanel() {
		addComponents();
	}
	
	public void setListener(PesquisaPedidosEmAberto listener){
		this.listener = listener;
	}
	
	public void setListener(AtualizaStatus listenerAtualiza){
		this.listenerAtualiza = listenerAtualiza;
	}
	
	public void setListener(AtualizaDataListener listenerAtualizaData){
		this.listenerAtualizaData = listenerAtualizaData;
	}
	
	private void addComponents(){
		this.setLayout(new GridBagLayout());
		
		JLabel cnpjLabel = new JLabel();
		cnpjLabel.setText("Informe o CNPJ completo: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(30,350,10,5);
        this.add(cnpjLabel, gbc);
        
        cnpjTextField = new JTextField();
        gbc.gridx = 1;
	    gbc.gridy = 0;
	    gbc.weightx = 0;
	    gbc.insets = new Insets(30,0,100,5);
	    gbc.anchor = GridBagConstraints.PAGE_START;
	    gbc.fill = GridBagConstraints.NONE;
	    cnpjTextField.setColumns(15);
		this.add(cnpjTextField, gbc);
		
		JLabel numPedidoLabel = new JLabel();
		numPedidoLabel.setText("Informe o numero do pedido: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 0.2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(30,350,50,5);
        this.add(numPedidoLabel, gbc);
        
        numPedidoTextField = new JTextField();
        gbc.gridx = 1;
	    gbc.gridy = 0;
	    gbc.weightx = 0;
	    gbc.insets = new Insets(30,0,50,5);
	    gbc.anchor = GridBagConstraints.CENTER;
	    gbc.fill = GridBagConstraints.NONE;
	    numPedidoTextField.setColumns(15);
	    this.add(numPedidoTextField, gbc);
	    
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
		gbc.insets = new Insets(-200,120,20,-400);
		this.add(pesquisaButton, gbc);
		
		JLabel headerLabel = new JLabel();
		headerLabel.setText("Pedidos Efetuados");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 4;
		gbc.insets = new Insets(-10,30,30,30);
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
		tableScrollPane.setPreferredSize(new Dimension (600, 200));
		tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(-200,30,30,30);
		this.add(tableScrollPane, gbc);
		
		JLabel courseLabel = new JLabel();
		courseLabel.setText("Status: ");
		gbc.gridx = 0;
		gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets( -100,-300,10,5);
		this.add(courseLabel, gbc);
		
		courseCombobox = new JComboBox<>();
		courseCombobox.addItem("Aberto");
		courseCombobox.addItem("Preparado");
		courseCombobox.addItem("Enviado");
		courseCombobox.addItem("Entregue");
		courseCombobox.setPreferredSize(new Dimension(120, 20));
		gbc.insets = new Insets(-100,-600,100,5);
		gbc.gridx = 1;
		gbc.gridy = 6;
		this.add(courseCombobox, gbc);
		
		JButton atualizaButton = new JButton();
		atualizaButton.setText("Atualizar Status");
		atualizaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listenerAtualiza.atualiza();
			}
		});
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(-103,-500,10,5);
		this.add(atualizaButton, gbc);
		
		adicionaDataEntregaPrimeiro();
		removeDataEntrega();
	}
	
	public void adicionaDataEntregaPrimeiro(){
				
		dataEntregaLabel.setText("Data da Entrega: ");
		gbc.gridx = 0;
		gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(-170,-320,0,0);
        this.add(dataEntregaLabel, gbc);
        
        dataEntregaTextField = new JTextField();
        gbc.gridx = 0;
	    gbc.gridy = 7;
	    gbc.insets = new Insets(-170,0,0,90);
	    gbc.anchor = GridBagConstraints.PAGE_START;
	    gbc.fill = GridBagConstraints.NONE;
	    dataEntregaTextField.setColumns(11);
		this.add(dataEntregaTextField, gbc);
		
		atualizaDataButton.setText("Atualizar Data");
		atualizaDataButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listenerAtualizaData.atualizaData();
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(-174,180,0, 0);
		this.add(atualizaDataButton, gbc);
	}
	
	public void reaparecerDataEntrega(){
		dataEntregaTextField.setVisible(true);
		atualizaDataButton.setVisible(true);
		dataEntregaLabel.setVisible(true);
	}
	
	public void updatePedidoEfetuado(ArrayList<Pedido> pedidos){
		
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
	
	public void removeDataEntrega(){
		dataEntregaTextField.setVisible(false);
		atualizaDataButton.setVisible(false);
		dataEntregaLabel.setVisible(false);
	}

	public JTextField getCnpjTextField() {
		return cnpjTextField;
	}

	public JTextField getNumPedidoTextField() {
		return numPedidoTextField;
	}

	public JComboBox<String> getCourseCombobox() {
		return courseCombobox;
	}

	public void setCourseCombobox(JComboBox<String> courseCombobox) {
		this.courseCombobox = courseCombobox;
	}

	public JTextField getDataEntregaTextField() {
		return dataEntregaTextField;
	}

}
