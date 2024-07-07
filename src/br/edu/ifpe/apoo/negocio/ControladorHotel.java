package br.edu.ifpe.apoo.negocio;

import br.edu.ifpe.apoo.entidades.Hotel;
import br.edu.ifpe.apoo.persistencia.FabricaDAO;
import br.edu.ifpe.apoo.persistencia.IHotelDAO;

public class ControladorHotel implements IControladorHotel {


    public void inserir(Hotel hotel) throws ExcecaoNegocio {
        if (!isValido(hotel)) {
            throw new ExcecaoNegocio();
        }

        try {
            IHotelDAO dao = FabricaDAO.getHotelDAO();
            dao.inserir(hotel);
            System.out.println("Hotel inserido com sucesso!");
        } catch (Exception ex) {
            throw new ExcecaoNegocio();
        }
    }

    private boolean isValido(Hotel hotel) {
        // Implemente a lógica de validação do hotel aqui
        // Por exemplo, verifique se o nome não está vazio, se a localização é válida, etc.
        // Se o hotel for considerado válido, retorne true; caso contrário, retorne false.
        return hotel != null && hotel.getNome() != null && !hotel.getNome().isEmpty();
    }
}


