package br.edu.ifpe.apoo.persistencia;

public class FabricaDAO {
	  public static IHotelDAO getHotelDAO() {
	        return HotelDAOList.getInstancia();
	    }

}
