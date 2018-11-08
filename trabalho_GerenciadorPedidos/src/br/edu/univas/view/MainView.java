package br.edu.univas.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.edu.univas.listener.TopButtonListener;

public class MainView extends JFrame{
	
	private TopButtonListener listener;
	private JPanel centerPanel;
	
	public MainView(){
		this.setTitle("Cadastro de Aluno");
		this.setSize(1200, 800);
		this.setMinimumSize(new Dimension(600, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		addComponents();
	}
	
	public JPanel getCenterPanel(){
		return centerPanel;
	}
	
	public void setListener(TopButtonListener listener){
		this.listener = listener;
	}
	
	private void addComponents(){
		this.setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		addButtons(northPanel);
		northPanel.setBackground(Color.gray);
		northPanel.setPreferredSize(new Dimension(0, 95));
		this.getContentPane().add(northPanel, BorderLayout.NORTH);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBackground(Color.white);
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
	}
	
	private void addButtons(JPanel panel){
		Dimension btnDimension = new Dimension(200, 80);
		
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
	}
	

}
