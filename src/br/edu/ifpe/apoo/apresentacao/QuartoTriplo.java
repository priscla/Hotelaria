package br.edu.ifpe.apoo.apresentacao;

public class QuartoTriplo  implements HotelTipoQuarto{
private HotelTipoQuarto valorQuarto;
	
	
	public QuartoTriplo(HotelTipoQuarto valorQuarto) {
		this.valorQuarto=valorQuarto;
		}



@Override
public double getPagamento() {
	// TODO Auto-generated method stub
	return valorQuarto.getPagamento() + 200.00;
}
}
