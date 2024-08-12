package br.edu.ifpe.apoo.apresentacao;
import br.edu.ifpe.apoo.entidades.*;

import java.util.Scanner;

import java.util.List;

import br.edu.ifpe.apoo.entidades.Hospede;
import br.edu.ifpe.apoo.entidades.Solteiro;
import br.edu.ifpe.apoo.excecoes.ExcecaoNegocio;
import br.edu.ifpe.apoo.log.LogHotel;
import br.edu.ifpe.apoo.negocio.FabricaControlador;
import br.edu.ifpe.apoo.negocio.Fachada;
import br.edu.ifpe.apoo.negocio.IControladorHospede;

public class TelaHospede {
	private Scanner scanner;
	//private AdapterDataNascimento dataNascimentoAdapter;
	private Fachada fachada;

	public TelaHospede() {
		this.scanner = new Scanner(System.in);
		//this.dataNascimentoAdapter = new DataNascimento();
		this.fachada = new Fachada();
	
	          
	            
	}

		public void exibir() {
			int opcao;
			do {
				System.out.println("Bem-vindo(a)!");
	            System.out.println("Digite 1 para cadastrar um hóspede;");
	            System.out.println("Digite 2 para editar os dados do hóspede;");
	            System.out.println("Digite 3 para remover o hóspede;");
	            System.out.println("Digite 4 para consultar um hóspede; ou");
	            System.out.println("Digite 5 para  Consultar todos os hóspedes");
	            System.out.println("Digite 6 para sair");
	            
	          

				opcao = lerInteiro("uma opção");

				switch (opcao) {
				case 1:
					inserir();
					break;
				case 2:
					editar();
					break;
				case 3:
					remover();
					break;
				case 4:
					consultar();
					break;
				case 5:
					listarTodos();
					break;
				case 6:
					System.out.println("\n Até mais!");
					//LogHotel.registrarMovimentacao(" Saiu do sistema.");
					break;
				default:
					System.out.println("\n Opção inválida! Digite um número entre 1 e 6.");
					break;
				}
			} while (opcao != 6);
		}

		
		private void inserir() {
			// TODO Auto-generated method stub
			
		}

		private void cadastrarHospede() {
			System.out.println("Cadastro de Hóspede");
			String nome = lerString("nome");
			String cpf = lerString("CPF");
			

			int tipoQuarto = lerInteiro("tipo doquarto (1-Simples, 2-Duplo, 3-Triplo)");

			Hospede hospede;
			switch (tipoQuarto) {
			case 1:
				hospede = new Solteiro(nome, cpf);
				break;
			case 2:
				hospede = new QuartoDuplo(nome, cpf);
				break;
			case 3:
				hospede = new QuartoTriplo(nome, cpf);
				break;
			default:
				System.out.println("Tipo de animal inválido.");
				//LogHotel.registrarMovimentacao(String.format("Tentativa de cadastrar um hóspede com tipo inválido: %d", tipoQuarto));
				return;
			}

			

			try {
				fachada.cadastrarHospede(hospede);
				System.out.println("Animal cadastrado com sucesso! ID: " + hospede.getCpf());
				//LogZoologico.registrarMovimentacao(String.format("Hóspede cadastrado com sucesso. CPF: %d, Nome: %s, cpf: %s", hospede.getCpf(), animal.getNome()));
			} catch (ExcecaoNegocio excecao) {
				System.out.println("Erro ao cadastrar animal: " + excecao.getMessage());}
				//LogZoologico.registrarMovimentacao("Erro ao cadastrar hóspede: " + excecao.getMessage());
			}
		

			private void editar() {
				System.out.println("Editar de hóspede");

				String cpf = lerString("CPF do hóspede");
				Hospede hospedeExistente; 
				
				

					
				
				try {
					hospedeExistente = fachada.consultar(cpf);
				} catch (Exception e) {
					System.out.println("Erro ao consultar hóspede: " + e.getMessage());
					return;
				}

				if (hospedeExistente == null) {
					System.out.println("Hóspede não encontrado com o CPF: " + cpf);
					return;
				}
				
				
				String novoNome = lerString("novo nome: ");
				String novoCpf = lerString("novo CPF: ");
			    Hospede hospedeAtualizado = new Hospede(hospedeExistente.getCpf(), novoNome);

				
				

				try {
					 fachada.editar(hospedeAtualizado);
				     System.out.println("Hóspede editado com sucesso!");
					
				} catch (ExcecaoNegocio e) {
					System.out.println("Erro ao editar hóspede com o cpf " + hospedeAtualizado.getCpf());
					}
				}
				
			private void remover() {
				System.out.println("Remover Hóspede");

				String cpf = lerString("CPF do hóspede");

				try {
					
						fachada.remover(cpf);
						System.out.println("Hóspede removido com sucesso!");
					
				} catch (Exception e) {
					if(cpf.isEmpty()) {
						
						System.out.println("Erro ao remover hóspede: " + e.getMessage());
				}}
			}
			private void consultar() {
				System.out.println("Consulta de hóspede");

				String cpf = lerString("CPF hóspede");

				try {
					Hospede hospede = fachada.consultar(cpf);
					if (hospede != null || cpf.equals(hospede)) {
						System.out.println("Hóspede encontrado:");
						System.out.println("CPF: " + hospede.getCpf());
						System.out.println("Nome: " + hospede.getNome());
					
					} else {
						System.out.println("Hóspede não encontrado.");
					}
				} catch (Exception e) {
					System.out.println("Erro ao consultar hóspede: " + e.getMessage());
				}
			}
			
			private void listarTodos() {
				System.out.println("Lista de Todos os hóspede");

				try {
					List<Hospede> hospede = fachada.listarTodos();
					if (!hospede.isEmpty()  || hospede.equals(hospede)) {
						System.out.println("Lista de hospede:");
						for (Hospede h : hospede) {
							System.out.println("---------------------------------------------");
							System.out.println("CPF: " + h.getCpf());
							System.out.println("Nome: " + h.getNome());
						}
						System.out.println("---------------------------------------------");
					} else {
						System.out.println("Não há hóspedes cadastrados.");
					}
				} catch (Exception e) {
					System.out.println("Erro ao consultar hóspede: " + e.getMessage());
			

			}
		}

private int lerInteiro(String mensagem) {
	int entrada = 0;
	boolean valido = false;

	while (!valido) {
		System.out.println("Digite o " + mensagem + ": ");
		String input = scanner.nextLine();

		try {
			entrada = Integer.parseInt(input);
			valido = true;
		} catch (NumberFormatException ex) {
			System.out.println("Digite apenas números inteiros!");
		}
	}
	return entrada;
}

private String lerString(String nomeAtributo) {
	String entrada = "";

	while (entrada.trim().isEmpty()) {
		System.out.println("Digite o " + nomeAtributo + ": ");
		entrada = scanner.nextLine();
	}
	return entrada;
}

}
	
	 