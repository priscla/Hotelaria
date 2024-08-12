package br.edu.ifpe.apoo.entidades;

import br.edu.ifpe.apoo.apresentacao.HotelTipoQuarto;

public class Solteiro extends Hospede implements HotelTipoQuarto {
	
	private HotelTipoQuarto valorQuarto;
	
	
	public Solteiro(HotelTipoQuarto valorQuarto) {
		this.valorQuarto=valorQuarto;
	}
	public Solteiro(String nome, String cpf) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public double getPagamento() {

		return valorQuarto.getPagamento() + 100.00;
	}

}
