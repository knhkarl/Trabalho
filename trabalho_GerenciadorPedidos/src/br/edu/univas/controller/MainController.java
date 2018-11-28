package br.edu.univas.controller;

import java.awt.Component;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import br.edu.univas.listener.TopButtonListener;
import br.edu.univas.view.MainView;

public class MainController {
	
	private MainView mainView;
	private AddCadastraProdutoController addCadastraProdutoController;
	private AddCadastraVendedorController addCadastraVendedorController;
	private AddCadastraClienteController addCadastraClienteController;
	private AddRealizaPedidoController addRealizaPedidoController;
	private AddConsultaProdutoController addConsultaProdutoController;
	private AddConsultaPedidoClienteController addConsultaPedidoClienteController;
	private AddGerarRelatorioController addGerarRelatorioController;
	private AddConsultaPedidoEfetuadoController addConsultaPedidoEfetuadoController;
	
	public MainController(int perfil) throws SQLException{
//		LoginController login = new LoginController();
//		login.setPerfil(perfil);
		mainView = new MainView(perfil);
		addCadastraProdutoController = new AddCadastraProdutoController();
		addCadastraVendedorController = new AddCadastraVendedorController();
		addCadastraClienteController = new AddCadastraClienteController();
		addRealizaPedidoController = new AddRealizaPedidoController();
		addConsultaProdutoController = new AddConsultaProdutoController();
		addConsultaPedidoClienteController = new AddConsultaPedidoClienteController();
		addGerarRelatorioController = new AddGerarRelatorioController();
		addConsultaPedidoEfetuadoController = new AddConsultaPedidoEfetuadoController();
	}
	
	public void initApp(){
		mainView.setListener(new TopButtonListener() {
			
			@Override
			public void showCadastraProd() {
				showCadastraProdPanel();
			}
			
			@Override
			public void showCadastraVendedor() {
				showCadastraVendedorPanel();
			}
			
			@Override
			public void showCadastraCliente() {
				showCadastraClientePanel();
			}
			
			@Override
			public void showRealiza() {
				showRealizaPanel();	
			}
			
			@Override
			public void showGerarRelatorio() {
				showGerarRelatorioPanel();
			}
			
			@Override
			public void showConsultarPedidosEfetuados() {
				showConsultarPedidosEfetuadosPanel();
			}
			
			@Override
			public void showConsultarPedidosCliente() {
				showConsultaPedidosClientePanel();
			}
			
			@Override
			public void showConsultarDisponibilidade() {
				showConsultaDisponilibilidadePanel();
			}

		});
		mainView.setVisible(true);
	}
	
	private void showCadastraProdPanel(){
		showPanel(addCadastraProdutoController.getComponent());
	}
	
	private void showCadastraVendedorPanel(){
		showPanel(addCadastraVendedorController.getComponent());
	}
	
	private void showCadastraClientePanel(){
		showPanel(addCadastraClienteController.getComponent());
	}
	
	private void showRealizaPanel(){
		showPanel(addRealizaPedidoController.getComponent());
	}
	
	private void showConsultaDisponilibilidadePanel(){
		showPanel(addConsultaProdutoController.getComponent());
	}
	
	private void showConsultaPedidosClientePanel(){
		showPanel(addConsultaPedidoClienteController.getComponent());
	}
	
	private void showGerarRelatorioPanel(){
		showPanel(addGerarRelatorioController.getComponent());
	}
	
	private void showConsultarPedidosEfetuadosPanel(){
		showPanel(addConsultaPedidoEfetuadoController.getComponent());
	}
	
	private void showPanel(Component component){
		mainView.getCenterPanel().removeAll();
		mainView.getCenterPanel().add(component);
		mainView.getCenterPanel().revalidate();
		SwingUtilities.updateComponentTreeUI(mainView);
	}

}
