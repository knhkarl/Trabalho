package br.edu.univas.dao;

import java.util.ArrayList;

import br.edu.univas.model.Realiza;

public class RealizaDAO {
	
private static ArrayList<Realiza> data = new ArrayList<>();
	
	public void save(Realiza realiza){
		data.add(realiza);
	}
	
	public ArrayList<Realiza> getAllRealiza(){
		return data;
	}

}
