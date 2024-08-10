package br.edu.ifpe.apoo.negocio;
import java.util.List;

import br.edu.ifpe.apoo.entidades.Hospede;

public class Fachada {

	
	public static void inserir(Hospede hospede) throws ExcecaoNegocio {
	ControladorHospede controlador =new ControladorHospede();
	controlador.inserir(hospede);
	
	
}
	public static void editar(Hospede hospede) throws ExcecaoNegocio {
		ControladorHospede controlador =new ControladorHospede();
		controlador.editar(hospede);
	}
	public static void remover(Hospede hospede) throws ExcecaoNegocio {
		ControladorHospede controlador =new ControladorHospede();
		controlador.remover(null);
	}
	
	public static void consultar(Hospede hospede) throws ExcecaoNegocio {
		ControladorHospede controlador =new ControladorHospede();
		controlador.consultarHospede(null);
		
}
	public static void listarTodos(Hospede hospede) throws ExcecaoNegocio {
		ControladorHospede controlador =new ControladorHospede();
		controlador.listarTodos();
	}
}