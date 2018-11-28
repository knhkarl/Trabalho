package br.edu.univas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.univas.model.Usuario;
import br.edu.univas.model.Vendedor;

public class UsuarioDAO {
	
private static ArrayList<Usuario> data = new ArrayList<>();

	private Connection connection;

	public UsuarioDAO() throws SQLException{
		connection = ConnectionUtil.getConnection();
	}
	
	public int getPerfilUsuario(String cpf){
		String sql = "select perfil from usuario where cpf_vend = '" + cpf + "';";
		
		int perfilUsuario = 0;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				perfilUsuario = resultSet.getInt("perfil");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return perfilUsuario;
	}
	
	public boolean autenticarUsuario(String cpf, String senha){
		String sql = "select * from usuario " + 
				"where cpf_vend LIKE '" + cpf +"'  and senha = '" + senha + "';";
		
		String cpfUsuario = null;
		String senhaUsuario = null;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				cpfUsuario = resultSet.getString("cpf_vend");
				senhaUsuario = resultSet.getString("senha");
			}
			
			if(cpf.equals(cpfUsuario) && senhaUsuario.equals(senha)){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void save(Usuario usuario, String cpf){
		String sql = "insert into usuario (senha, perfil, cpf_vend)" + "values (?, ?, ?)";
		
		int index = 1;
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(index++, usuario.getSenha());
			statement.setInt(index++, usuario.getPerfil());
			statement.setString(index++, cpf);
			
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
