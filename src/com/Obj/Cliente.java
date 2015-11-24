package com.Obj;

public class Cliente extends Pessoa{
	private String cpf;
	private String rg;
	private String sexo;
	public Cliente() {
		super();
	}
	public Cliente(String cpf, String rg, String sexo) {
		super();
		setCpf(cpf);
		setRg(rg);
		setSexo(sexo);
	}
	public Cliente(int codigo, String nome, String email, String endereco, int numero, String telefone1,
			String telefone2, String cpf, String rg, String sexo, Pessoa pessoa) {
		super(codigo, nome, email, endereco, numero, telefone1, telefone2);
		setCpf(cpf);
		setRg(rg);
		setSexo(sexo);
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if(cpf.length() == 14)
			this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		if(rg.length() > 5 && rg.length() < 13)
		this.rg = rg;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		if("masculino".equals(sexo) || "feminino".equals(sexo))
			this.sexo = sexo;
	}
	
	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", rg=" + rg + ", sexo=" + sexo + ", toString()=" + super.toString() + "]";
	}
	
	
	
}