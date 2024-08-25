package br.edu.ifpe.apoo.persistencia;

public class FabricaDAO {
	  public static <T> GenericDAO getDAO() {
	        return GenericDAO.getInstancia();
	       

}

	
	}
