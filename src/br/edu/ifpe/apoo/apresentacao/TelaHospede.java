package br.edu.ifpe.apoo.apresentacao;
import java.util.Scanner;

import java.util.List;


import br.edu.ifpe.apoo.entidades.Hospede;
import br.edu.ifpe.apoo.excecoes.ExcecaoNegocio;
import br.edu.ifpe.apoo.negocio.FabricaControlador;
import br.edu.ifpe.apoo.negocio.IControladorHospede;

public class TelaHospede {
	 Scanner scanner = new Scanner (System.in);

	    public void exibir() throws ExcecaoNegocio {
	    	int opcao = 0;
	        
	       do{
	            System.out.println("Bem-vindo(a)!");
	            System.out.println("Digite 1 para cadastrar um hóspede;");
	            System.out.println("Digite 2 para editar os dados do hóspede;");
	            System.out.println("Digite 3 para remover o hóspede;");
	            System.out.println("Digite 4 para consultar um hóspede; ou");
	            System.out.println("Digite 5 para sair");
	            
	          
	            
	            

	            try {
	                opcao = Integer.parseInt(scanner.nextLine());
	            } catch (ClassCastException ex) {
					System.out.println("Digite um número válido!");
					
					
			
				}
	                
	                

				switch (opcao) {
				case 1:
					this.inserir();
					break;
				case 2:
					this.editar();
					break;
				case 3:
					this.remover();
					break;
				case 4:
					this.consultar();
					break;
				case 5:
					this.listarTodos();
					break;
				
				default:
					System.out.println("Opção inválida! Digite os números entre 1 e 6.");
					break;
				}
			} while (opcao != 5);
		} 
	                   
	   

		

			private void inserir(Controlador controlador,Hospede hospede)throws ExcecaoNegocio {
				System.out.println("Cadastro de hóspede");
				IControladorHospede controlador = FabricaControlador.getControladorHospede();
				String cpf = lerString("N°̣ do CPF: ");
				if (cpf.equals(cpf)) {
					System.out.println("CPF inválido! Verifique o número e tente novamente.");
					return;
				}
				
			
				String nome = lerString("Nome");
				


				Hospede.HospedeBuilder builder = new Hospede.HospedeBuilder()
						.cpf(cpf)
						.nome(nome);
					    			
						
				Hospede hospede = builder.criar();
				

				try {
					controlador.inserir(hospede);
					System.out.println("Hóspede cadastrado com sucesso! CPF: " + hospede.getCpf());
				} catch (ExcecaoNegocio excecao) {
					System.out.println("Erro ao cadastrar hóspede: " + excecao.getMessage());
				}
			}
			

			private void editar() {
				System.out.println("Editar de hóspede");
				IControladorHospede controlador = FabricaControlador.getControladorHospede();

				String cpf = lerString("CPF do hóspede");
				Hospede hospedeExistente; 
				
				

					
				
				try {
					hospedeExistente = controlador.consultarHospede(cpf);
				} catch (Exception e) {
					System.out.println("Erro ao consultar hóspede: " + e.getMessage());
					return;
				}

				if (hospedeExistente == null) {
					System.out.println("Hóspede não encontrado com o CPF: " + cpf);
					return;
				}
				
				
				String novoNome = lerString("novo nome: ");
			    Hospede hospedeAtualizado = new Hospede(hospedeExistente.getCpf(), novoNome);

				
				

				try {
					 controlador.editar(hospedeAtualizado);
				     System.out.println("Hóspede editado com sucesso!");
					
				} catch (ExcecaoNegocio e) {
					System.out.println("Erro ao editar hóspede com o cpf " + hospede.getCpf());
				}
				}
			private void remover() {
				System.out.println("Remover Hóspede");
				IControladorHospede controlador = FabricaControlador.getControladorHospede();

				String cpf = lerString("CPF do hóspede");

				try {
					
						controlador.remover(cpf);
						System.out.println("Hóspede removido com sucesso!");
					
				} catch (Exception e) {
					if(cpf.isEmpty()) {
						
						System.out.println("Erro ao remover hóspede: " + e.getMessage());
				}}
			}
			private void consultar() {
				System.out.println("Consulta de Paciente");
				IControladorHospede controlador = FabricaControlador.getControladorHospede();

				String cpf = lerString("CPF do paciente");

				try {
					Hospede hospede = controlador.consultarHospede(cpf);
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
				IControladorHospede controlador = FabricaControlador.getControladorHospede();

				try {
					List<Hospede> hospede = controlador.listarTodos();
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
	
	 