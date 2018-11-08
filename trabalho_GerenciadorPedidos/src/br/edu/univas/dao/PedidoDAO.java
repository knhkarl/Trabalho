package br.edu.univas.dao;

import java.util.ArrayList;

import br.edu.univas.model.Pedido;

public class PedidoDAO {
	
private static ArrayList<Pedido> data = new ArrayList<>();
	
	public void save(Pedido pedido){
		data.add(pedido);
	}
	
	public ArrayList<Pedido> getAllPedido(){
		return data;
	}

}
