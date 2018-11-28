package br.edu.univas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.univas.model.Pedido;

public class PedidoDAO {
	
private static ArrayList<Pedido> data = new ArrayList<>();

	private Connection connection;

	public PedidoDAO() throws SQLException{
		connection = ConnectionUtil.getConnection();
	}
	
	public ArrayList<Pedido> fazUpdateNaData(String data, String cnpj, String numPedido, String status){
		ArrayList<Pedido> data2 = new ArrayList<>();
		String sql = "update pedido set dataDaEntrega = '" + data + "' where cnpj_cli = '" + cnpj + "' and numero = '" + numPedido + "' ";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
				
			statement.execute();
			data2 = atualizaStatus(status, cnpj, numPedido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data2;
	}
	
	public boolean verificaCnpjCompleto(String cnpj){
		String sql = "select cnpj from cliente where cnpj = '" + cnpj + "'";
		String verifica = null;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				verifica = resultSet.getString("cnpj");
			}
			
			if(cnpj.equals(verifica)){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verificaCnpjExistente(String cnpj){
		String sql = "select cnpj_cli from pedido where cnpj_cli ilike '" + cnpj + '%' + "'";
		int rows = 0;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				rows ++;
			}
			if(rows > 0){
				return true;
				}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verificaNumeroPedidoExistente(String num){
		String sql = "select numero from pedido where numero = '" + num + "'";
		String verifica = null;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				verifica = resultSet.getString("numero");
			}
			
			if(num.equals(verifica)){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verificaCnpjJuntoComNumero(String numPedido, String cnpj){
		String sql = "select numero from pedido where cnpj_cli = '" + cnpj + "' and numero = '" + numPedido + "' ";
		String verifica = null;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				verifica = resultSet.getString("numero");
			}
			
			if(verifica != null){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String retornaNomeProduto(int codigoProd){
		String sql = "select descricao from produto where codigo = '" + codigoProd + "'";
		String produto = null;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				produto = resultSet.getString("descricao");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produto;
	}
	
	public void save(Pedido pedido, String descricao){
		String sql = "insert into pedido (produto, codigo_prod, quantidade, status, dataDoPedido, dataDaPrevisao, dataDaEntrega, cnpj_cli)"  
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		int index = 1;
		String status = "Aberto";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(index++, descricao);
			statement.setInt(index++, pedido.getCodigo());
			statement.setInt(index++, pedido.getQuantidade());
			statement.setString(index++, status);
			statement.setDate(index++, pedido.getDataDoPedido());
			statement.setDate(index++, pedido.getDataDaPrevisao());
			statement.setDate(index++, pedido.getDataDaEntrega());
			statement.setString(index++, pedido.getCliente());
			
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Pedido> getPedido(String cnpjCliente){
		ArrayList<Pedido> data = new ArrayList<>();
		
		String sql = "select * from pedido where cnpj_cli ilike '" + '%' + cnpjCliente + '%' + "';";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				Pedido pedido = new Pedido();
				pedido.setProduto(resultSet.getString("produto"));
				pedido.setCodigo(resultSet.getInt("codigo_prod"));
				pedido.setQuantidade(resultSet.getInt("quantidade"));
				pedido.setNumero(resultSet.getInt("numero"));
				pedido.setStatus(resultSet.getString("status"));
				pedido.setDataDoPedido(resultSet.getDate("dataDoPedido"));
				pedido.setDataDaPrevisao(resultSet.getDate("dataDaPrevisao"));
				pedido.setDataDaEntrega(resultSet.getDate("dataDaEntrega"));
				pedido.setCliente(resultSet.getString("cnpj_cli"));
				
				data.add(pedido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public ArrayList<Pedido> getAllPedido(){
		ArrayList<Pedido> data = new ArrayList<>();
		
		String sql = "select * from pedido order by numero";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				Pedido pedido = new Pedido();
				pedido.setProduto(resultSet.getString("produto"));
				pedido.setCodigo(resultSet.getInt("codigo_prod"));
				pedido.setQuantidade(resultSet.getInt("quantidade"));
				pedido.setNumero(resultSet.getInt("numero"));
				pedido.setStatus(resultSet.getString("status"));
				pedido.setDataDoPedido(resultSet.getDate("dataDoPedido"));
				pedido.setDataDaPrevisao(resultSet.getDate("dataDaPrevisao"));
				pedido.setDataDaEntrega(resultSet.getDate("dataDaEntrega"));
				pedido.setCliente(resultSet.getString("cnpj_cli"));
				
				data.add(pedido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public ArrayList<Pedido> getPedidoEfetuado(String cnpj, String numPedido){
		ArrayList<Pedido> data = new ArrayList<>();
		
		String sql = "select * from pedido where cnpj_cli = '" + cnpj + "' and numero = '" + numPedido + "' ";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				Pedido pedido = new Pedido();
				pedido.setProduto(resultSet.getString("produto"));
				pedido.setCodigo(resultSet.getInt("codigo_prod"));
				pedido.setQuantidade(resultSet.getInt("quantidade"));
				pedido.setNumero(resultSet.getInt("numero"));
				pedido.setStatus(resultSet.getString("status"));
				pedido.setDataDoPedido(resultSet.getDate("dataDoPedido"));
				pedido.setDataDaPrevisao(resultSet.getDate("dataDaPrevisao"));
				pedido.setDataDaEntrega(resultSet.getDate("dataDaEntrega"));
				pedido.setCliente(resultSet.getString("cnpj_cli"));
				
				data.add(pedido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public ArrayList<Pedido> atualizaStatus(String status, String cnpj, String numPedido){
		ArrayList<Pedido> data = new ArrayList<>();
		
		String sql = "UPDATE pedido SET status = '" + status + "' WHERE cnpj_cli = '" + cnpj + "' AND numero = '" + numPedido + "'";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				Pedido pedido = new Pedido();
				pedido.setProduto(resultSet.getString("produto"));
				pedido.setCodigo(resultSet.getInt("codigo_prod"));
				pedido.setQuantidade(resultSet.getInt("quantidade"));
				pedido.setNumero(resultSet.getInt("numero"));
				pedido.setStatus(resultSet.getString("status"));
				pedido.setDataDoPedido(resultSet.getDate("dataDoPedido"));
				pedido.setDataDaPrevisao(resultSet.getDate("dataDaPrevisao"));
				pedido.setDataDaEntrega(resultSet.getDate("dataDaEntrega"));
				pedido.setCliente(resultSet.getString("cnpj_cli"));
				
				data.add(pedido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public boolean verificaDataInicial(String dataini){
		String sql = "select dataDoPedido from pedido where dataDoPedido = '" + dataini + "'";
				
		String verifica = null;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				verifica = resultSet.getString("dataDoPedido");
			}
			
			if(verifica != null){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verificaDataFinal(String datafin){
		String sql = "select dataDoPedido from pedido where dataDoPedido = '" + datafin + "'";
				
		String verifica = null;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				verifica = resultSet.getString("dataDoPedido");
			}
			
			if(verifica != null){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Pedido> getPedidoRelatorio(String dataini, String datafin){
		ArrayList<Pedido> data = new ArrayList<>();
		
		String sql = "select * from pedido where dataDoPedido between '" + dataini + "' and '" + datafin + "' ";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				Pedido pedido = new Pedido();
				pedido.setProduto(resultSet.getString("produto"));
				pedido.setCodigo(resultSet.getInt("codigo_prod"));
				pedido.setQuantidade(resultSet.getInt("quantidade"));
				pedido.setNumero(resultSet.getInt("numero"));
				pedido.setStatus(resultSet.getString("status"));
				pedido.setDataDoPedido(resultSet.getDate("dataDoPedido"));
				pedido.setDataDaPrevisao(resultSet.getDate("dataDaPrevisao"));
				pedido.setDataDaEntrega(resultSet.getDate("dataDaEntrega"));
				pedido.setCliente(resultSet.getString("cnpj_cli"));
				
				data.add(pedido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

}
