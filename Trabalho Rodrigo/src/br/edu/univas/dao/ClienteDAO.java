package br.edu.univas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.univas.model.Cliente;
import br.edu.univas.model.Produto;
import br.edu.univas.model.Vendedor;

public class ClienteDAO {
	
private static ArrayList<Cliente> data = new ArrayList<>();

private Connection connection;

	public ClienteDAO() throws SQLException{
		connection = ConnectionUtil.getConnection();
	}
	
	public boolean verificaCpfVendedorExistente(String cpf){
		String sql = "select cpf from vendedor where cpf = '" + cpf + "'";
		String verifica = null;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				verifica = resultSet.getString("cpf");
			}
			
			if(cpf.equals(verifica)){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void save(Cliente cliente){
		String sql = "insert into cliente (cnpj, razaoSocial, cpf_vend)" + "values (?, ?, ?)";
		
		int index = 1;
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(index++, cliente.getCnpj());
			statement.setString(index++, cliente.getRazaoSocial());
			statement.setString(index++, cliente.getCpf_vend());

			
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Cliente> getAllCliente(){
		ArrayList<Cliente> data = new ArrayList<>();
		
		String sql = "select * from cliente";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				Cliente cliente = new Cliente();
				cliente.setCnpj(resultSet.getString("cnpj"));
				cliente.setRazaoSocial(resultSet.getString("razaoSocial"));
				cliente.setCpf_vend(resultSet.getString("cpf_vend"));
				
				data.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

}
