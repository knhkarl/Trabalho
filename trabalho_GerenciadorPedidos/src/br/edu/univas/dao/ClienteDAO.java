package br.edu.univas.dao;

import java.util.ArrayList;

import br.edu.univas.model.Cliente;

public class ClienteDAO {
	
private static ArrayList<Cliente> data = new ArrayList<>();
	
	public void save(Cliente cliente){
		data.add(cliente);
	}
	
	public ArrayList<Cliente> getAllCliente(){
		return data;
	}

}
