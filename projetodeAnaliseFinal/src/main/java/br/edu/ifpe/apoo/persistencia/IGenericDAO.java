package br.edu.ifpe.apoo.persistencia;

import br.edu.ifpe.apoo.excecoes.ExcecaoNegocio;

import java.util.List;

public interface IGenericDAO<T> {
	 void inserir(T objeto);
	
	void editar(T objeto)throws ExcecaoNegocio;
	
	boolean remover(String cpf)throws ExcecaoNegocio;
	T consultar(String cpf);
	public List<T> listar();
}
