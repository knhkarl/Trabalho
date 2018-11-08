package br.edu.univas.model;

public class Cliente {
	
	private String cnpj;
	private String razaoSocial;
	private Vendedor vendedor;
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public int getCpfVendedor(){
		int cpf = this.vendedor.getCpf();
		return cpf;
	}

}
