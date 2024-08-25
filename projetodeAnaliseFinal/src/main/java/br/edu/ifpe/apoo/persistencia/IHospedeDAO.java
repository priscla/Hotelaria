package br.edu.ifpe.apoo.persistencia;

import br.edu.ifpe.apoo.entidades.Hospede;

import java.util.List;


public interface IHospedeDAO {
	void inserir(Hospede hospede);
	void editar(Hospede hospede);
	Hospede remover(String cpf);

	Hospede consultar(String cpf);
	List<Hospede> listarTodos();


}
