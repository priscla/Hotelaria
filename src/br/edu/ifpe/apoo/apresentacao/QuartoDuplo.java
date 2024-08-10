package br.edu.ifpe.apoo.apresentacao;

public class QuartoDuplo implements HotelTipoQuarto{
private HotelTipoQuarto valorQuarto;
	
	
	public QuartoDuplo(HotelTipoQuarto valorQuarto) {
		this.valorQuarto=valorQuarto;
		}

	@Override
	public double getPagamento() {
		// TODO Auto-generated method stub
		return valorQuarto.getPagamento() + 150.00;
	}

}
