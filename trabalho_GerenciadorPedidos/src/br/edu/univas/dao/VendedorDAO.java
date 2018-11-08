package br.edu.univas.dao;

import java.util.ArrayList;

import br.edu.univas.model.Vendedor;

public class VendedorDAO {
	
private static ArrayList<Vendedor> data = new ArrayList<>();
	
	public void save(Vendedor vendedor){
		data.add(vendedor);
	}
	
	public ArrayList<Vendedor> getAllVendedor(){
		return data;
	}

}
