package br.edu.univas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.univas.model.Produto;

public class ProdutoDAO {
	
	private static ArrayList<Produto> data = new ArrayList<>();
	
	private Connection connection;
	private PedidoDAO daoPedido = new PedidoDAO();

	public ProdutoDAO() throws SQLException{
		connection = ConnectionUtil.getConnection();
	}
	
	public ArrayList<Produto> adicionaQuantidade(int codigo, int qtd){
		ArrayList<Produto> data = new ArrayList<>();
		String sql = "update produto set quantidade = quantidade + '" + qtd + "' where codigo = '" + codigo + "'";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
				
			statement.execute();
			data = getProdutoAdicionado(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public boolean verificaNomeProdutoExistente(String nomeProd){
		String sql = "select * from produto where descricao ilike '" + nomeProd + '%' + "'";
		int rows = 0;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				rows++;
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
	
	public boolean verificaProdutoExistente(int codigo){
		String sql = "select codigo from produto where codigo = '" + codigo + "'";
		int rows = 0;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				rows++;
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
	
	public boolean verificaQtdEstoque(int codigo, int produtoQtd){
		String sql = "select quantidade from produto where codigo = '" + codigo + "'";
		int qtd = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				qtd = resultSet.getInt("quantidade");
			}
			
			if(produtoQtd <= qtd){
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verificaQtdEstoqueCnpj(int codigo, int produtoQtd, String cnpj){
		String sql = "select quantidade from produto where codigo = '" + codigo + "'";
		int qtd = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				qtd = resultSet.getInt("quantidade");
			}
			
			if(produtoQtd <= qtd){
				boolean verificaCnpjCompleto = daoPedido.verificaCnpjCompleto(cnpj);
				if(verificaCnpjCompleto == true){
				fazUpdateNoEstoque(codigo, produtoQtd);
				return true;
				}
				return false;
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void fazUpdateNoEstoque(int codigo, int produtoQtd){
		String sql = "update produto set quantidade = quantidade - '" + produtoQtd + "' where codigo = '" + codigo + "'";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
				
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void save(Produto produto){
		String sql = "insert into produto (codigo, descricao, quantidade)" + "values (?, ?, ?)";
		
		int index = 1;
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(index++, produto.getCodigo());
			statement.setString(index++, produto.getDescricao());
			statement.setInt(index++, produto.getQuantidade());
			
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Produto> getAllProduto(){
		ArrayList<Produto> data = new ArrayList<>();
		
		String sql = "select * from produto order by descricao";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				Produto produto = new Produto();
				produto.setCodigo(resultSet.getInt("codigo"));
				produto.setDescricao(resultSet.getString("descricao"));
				produto.setQuantidade(resultSet.getInt("quantidade"));
				
				data.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public ArrayList<Produto> getProdutoAdicionado(int codigo){
		ArrayList<Produto> data = new ArrayList<>();
		
		String sql = "select * from produto where codigo = '" + codigo + "'";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				Produto produto = new Produto();
				produto.setCodigo(resultSet.getInt("codigo"));
				produto.setDescricao(resultSet.getString("descricao"));
				produto.setQuantidade(resultSet.getInt("quantidade"));
				
				data.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public ArrayList<Produto> getProduto(String prod){
		ArrayList<Produto> data = new ArrayList<>();

		String sql = "select * from produto where descricao ilike '" + prod + '%' + "';";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				Produto produto = new Produto();
				produto.setCodigo(resultSet.getInt("codigo"));
				produto.setDescricao(resultSet.getString("descricao"));
				produto.setQuantidade(resultSet.getInt("quantidade"));
				
				data.add(produto);
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

}
