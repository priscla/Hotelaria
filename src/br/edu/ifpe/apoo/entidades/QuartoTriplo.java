package br.edu.ifpe.apoo.entidades;

import br.edu.ifpe.apoo.apresentacao.HotelTipoQuarto;

public class QuartoTriplo extends Hospede  implements HotelTipoQuarto{
private HotelTipoQuarto  quartoDecorado;
	
	
	public QuartoTriplo(HotelTipoQuarto  quartoDecorado) {
		this. quartoDecorado= quartoDecorado;
		}




public QuartoTriplo(String nome, String cpf) {
		// TODO Auto-generated constructor stub
	}




@Override
public double getPagamento() {
	// TODO Auto-generated method stub
	return  quartoDecorado.getPagamento() + 200.00;
}
}
