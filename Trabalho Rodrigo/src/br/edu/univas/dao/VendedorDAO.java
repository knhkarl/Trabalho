package br.edu.univas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.univas.model.Produto;
import br.edu.univas.model.Vendedor;

public class VendedorDAO {
	
private static ArrayList<Vendedor> data = new ArrayList<>();

	private Connection connection;

	public VendedorDAO() throws SQLException{
		connection = ConnectionUtil.getConnection();
	}
	
	public void save(Vendedor vendedor){
		String sql = "insert into vendedor (cpf, nome, email)" + "values (?, ?, ?)";
		
		int index = 1;
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(index++, vendedor.getCpf());
			statement.setString(index++, vendedor.getNome());
			statement.setString(index++, vendedor.getEmail());
			
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Vendedor> getAllVendedor(){
		ArrayList<Vendedor> data = new ArrayList<>();
		
		String sql = "select * from vendedor";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				Vendedor vendedor = new Vendedor();
				vendedor.setCpf(resultSet.getString("cpf"));
				vendedor.setNome(resultSet.getString("nome"));
				vendedor.setNome(resultSet.getString("email"));
				
				data.add(vendedor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

}
