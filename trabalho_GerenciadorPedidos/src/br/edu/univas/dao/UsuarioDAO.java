package br.edu.univas.dao;

import java.util.ArrayList;

import br.edu.univas.model.Usuario;

public class UsuarioDAO {
	
private static ArrayList<Usuario> data = new ArrayList<>();
	
	public void save(Usuario usuario){
		data.add(usuario);
	}
	
	public ArrayList<Usuario> getAllUsuario(){
		return data;
	}

}
