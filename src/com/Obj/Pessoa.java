package com.Obj;

public class Pessoa {
	private int codigo;
	private String nome;
	private String email;
	private String endereco;
	private int numero;
	private String telefone1;
	private String telefone2;
	// Constructors
	public Pessoa(){
		
	}
	public Pessoa(int codigo, String nome, String email, String endereco, int numero, String telefone1, String telefone2) {
		setCodigo(codigo);
		setNome(nome);
		setEmail(email);
		setEndereco(endereco);
		setNumero(numero);
		setTelefone1(telefone1);
		setTelefone2(telefone2);
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome.length() > 3)
			this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email.length() > 3)
			this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if(endereco.length() > 3)
			this.endereco = endereco;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		if(numero > 0)
			this.numero = numero;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	
}
