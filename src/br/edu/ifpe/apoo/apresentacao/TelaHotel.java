package br.edu.ifpe.apoo.apresentacao;
import java.util.Scanner;

import br.edu.ifpe.apoo.entidades.Hotel;


public class TelaHotel {
	 Scanner scanner = new Scanner (System.in);

	    public void exibir() {
	        int opcao = 0;
	        do {
	            System.out.println("Bem-vindo(a)!");
	            System.out.println("Digite 1 para cadastrar um hotel;");
	            System.out.println("Digite 2 para editar os dados de um hotel;");
	            System.out.println("Digite 3 para remover um hotel;");
	            System.out.println("Digite 4 para consultar um hotel; ou");
	            System.out.println("Digite 5 para sair");

	            try {
	                opcao = Integer.parseInt(scanner.nextLine());
	            } catch (NumberFormatException ex) {
	                System.out.println("Digite um número válido!");
	            }
	        } while (opcao < 0 || opcao > 5);

	        if (opcao == 1) {
	            this.inserir();
	        } else if (opcao == 2) {
	            this.editar();
	        } else if (opcao == 3) {
	            this.remover();
	        } else if (opcao == 4) {
	            this.consultar();
	        } else {
	            System.out.println("Saindo...");
	            // Adicione aqui qualquer lógica de encerramento da aplicação, se necessário
	        }
	    }

	    private void consultar() {
			// TODO Auto-generated method stub
			
		}

		private void remover() {
			// TODO Auto-generated method stub
			
		}

		private void editar() {
			// TODO Auto-generated method stub
			
		}

		private void inserir() {
	        Hotel hotel = new Hotel();

	        hotel.setNome(this.lerString("nome"));
	        hotel.setLocalizacao(this.lerString("localização"));
	        hotel.setQuartosDisponiveis(Integer.parseInt(this.lerString("número de quartos disponíveis")));
	        hotel.setServicoLavanderia(Boolean.parseBoolean(this.lerString("serviço de lavanderia")));

	        // Lógica para inserir o hotel
	    }

	    private String lerString(String nomeAtributo) {
	        String entrada = "";

	        while (entrada.trim().length() == 0) {
	            System.out.println("Digite " + nomeAtributo + ": ");
	            entrada = scanner.nextLine();
	        }

	        return entrada;
	    }

}
