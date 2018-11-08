package br.edu.univas.dao;

import java.util.ArrayList;

import br.edu.univas.model.Contem;

public class ContemDAO {
	
private static ArrayList<Contem> data = new ArrayList<>();
	
	public void save(Contem contem){
		data.add(contem);
	}
	
	public ArrayList<Contem> getAllContem(){
		return data;
	}

}
