package com.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor implements Serializable{

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// Sockets
		// Cria o Servidor e seta como nulo
		ServerSocket servidor = null; 

		// Cria uma conex�o para atender o cliente e seta como nulo
		Socket conexao = null;

		// Entrada de Dados
		BufferedReader entrada = null;

		//Inicializa��o das Listas e vari�veis
		Scanner in = new Scanner(System.in);
		int escolha = 0;

		StringBuilder out = new StringBuilder();
		
		try{

			/* Cria o ServerSocket na porta 7000 se estiver dispon�vel
			 * Lembrar de n�o utilizar portas abaixo de 1024, 
			 * estas s�o utilizadas pelo sistema
			 */
			servidor = new ServerSocket(7000);

			/* Aguarda uma conex�o na porta especificada e retorna 
			 * o socket que ir� comunicar com o cliente
			 */
			conexao = servidor.accept();

			//Cria um BufferedReader para o canal da stream de entrada de dados do socket conexao
			entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
			//Object entradaObj= new ObjectInputStream(conexao.getInputStream());
			PrintStream saida = new PrintStream(conexao.getOutputStream());

			InputStream conectaObj = conexao.getInputStream();
			ObjectInputStream recebeObj = new ObjectInputStream(conectaObj);
			
			//Aguarda por algum dado e imprime a linha recebida quando recebe
			do {
				String texto = entrada.readLine();
				

			}while(!"0".equals(entrada.toString()));
			  
		}catch(IOException e){
			System.out.println("Algo errado aconteceu");
		}finally{
			// Encerro o socket de comunica��o
			conexao.close();

			//Encerro o ServerSocket
			servidor.close();	
		}
	}
}