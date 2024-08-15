package br.edu.ifpe.apoo.entidades;

import br.edu.ifpe.apoo.apresentacao.HotelTipoQuarto;

public class QuartoDuplo extends Hospede implements HotelTipoQuarto{
private HotelTipoQuarto quartoDecorado;
	
	
	public QuartoDuplo(HotelTipoQuarto quartoDecorador) {
		this.quartoDecorado=quartoDecorado;
		}
	

	

	public QuartoDuplo(String nome, String cpf) {
		// TODO Auto-generated constructor stub
	}




	@Override
	public double getPagamento() {
		// TODO Auto-generated method stub
		return quartoDecorado.getPagamento() + 150.00;
	}

}
