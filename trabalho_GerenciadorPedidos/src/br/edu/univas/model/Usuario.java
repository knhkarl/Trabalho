package br.edu.univas.model;

public class Usuario {
	
	private int id;
	private String senha;
	private int perfil;
	private Vendedor vendedor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getPerfil() {
		return perfil;
	}
	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}
	
	public String getCpfVendedor(){
		String cpf = this.vendedor.getCpf();
		return cpf;
	}

}
