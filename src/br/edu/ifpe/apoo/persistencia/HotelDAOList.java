package br.edu.ifpe.apoo.persistencia;

import java.util.ArrayList;

import br.edu.ifpe.apoo.entidades.Hotel;


public class HotelDAOList implements IHotelDAO {
	  private static HotelDAOList instancia;

	    private HotelDAOList() {
	        new ArrayList<>();
	    }

	    public static synchronized HotelDAOList getInstancia() {
	        if (instancia == null) {
	            instancia = new HotelDAOList();
	        }

	        return instancia;
	    }

	    @Override
		public void inserir(Hotel hotel) {
			// TODO Auto-generated method stub
			
		}
}

