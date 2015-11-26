package com.Obj;

public class Veiculo {
	
	private int codigo;
	private String marca;
	private String modelo;
	private String tipo;
	private int numeroPortas;
	private String tracao;
	
	public Veiculo(int codigo, String marca, String modelo, String tipo, int numeroPortas, String tracao) {
		super();
		setCodigo(codigo);
		setMarca(marca);
		setModelo(modelo);
		setTipo(tipo);
		setNumeroPortas(numeroPortas);
		setTracao(tracao);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		if (codigo > 0)
		this.codigo = codigo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		if (marca.length() > 0)
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		if (modelo.length() > 0)
		this.modelo = modelo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		if (tipo == "Sedã" || tipo == "Hatch" || tipo == "Perua" || tipo == "Camionete" || tipo == "SUV" || tipo == "Furgão")
		this.tipo = tipo;
	}
	public int getNumeroPortas() {
		return numeroPortas;
	}
	public void setNumeroPortas(int numeroPortas) {
		if (numeroPortas > 3)
		this.numeroPortas = numeroPortas;
	}
	public String getTracao() {
		return tracao;
	}
	public void setTracao(String tracao) {
		if (tracao == "Frontal" || tracao == "Traseira" || tracao == "Integral")
		this.tracao = tracao;
	}
	
}
