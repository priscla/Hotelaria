package br.edu.ifpe.apoo.persistencia;

import java.util.List;

import  br.edu.ifpe.apoo.entidades.Hospede;

public class FabricaDAO {
	  public static IHospedeDAO getHospedeDAO() {
	        return HospedeDAOList.getInstancia();
	       

}
}