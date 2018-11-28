package br.edu.univas.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.postgresql.jdbc.EscapedFunctions;

import br.edu.univas.controller.LoginController;
import br.edu.univas.listener.TopButtonListener;

public class MainView extends JFrame{
	
	private TopButtonListener listener;
	private JPanel centerPanel;
	private JPanel northPanel;
	private JPanel westPanel;
	private int perfilUsuario = 0;
	
	public MainView(int perfil) throws SQLException{
		this.setTitle("Cadastro de Aluno");
		this.setSize(1350, 800);
		//this.setResizable(false);
		this.setMinimumSize(new Dimension(1350, 800));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.perfilUsuario = perfil;
		addComponents();
	}
	
	public JPanel getCenterPanel(){
		return centerPanel;
	}
	
	public void setListener(TopButtonListener listener){
		this.listener = listener;
	}
	
	public void addComponents(){
		this.setLayout(new BorderLayout());
		
		northPanel = new JPanel();
		addNorthButtons(northPanel);
		northPanel.setPreferredSize(new Dimension(0,65));
		northPanel.setBackground(Color.gray);
		this.getContentPane().add(northPanel, BorderLayout.NORTH);
		
		westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(210, 50));
		addWestButtons(westPanel);
		westPanel.setBackground(Color.gray);
		this.getContentPane().add(westPanel, BorderLayout.WEST);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBackground(Color.WHITE);
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
	}
	
	public void addWestButtons(JPanel panel){
		Dimension btnDimension = new Dimension(200, 50);
		
		if(perfilUsuario == 1){
			JButton cadastraProduto = new JButton();
			cadastraProduto.setText("Cadastrar Produto");
			cadastraProduto.setPreferredSize(btnDimension);
			cadastraProduto.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.showCadastraProd();
				}
			});
			panel.add(cadastraProduto);
			
			JButton cadastraVendedor = new JButton();
			cadastraVendedor.setText("Cadastrar Vendedor");
			cadastraVendedor.setPreferredSize(btnDimension);
			cadastraVendedor.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.showCadastraVendedor();
				}
			});
			panel.add(cadastraVendedor);
			
			JButton cadastraCliente = new JButton();
			cadastraCliente.setText("Cadastrar Cliente");
			cadastraCliente.setPreferredSize(btnDimension);
			cadastraCliente.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.showCadastraCliente();
				}
			});
			panel.add(cadastraCliente);
		
		}else{
			if(perfilUsuario == 2){
				JButton cadastraProduto = new JButton();
				cadastraProduto.setText("Cadastrar Produto");
				cadastraProduto.setPreferredSize(btnDimension);
				cadastraProduto.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						listener.showCadastraProd();
					}
				});
				panel.add(cadastraProduto);
				
				JButton cadastraCliente = new JButton();
				cadastraCliente.setText("Cadastrar Cliente");
				cadastraCliente.setPreferredSize(btnDimension);
				cadastraCliente.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						listener.showCadastraCliente();
					}
				});
				panel.add(cadastraCliente);
			}
		}
	}
	
	public void addNorthButtons(JPanel panel){
		Dimension btnDimension = new Dimension(200, 50);
		
		if(perfilUsuario == 1){
			JButton realizarButton = new JButton();
			realizarButton.setText("Realizar Pedido");
			realizarButton.setPreferredSize(btnDimension);
			realizarButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.showRealiza();
				}
			});
			panel.add(realizarButton);
			
			JButton consultaDisponibilidadeButton = new JButton();
			consultaDisponibilidadeButton.setText("Consultar Disponibilidade");
			consultaDisponibilidadeButton.setPreferredSize(btnDimension);
			consultaDisponibilidadeButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.showConsultarDisponibilidade();
				}
			});
			panel.add(consultaDisponibilidadeButton);
			
			JButton consultaPedidosClienteButton = new JButton();
			consultaPedidosClienteButton.setText("Consultar Pedidos");
			consultaPedidosClienteButton.setPreferredSize(btnDimension);
			consultaPedidosClienteButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.showConsultarPedidosCliente();
				}
			});
			panel.add(consultaPedidosClienteButton);
			
			JButton consultarPedidosEfetuadosButton = new JButton();
			consultarPedidosEfetuadosButton.setText("Pedidos Em Aberto");
			consultarPedidosEfetuadosButton.setPreferredSize(btnDimension);
			consultarPedidosEfetuadosButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.showConsultarPedidosEfetuados();
				}
			});
			panel.add(consultarPedidosEfetuadosButton);
			
			JButton gerarRelatorioButton = new JButton();
			gerarRelatorioButton.setText("Gerar Relatorio");
			gerarRelatorioButton.setPreferredSize(btnDimension);
			gerarRelatorioButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					listener.showGerarRelatorio();
				}
			});
			panel.add(gerarRelatorioButton);
		}else{
			if(perfilUsuario == 2){
				JButton realizarButton = new JButton();
				realizarButton.setText("Realizar Pedido");
				realizarButton.setPreferredSize(btnDimension);
				realizarButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						listener.showRealiza();
					}
				});
				panel.add(realizarButton);
				
				JButton consultaDisponibilidadeButton = new JButton();
				consultaDisponibilidadeButton.setText("Consultar Disponibilidade");
				consultaDisponibilidadeButton.setPreferredSize(btnDimension);
				consultaDisponibilidadeButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						listener.showConsultarDisponibilidade();
					}
				});
				panel.add(consultaDisponibilidadeButton);
				
				JButton consultaPedidosClienteButton = new JButton();
				consultaPedidosClienteButton.setText("Consultar Pedidos");
				consultaPedidosClienteButton.setPreferredSize(btnDimension);
				consultaPedidosClienteButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						listener.showConsultarPedidosCliente();
					}
				});
				panel.add(consultaPedidosClienteButton);
			}
		}
	}

	public void setPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
		
		northPanel.repaint();
		northPanel.removeAll();
		northPanel.setBackground(Color.BLACK);
		
		westPanel.repaint();
		westPanel.removeAll();
		westPanel.setBackground(null);
		westPanel.setBackground(Color.BLACK);
		
		JPanel eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(200, 50));
		eastPanel.setBackground(Color.BLACK);
		this.getContentPane().add(eastPanel, BorderLayout.EAST);
		
		JPanel southPanel = new JPanel();
		southPanel.setPreferredSize(new Dimension(0, 65));
		southPanel.setBackground(Color.BLACK);
		this.getContentPane().add(southPanel, BorderLayout.SOUTH);

	}
	
}
