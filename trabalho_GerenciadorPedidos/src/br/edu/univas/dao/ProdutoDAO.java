package br.edu.univas.dao;

import java.util.ArrayList;

import br.edu.univas.model.Produto;

public class ProdutoDAO {
	
	private static ArrayList<Produto> data = new ArrayList<>();
	
	public void save(Produto produto){
		data.add(produto);
	}
	
	public ArrayList<Produto> getAllProduto(){
		return data;
	}

}
