package com.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Cliente{
	public static void main(String[] args) throws IOException, ClassNotFoundException {
	
		// Utilizada para leitura do teclado
		Scanner entrada = new Scanner(System.in);

		// Vari�vel para armazenar o texto que ser� digitado
		String texto = "";

		// Socket Cliente
		Socket cliente = null;

		// Stream (tubo) de saida de dados
		PrintStream saida = null;
		
		BufferedReader dados = null;
		
		//Inicializa��o das Listas e vari�veis
		Scanner in = new Scanner(System.in);
		int escolha = 0;
		
		try{
			// Cria o socket com os par�metros
			
			try {
				cliente = new Socket("127.0.0.1",7000);
			} catch (ConnectException e) {
				System.out.println(e.getMessage());
			}
			
			dados = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			// Stream de saida de dados
			saida = new PrintStream(cliente.getOutputStream());
			ObjectOutputStream enviaObj = new ObjectOutputStream(saida);
			
			do{
				
				switch (escolha) {
				case 1:
					saida.println(escolha);
					System.out.println("REALIZAR ATENDIMENTO");

					System.out.println("A seguir ser� mostrado os m�dicos cadastrados\nPressione enter para continuar...");
					in.nextLine();in.nextLine();
					do{
						texto = dados.readLine();
						System.out.println(texto); 
					}while(dados.ready());
					
					System.out.print("\nDigite o c�digo do M�dico que realizar� o atendimento: ");
					saida.println(in.nextInt());
					
					System.out.println(dados.readLine());
					
					
					
					System.out.println("ATENDIMENTO REALIZADO");
					System.out.print("Digite um C�digo para o Atendimento: ");
					saida.println(in.nextInt());
					
					
					break;
				case 2:
					saida.println(escolha);
					//pac = new Cliente();
					int q1 = 0;
					int q2 = 0;
					int q3 = 0;
					int q4 = 0;
					System.out.println("CADASTRAR NOVO PACIENTE");
					System.out.print("C�digo: ");
					//pac.setCodigo(in.nextInt());
					in.nextLine();
					System.out.print("Nome: ");
					//pac.setNome(in.nextLine());
					System.out.print("Telefone: ");
					//pac.setFone(in.nextLine());
					
					System.out.print("H� alguma Fratura? (1 - Sim, 0 - N�o)\nR: ");
					q1 = in.nextInt();
					System.out.print("H� alguma Hemorragia? (1 - Sim, 0 - N�o)\nR: ");
					q2 = in.nextInt();
					System.out.print("H� alguma Queimadura? (1 - Sim, 0 - N�o)\nR: ");
					q3 = in.nextInt();
					System.out.print("Houve Desmaio? (1 - Sim, 0 - N�o)\nR: ");
					q4 = in.nextInt();
					if((q1 + q2 + q3 + q4) == 4)
						//pac.setClassificacao("Vermelho");
					if((q1 + q2 + q3 + q4) == 3)
						//pac.setClassificacao("Amarelo");
					if((q1 + q2 + q3 + q4) == 1 || (q1 + q2 + q3 + q4) == 2)
						//pac.setClassificacao("Verde");
					if((q1 + q2 + q3 + q4) == 0)
						//pac.setClassificacao("Azul");
					
					//Define Status como ativo (em espera para atendimento)
					//pac.setStatus("1");
					
					//enviaObj.writeObject(pac);       
			        System.out.println(dados.readLine());
					//menu.esperar();
					break;
				case 3:
					saida.println(escolha);
					enviaObj = new ObjectOutputStream(saida);
					//med = new Medicos();
					//System.out.println(menu.imprimeMenu("CADASTRAR NOVO M�DICO"));
					System.out.print("C�digo: ");
					//med.setCodigo(in.nextInt());
					in.nextLine();
					System.out.print("Nome: ");
					//med.setNome(in.nextLine());
					System.out.print("Telefone: ");
				//med.setFone(in.nextLine());
					
					//enviaObj.writeObject(med);       
			        System.out.println(dados.readLine());

					//menu.esperar();
					break;
				case 4:
					saida.println(escolha);
					//System.out.println(menu.imprimeMenu("SELECIONE A LISTA QUE DESEJA VISUALIZAR"));
					System.out.println("1 - Atendimentos");
					System.out.println("2 - Pacientes");
					System.out.println("3 - M�dicos");
					System.out.print("\nValor escolhido: ");
					saida.println(in.nextInt());
					do{
						texto = dados.readLine();
						System.out.println(texto); 
					}while(dados.ready());
					//menu.esperar();
					break;
				default:
					//System.out.println(menu.imprimeMenu("Item n�o pertence ao Menu, favor digitar Novamente"));
					in.nextLine();
				}
				
			}while(escolha != 0);
			//System.out.println(menu.imprimeMenu("Programa Encerrado"));
			saida.println(0);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}finally{
			// Encerra o socket cliente
			//cliente.close();
		}
	}
	
}
