package com.Objetos;

import com.Excecoes.PlacaException;
import com.Excecoes.QtdPlacaException;
import com.Excecoes.SoLetrasException;

public class Carro extends Veiculo {

	private int potencia;

	public Carro(String chassi, String marca, float kilometragem, String placa, String cor, String modelo,
			float valorDiaria, int potencia) throws QtdPlacaException, PlacaException, SoLetrasException {
		super(chassi, marca, kilometragem, placa, cor, modelo, valorDiaria);
		this.potencia = potencia;
	}

}
