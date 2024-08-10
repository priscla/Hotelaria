package br.edu.ifpe.apoo.main;

import br.edu.ifpe.apoo.apresentacao.TelaHospede;

import br.edu.ifpe.apoo.apresentacao.Diaria;

import br.edu.ifpe.apoo.apresentacao.HotelTipoQuarto;
import br.edu.ifpe.apoo.apresentacao.QuartoDuplo;
import br.edu.ifpe.apoo.apresentacao.QuartoTriplo;
import br.edu.ifpe.apoo.apresentacao.Solteiro;
import br.edu.ifpe.apoo.excecoes.ExcecaoNegocio;



 public class Main {
	 public static void main(String[] args)  {
		 //  new TelaHospede().listarTodos();
		 
		   

			HotelTipoQuarto valorQuarto = new Diaria();

			System.out.println("Valor da diária: " + valorQuarto.getPagamento());

			HotelTipoQuarto valorQuartoTriplo = new QuartoTriplo(valorQuarto);

			System.out.println("Valor do quarto Triplo: " + valorQuartoTriplo.getPagamento());
			
		
		}

	    }
 


