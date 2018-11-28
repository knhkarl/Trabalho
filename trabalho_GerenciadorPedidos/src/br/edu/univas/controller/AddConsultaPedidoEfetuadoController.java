package br.edu.univas.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import br.edu.univas.dao.PedidoDAO;
import br.edu.univas.listener.AtualizaDataListener;
import br.edu.univas.listener.AtualizaStatus;
import br.edu.univas.listener.PesquisaPedidosEmAberto;
import br.edu.univas.view.AddConsultaPedidoEfetuadoPanel;

public class AddConsultaPedidoEfetuadoController {
	
	private String cnpj;
	private String numPedido;
	private AddConsultaPedidoEfetuadoPanel addConsultaPedidoEfetuadoPanel;
	private PedidoDAO daoPedido;
	private String status;
	private Timer timer;
	
	public AddConsultaPedidoEfetuadoController() throws SQLException{
		daoPedido = new PedidoDAO();
		addConsultaPedidoEfetuadoPanel = new AddConsultaPedidoEfetuadoPanel();
		
		addConsultaPedidoEfetuadoPanel.setListener(new PesquisaPedidosEmAberto() {
			
			@Override
			public void pesquisa() {
				pesquisaPedidosEmAberto();
				
			}
		});
		
		addConsultaPedidoEfetuadoPanel.setListener(new AtualizaStatus() {
			
			@Override
			public void atualiza() {
				atualizaStatus();
				
			}
		});
		
		addConsultaPedidoEfetuadoPanel.setListener(new AtualizaDataListener() {
			
			@Override
			public void atualizaData() {
				atualizaDataEntrega();
				
			}
		});
		
		addConsultaPedidoEfetuadoPanel.removeDataEntrega();
	}
	 
	public AddConsultaPedidoEfetuadoPanel pesquisaPedidosEmAberto(){
		cnpj = addConsultaPedidoEfetuadoPanel.getCnpjTextField().getText();
		numPedido = addConsultaPedidoEfetuadoPanel.getNumPedidoTextField().getText();
		
		if(!daoPedido.verificaCnpjCompleto(cnpj)){
			JOptionPane.showMessageDialog(addConsultaPedidoEfetuadoPanel, "CNPJ não encontrado!");
		}else{
			addConsultaPedidoEfetuadoPanel.updatePedidoEfetuado(daoPedido.getPedido(cnpj));
		}
		if(numPedido.isEmpty()){
			JOptionPane.showMessageDialog(addConsultaPedidoEfetuadoPanel, "Informe o numero do pedido!");
		}else{
			if(!daoPedido.verificaCnpjJuntoComNumero(numPedido, cnpj)){
				JOptionPane.showMessageDialog(addConsultaPedidoEfetuadoPanel, "Esse numero não corresponde a esse pedido!");
			}else{
			addConsultaPedidoEfetuadoPanel.updatePedidoEfetuado(daoPedido.getPedidoEfetuado(cnpj, numPedido));
			clearFields();
			}
		}
		return addConsultaPedidoEfetuadoPanel;
		
	}
	
	public void atualizaStatus(){
		timer = new Timer();
		status = (String) addConsultaPedidoEfetuadoPanel.getCourseCombobox().getSelectedItem();
		
		
		addConsultaPedidoEfetuadoPanel.updatePedidoEfetuado(daoPedido.atualizaStatus(status, cnpj, numPedido));
		TimerTask tarefa = new TimerTask() {
			
			@Override
			public void run() {
				
				getComponent();
			}
		};
		
		addConsultaPedidoEfetuadoPanel.updatePedidoEfetuado(daoPedido.getPedidoEfetuado(cnpj, numPedido));
		
		if(status.equals("Entregue")){
			timer.schedule(tarefa, 15000);
			addConsultaPedidoEfetuadoPanel.reaparecerDataEntrega();
			SwingUtilities.updateComponentTreeUI(addConsultaPedidoEfetuadoPanel);
		}
		timer.schedule(tarefa, 3000);

	}
	
	public AddConsultaPedidoEfetuadoPanel atualizaDataEntrega(){
		String data;
		data = addConsultaPedidoEfetuadoPanel.getDataEntregaTextField().getText();
		addConsultaPedidoEfetuadoPanel.updatePedidoEfetuado(daoPedido.fazUpdateNaData(data, cnpj, numPedido, status));
		addConsultaPedidoEfetuadoPanel.updatePedidoEfetuado(daoPedido.getPedidoEfetuado(cnpj, numPedido));
		clearFields2();
		addConsultaPedidoEfetuadoPanel.removeDataEntrega();
		SwingUtilities.updateComponentTreeUI(addConsultaPedidoEfetuadoPanel);
		return addConsultaPedidoEfetuadoPanel;
	}
	
	private void clearFields(){
		List<JTextField> fields = Arrays.asList(
				addConsultaPedidoEfetuadoPanel.getCnpjTextField(),
				addConsultaPedidoEfetuadoPanel.getNumPedidoTextField(),
				addConsultaPedidoEfetuadoPanel.getDataEntregaTextField());
				
				
		for(JTextField jTextField : fields){
			clearField(jTextField);
		}
	}
	
	private void clearFields2(){
		List<JTextField> fields = Arrays.asList(
				addConsultaPedidoEfetuadoPanel.getDataEntregaTextField());
				
				
		for(JTextField jTextField : fields){
			clearField(jTextField);
		}
	}
	
	private void clearField(JTextField textField){
		textField.setText(null);
	}
	
	public JPanel getComponent(){
		addConsultaPedidoEfetuadoPanel.getCourseCombobox().setSelectedItem("Aberto");
		addConsultaPedidoEfetuadoPanel.updatePedidoEfetuado(daoPedido.getAllPedido());
		return addConsultaPedidoEfetuadoPanel;
	}

}
