package br.edu.ifpe.apoo.negocio;
import br.edu.ifpe.apoo.entidades.Hospede;



import br.edu.ifpe.apoo.negocio.ExcecaoNegocio;
import java.util.List;



public interface IControladorHospede {
	 void inserir(Hospede hospede) throws ExcecaoNegocio, br.edu.ifpe.apoo.excecoes.ExcecaoNegocio;
	 
	 void editar(Hospede hospede) throws ExcecaoNegocio, br.edu.ifpe.apoo.excecoes.ExcecaoNegocio;
	 
	 void remover(String cpf) throws ExcecaoNegocio;
	 
	
	List<Hospede> listarTodos()throws ExcecaoNegocio, br.edu.ifpe.apoo.excecoes.ExcecaoNegocio;


	Hospede consultarHospede(String cpf)throws ExcecaoNegocio, br.edu.ifpe.apoo.excecoes.ExcecaoNegocio;

	
	    

	 
	
	
}
