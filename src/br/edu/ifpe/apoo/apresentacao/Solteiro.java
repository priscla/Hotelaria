package br.edu.ifpe.apoo.apresentacao;

public class Solteiro implements HotelTipoQuarto {
	
	private HotelTipoQuarto valorQuarto;
	
	
	public Solteiro(HotelTipoQuarto valorQuarto) {
		this.valorQuarto=valorQuarto;
	}
	@Override
	public double getPagamento() {

		return valorQuarto.getPagamento() + 100.00;
	}

}
