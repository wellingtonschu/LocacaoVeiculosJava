package com.Default;

import java.util.Scanner;

import com.Controle.Locadora;
import com.Excecoes.PlacaException;
import com.Excecoes.QtdCpfException;
import com.Excecoes.QtdPlacaException;
import com.Excecoes.SoLetrasException;
import com.Excecoes.SoNumerosException;
import com.Objetos.Cliente;
import com.Objetos.Funcionario;

public class Main {

	public static void main(String[] args)
			throws QtdCpfException, SoNumerosException, QtdPlacaException, PlacaException, SoLetrasException {

		Scanner entrada = new Scanner(System.in);
		Locadora l = new Locadora();
		int a = -1, b = -1, c = -1;
		boolean login = false;
		String tipo = "";
		String cpfCliente = "";
		String cpfFuncionario = "";
		String cpf = "";

		// INICIALIZAÇÃO DE CLIENTE, CARRO E FUNCIONARIO.
		l.adicionarCliente("12345678901", "Alcemar", "13/03/1986", "CE", "123", "0");
		l.adicionarVeiculo("123123", "Volks", 250, "QWX3636", "Vermelho", "GOL", 70);
		l.adicionarFuncionarios("98765432101", "Ramon", "13/03/1986", "solteiro", "123", 44);

		Data dataH = new Data();
		String dataHoje = dataH.saberDiaDeHoje();
		int diaH = dataH.fatiarDia(dataHoje);
		int mesH = dataH.fatiarMes(dataHoje);
		int anoH = dataH.fatiarAno(dataHoje);
		int data_Hoje = dataH.trasformarEmInteiro(diaH, mesH, anoH);

		while (login != true) {
			System.out.println("+-----------------------------------------------+");

			System.out.println("Sistema de Login da Locação de Carros");
			System.out.println("1 - Logar Clientes");
			System.out.println("2 - Logar Funcionario");
			System.out.println("3 - Inentradarever cliente");
			System.out.println("4 - Inentradarever Funcionário");
			a = entrada.nextInt();
			switch (a) {

			case 1:
				System.out.println("CPF");
				cpfCliente = entrada.next();
				System.out.println("Senha");
				String senha_cliente = entrada.next();
				Cliente cliente = l.procurarClientes(cpfCliente);
				if (cliente.checarSenha(cpfCliente, senha_cliente)) {
					login = true;
					tipo = "cliente";
					System.out.println("Logado!");
				}
				break;

			case 2:
				System.out.println("CPF");
				cpfFuncionario = entrada.next();
				System.out.println("Senha");
				String senha_funcionario = entrada.next();
				Funcionario funcionario = l.procurarFuncionario(cpfFuncionario);
				if (funcionario.checarSenha(cpfFuncionario, senha_funcionario)) {
					login = true;
					tipo = "funcionario";
				}
				break;

			case 3:
				System.out.println("CPF");
				cpfCliente = entrada.next();
				System.out.println("Nome");
				String nome = entrada.next();
				System.out.println("Data");
				String data = entrada.next();
				System.out.println("Estado");
				String estado = entrada.next();
				System.out.println("Senha");
				String senha = entrada.next();
				System.out.println("Renda");
				String renda = entrada.next();

				try {
					boolean x;
					x = l.adicionarCliente(cpfCliente, nome, data, estado, senha, renda);
					if (x == true) {
						System.out.println("O cliente foi cadastrado com sucesso!!");
						login = true;
						tipo = "cliente";
					} else {
						System.out.println("CPF já usado!!!");
					}
				} catch (QtdCpfException e) {
					e.getMessage();
				} catch (SoNumerosException e) {
					System.out.println("no CPF.");
					e.getMessage();
				} catch (SoLetrasException e) {
					System.out.println("no nome ou no estado civil.");
					e.getMessage();
				}
				break;

			case 4:
				System.out.println("CPF");
				cpfFuncionario = entrada.next();
				System.out.println("Nome");
				String nome_funcionario = entrada.next();
				System.out.println("Data");
				String data_funcionario = entrada.next();
				System.out.println("Estado Civil");
				String estado_funcionario = entrada.next();
				System.out.println("Senha");
				senha_funcionario = entrada.next();
				System.out.println("Horas de Trabalho");
				int horas_funcionario = entrada.nextInt();

				try {
					l.adicionarFuncionarios(cpfFuncionario, nome_funcionario, data_funcionario, estado_funcionario,
							senha_funcionario, horas_funcionario);
					login = true;
					tipo = "funcionario";
				} catch (QtdCpfException e) {
					e.getMessage();
				} catch (SoNumerosException e) {
					System.out.println("no CPF.");
					e.getMessage();
				} catch (SoLetrasException e) {
					System.out.println("no nome ou no estado civil.");
					e.getMessage();
				}
				break;

			default:
				break;
			}

			while (login != false && tipo.equalsIgnoreCase("cliente")) {
				System.out.println("+-----------------------------------------------+");

				System.out.println("Sistema de Locação de Carros");
				System.out.println("1 - Alugar Carro");
				System.out.println("2 - Listar Disponiveis");
				System.out.println("3 - Reservar Carro");
				System.out.println("4 - Valor a pagar");
				System.out.println("0 - Logout");
				b = entrada.nextInt();

				switch (b) {

				case 1:
					System.out.println("Data inicial");
					System.out.print(diaH);
					System.out.print("/" + mesH);
					System.out.println("/" + anoH);
					System.out.println("Dia Final");
					int diaF = entrada.nextInt();
					System.out.println("Mes Final");
					int mesF = entrada.nextInt();
					System.out.println("Ano Final");
					int anoF = entrada.nextInt();
					System.out.println("Placa do veiculo");
					String placa = entrada.next();

					String data_final = diaF + "/" + mesF + "/" + anoF;

					Data dataF = new Data();
					int dataFinal = dataF.trasformarEmInteiro(diaF, mesF, anoF);
					l.adicionarAluguel(l.procurarClientes(cpfCliente), data_Hoje, dataFinal, l.procurarVeiculos(placa),
							dataHoje, data_final);
					break;

				case 2:
					l.listarVeiculosDisponiveis();
					break;

				case 3:
					System.out.println("Dia inicial");
					int diaI2 = entrada.nextInt();
					System.out.println("Mes inicial");
					int mesI2 = entrada.nextInt();
					System.out.println("Ano inicial");
					int anoI2 = entrada.nextInt();
					System.out.println("Dia Final");
					int diaF2 = entrada.nextInt();
					System.out.println("Mes Final");
					int mesF2 = entrada.nextInt();
					System.out.println("Ano Final");
					int anoF2 = entrada.nextInt();
					System.out.println("Placa do veiculo");
					placa = entrada.next();

					Data dataI2 = new Data();
					int dataInicial2 = dataI2.trasformarEmInteiro(diaI2, mesI2, anoI2);

					Data dataF2 = new Data();
					int dataFinal2 = dataF2.trasformarEmInteiro(diaF2, mesF2, anoF2);

					String data_inicial2 = diaI2 + "/" + mesF2 + "/" + anoF2;
					String data_final2 = diaF2 + "/" + mesF2 + "/" + anoF2;

					l.adicionarReserva(dataInicial2, dataFinal2, l.procurarVeiculos(placa),
							l.procurarClientes(cpfCliente), data_Hoje, data_inicial2, data_final2);
					break;

				case 0:
					login = false;
					tipo = "";
					break;

				case 4:
					Cliente client = l.procurarClientes(cpfCliente);
					System.out.println("Você deve R$:" + client.getSaldo());

				default:
					break;
				}
			}

			while (login != false && tipo.equalsIgnoreCase("funcionario")) {
				System.out.println("+-----------------------------------------------+");

				System.out.println("Sistema de Locação de Carros");
				System.out.println("1 - Adicionar Clientes");
				System.out.println("2 - Adicionar Carro");
				System.out.println("3 - Listar Clientes");
				System.out.println("4 - Listar Carros");
				System.out.println("5 - Listar Alugueis");
				System.out.println("6 - Listar Disponiveis");
				System.out.println("7 - Listar Reservas");
				System.out.println("8 - Adicionar Funcionario");
				System.out.println("9 - Listar Funcionarios");
				System.out.println("0 - Logout");
				c = entrada.nextInt();

				switch (c) {

				case 1:
					System.out.println("CPF");
					cpf = entrada.next();
					System.out.println("Nome");
					String nome = entrada.next();
					System.out.println("Data");
					String data = entrada.next();
					System.out.println("Estado");
					String estado = entrada.next();
					System.out.println("Senha");
					String senha = entrada.next();
					System.out.println("Renda");
					String renda = entrada.next();
					System.out.println("Valor depositado");
					float saldo = entrada.nextFloat();

					try {
						boolean x;
						x = l.adicionarCliente(cpf, nome, data, estado, senha, renda);
						if (x == true) {
							System.out.println("O cliente foi cadastrado com sucesso!!");
						} else {
							System.out.println("CPF já usado!!!");
						}
					} catch (QtdCpfException e) {
						e.getMessage();
					} catch (SoNumerosException e) {
						System.out.println("no CPF.");
						e.getMessage();
					} catch (SoLetrasException e) {
						System.out.println("no nome ou no estado civil.");
						e.getMessage();
					}
					break;

				case 2:
					System.out.println("chassi");
					String chassi = entrada.next();
					System.out.println("marca");
					String marca = entrada.next();
					System.out.println("km");
					float km = entrada.nextFloat();
					System.out.println("placa");
					String placa = entrada.next();
					System.out.println("cor");
					String cor = entrada.next();
					System.out.println("modelo");
					String modelo = entrada.next();
					System.out.println("valor");
					Float valor = entrada.nextFloat();
					try {
						boolean y;
						y = l.adicionarVeiculo(chassi, marca, km, placa, cor, modelo, valor);
						if (y == true) {
							System.out.println("Veiculo cadastrado com sucesso!!!");
						} else {
							System.out.println("Já existe um veiculo cadastrado com os mesmos dados!!!");
						}
					} catch (QtdPlacaException e) {
						e.getMessage();
					} catch (PlacaException e) {
						e.getMessage();
					} catch (SoLetrasException e) {
						System.out.println("na cor.");
						e.getMessage();
					}
					break;

				case 3:
					l.listarClientes();
					break;

				case 4:
					l.listarVeiculos();
					break;

				case 5:
					System.out.println(l.listarVeiculosAlugados());
					break;

				case 6:
					l.listarVeiculosDisponiveis();
					break;

				case 7:
					l.listarVeiculosReservados();
					break;

				case 8:
					System.out.println("CPF");
					cpfFuncionario = entrada.next();
					System.out.println("Nome");
					String nome_funcionario = entrada.next();
					System.out.println("Data");
					String data_funcionario = entrada.next();
					System.out.println("Estado Civil");
					String estado_funcionario = entrada.next();
					System.out.println("Senha");
					String senha_funcionario = entrada.next();
					System.out.println("Horas de Trabalho");
					int horas_funcionario = entrada.nextInt();

					try {
						l.adicionarFuncionarios(cpfFuncionario, nome_funcionario, data_funcionario, estado_funcionario,
								senha_funcionario, horas_funcionario);
					} catch (QtdCpfException e) {
						e.getMessage();
					} catch (SoNumerosException e) {
						System.out.println("no CPF.");
						e.getMessage();
					} catch (SoLetrasException e) {
						System.out.println("no nome ou no estado civil.");
						e.getMessage();
					}
					break;

				case 9:
					l.listarFuncionarios();
					break;

				case 0:
					login = false;
					tipo = "";
					break;

				default:
					break;
				}
			}
		}
	}
}
