package com.List;
import java.util.ArrayList;
import com.Obj.*;
import java.util.List;
public class ListClientes {
	List<Cliente> lista = new ArrayList<Cliente>();
	
	public ListClientes(List<Cliente> list) {
		lista = list;
	}
	
	public void setLista(List<Cliente> lista){
		this.lista = lista;
	}	
	
	public void inserir(Cliente cli){
		lista.add(cli);
	}
	
	public void deletar(int cod_paciente){
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCodigo() == cod_paciente)
				lista.remove(i);
		}
	}
	public List<Cliente> getLista(){
		return lista;
	}
}
