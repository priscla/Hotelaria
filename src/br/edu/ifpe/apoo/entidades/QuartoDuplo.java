package br.edu.ifpe.apoo.entidades;

import br.edu.ifpe.apoo.apresentacao.HotelTipoQuarto;

public class QuartoDuplo extends Hospede implements HotelTipoQuarto{
private HotelTipoQuarto valorQuarto;
	
	
	public QuartoDuplo(HotelTipoQuarto valorQuarto) {
		this.valorQuarto=valorQuarto;
		}
	

	public QuartoDuplo(String nome, String cpf) {
		// TODO Auto-generated constructor stub
	}


	@Override
	public double getPagamento() {
		// TODO Auto-generated method stub
		return valorQuarto.getPagamento() + 150.00;
	}

}
