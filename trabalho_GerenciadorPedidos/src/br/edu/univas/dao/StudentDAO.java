package br.edu.univas.dao;

import java.util.ArrayList;

import br.edu.univas.model.Cliente;
import br.edu.univas.model.Contem;
import br.edu.univas.model.Produto;

public class StudentDAO {
	
	private static ArrayList<Produto> data = new ArrayList<>();
	
	public void save(Produto produto){
		data.add(produto);
	}
	
	public ArrayList<Produto> getAll(){
		return data;
	}
	
	private static ArrayList<Contem> data1 = new ArrayList<>();
	
	public void save(Contem contem){
		data1.add(contem);
	}
	
	public ArrayList<Contem> getAllContem(){
		return data1;
	}
	
	private static ArrayList<Cliente> data2 = new ArrayList<>();
	
	public void save(Cliente cliente){
		data2.add(cliente);
	}
	
	public ArrayList<Cliente> getAllCliente(){
		return data2;
	}
	
	

}
