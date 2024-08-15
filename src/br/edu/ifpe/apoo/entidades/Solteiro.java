package br.edu.ifpe.apoo.entidades;

import br.edu.ifpe.apoo.apresentacao.HotelTipoQuarto;

public class Solteiro extends Hospede implements HotelTipoQuarto {
	
	private HotelTipoQuarto quartoDecorado;
	
	
	public Solteiro(HotelTipoQuarto quartoDecorado) {
		this.quartoDecorado=quartoDecorado;
	}
	
	
	public Solteiro(String nome, String cpf) {
		// TODO Auto-generated constructor stub
	}


	@Override
	public double getPagamento() {

		return quartoDecorado.getPagamento() + 100.00;
	}

}
