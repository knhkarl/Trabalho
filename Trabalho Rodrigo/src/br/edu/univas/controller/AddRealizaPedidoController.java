package br.edu.univas.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.dao.PedidoDAO;
import br.edu.univas.dao.ProdutoDAO;
import br.edu.univas.listener.SaveButtonListener;
import br.edu.univas.model.Pedido;
import br.edu.univas.view.AddRealizaPedidoPanel;

public class AddRealizaPedidoController {
	
	private AddRealizaPedidoPanel addRealizaPedidoPanel;
	private Pedido pedido;
	private ProdutoDAO daoProduto;
	private PedidoDAO daoPedido;
	private List<JTextField> fields;

	
	public AddRealizaPedidoController() throws SQLException{
		daoProduto = new ProdutoDAO();
		daoPedido = new PedidoDAO();
		addRealizaPedidoPanel = new AddRealizaPedidoPanel();
		addRealizaPedidoPanel.setListener(new SaveButtonListener() {
			
			@Override
			public void save() {
				savePedido();
			}
		});
		
		fields = Arrays.asList(
				//addRealizaPedidoPanel.getNomeProdutoTextField(),
				addRealizaPedidoPanel.getCodigoTextField(),
				addRealizaPedidoPanel.getQtdProdutoTextField(),
				addRealizaPedidoPanel.getCnpjClienteTextField(),
				addRealizaPedidoPanel.getDataTextField(),
				addRealizaPedidoPanel.getDataPrevisaoTextField());
	}
	
	public void savePedido(){
		if(validaCampos()){
		pedido = new Pedido();
		
		//pedido.setProduto(addRealizaPedidoPanel.getNomeProdutoTextField().getText());
		int codigoProd = Integer.parseInt(addRealizaPedidoPanel.getCodigoTextField().getText());
		pedido.setCodigo(codigoProd);
		int produtoQtd = Integer.parseInt(addRealizaPedidoPanel.getQtdProdutoTextField().getText());
		pedido.setQuantidade(produtoQtd);
		String cnpj = addRealizaPedidoPanel.getCnpjClienteTextField().getText();
		pedido.setCliente(cnpj);
		
		String descricao = daoPedido.retornaNomeProduto(codigoProd);
		
		try {
			Date dataPedido = Date.valueOf(addRealizaPedidoPanel.getDataTextField().getText());
			pedido.setDataDoPedido(dataPedido);
			Date dataPrevisao = Date.valueOf(addRealizaPedidoPanel.getDataPrevisaoTextField().getText());
			pedido.setDataDaPrevisao(dataPrevisao);
		} catch (Exception e) {
			e.printStackTrace();
		}
			boolean produtoExistente = false;
			boolean verificaEstoque = false;
			boolean verificaEstoqueECnpj = false;
			boolean verificaCNPJ = false;
			
			produtoExistente = daoProduto.verificaProdutoExistente(codigoProd);
			verificaEstoqueECnpj = daoProduto.verificaQtdEstoqueCnpj(codigoProd, produtoQtd, cnpj);
			verificaEstoque = daoProduto.verificaQtdEstoque(codigoProd, produtoQtd);
			verificaCNPJ = daoPedido.verificaCnpjCompleto(cnpj);
			if(produtoExistente && verificaEstoqueECnpj){
				daoPedido.save(pedido, descricao);
				clearFields();
				JOptionPane.showMessageDialog(addRealizaPedidoPanel, "Pedido Realizado Com Sucesso!");
			}else{
				
				if(!produtoExistente){
					JOptionPane.showMessageDialog(addRealizaPedidoPanel, "Esse produto não consta no estoque!");
				}
				if(!verificaEstoque){
					JOptionPane.showMessageDialog(addRealizaPedidoPanel, "Quantidade solicitada maior que a do estoque!");
				}
				if(!verificaCNPJ){
					JOptionPane.showMessageDialog(addRealizaPedidoPanel, "Cliente não cadastrado!");
				}
			}
		
		}else{
			JOptionPane.showMessageDialog(addRealizaPedidoPanel, "Por favor, digite todos os campos para realizar um novo Pedido!");
		}
	}
	
	private boolean validaCampos() {
		for (JTextField jTextField : fields) {
			if (jTextField.getText() == null || jTextField.getText().trim().equals("")) {
				return false;
			}
		}
		return true;
	}
	
	private void clearFields(){
		List<JTextField> fields = Arrays.asList(
				//addRealizaPedidoPanel.getNomeProdutoTextField(),
				addRealizaPedidoPanel.getCodigoTextField(),
				addRealizaPedidoPanel.getQtdProdutoTextField(),
				addRealizaPedidoPanel.getCnpjClienteTextField(),
				addRealizaPedidoPanel.getDataTextField(),
				addRealizaPedidoPanel.getDataPrevisaoTextField());
				
		for(JTextField jTextField : fields){
			clearField(jTextField);
		}
	}
	
	private void clearField(JTextField textField){
		textField.setText(null);
	}
	
	public JPanel getComponent(){
		return addRealizaPedidoPanel;
	}

}
