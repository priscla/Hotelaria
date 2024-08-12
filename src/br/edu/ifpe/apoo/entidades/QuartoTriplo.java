package br.edu.ifpe.apoo.entidades;

import br.edu.ifpe.apoo.apresentacao.HotelTipoQuarto;

public class QuartoTriplo extends Hospede  implements HotelTipoQuarto{
private HotelTipoQuarto valorQuarto;
	
	
	public QuartoTriplo(HotelTipoQuarto valorQuarto) {
		this.valorQuarto=valorQuarto;
		}



public QuartoTriplo(String nome, String cpf) {
		// TODO Auto-generated constructor stub
	}



@Override
public double getPagamento() {
	// TODO Auto-generated method stub
	return valorQuarto.getPagamento() + 200.00;
}
}
