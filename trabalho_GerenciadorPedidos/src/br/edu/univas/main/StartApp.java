package br.edu.univas.main;

import java.sql.SQLException;

import br.edu.univas.controller.LoginController;

public class StartApp {
	
	public static void main(String[] args){
		
//		try {
//			MainController controller = new MainController();
//			controller.initApp();
//		} catch (SQLException e) {
//			System.out.println("Deu ruim");
//			e.printStackTrace();
//		}
		
		try {
			LoginController frame = new LoginController();
		} catch (SQLException e) {
			System.out.println("Deu ruim");
			e.printStackTrace();
		}

	}

}
