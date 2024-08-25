package br.edu.ifpe.apoo.apresentacao;

import br.edu.ifpe.apoo.entidades.*;
import br.edu.ifpe.apoo.excecoes.ExcecaoNegocio;
import br.edu.ifpe.apoo.log.LogHotel;
import br.edu.ifpe.apoo.negocio.Fachada;
import br.edu.ifpe.apoo.util.AdapterCpf;
import br.edu.ifpe.apoo.util.ValidaCpf;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TelaHospede {

    private final Scanner scanner = new Scanner(System.in);
    private AdapterCpf validaCpf;
    private Fachada fachada;

    public TelaHospede() {
        this.validaCpf = new ValidaCpf();
        this.fachada = new Fachada();
    }

    public void exibir() throws IOException {
        int opcao = 0;
        do {
            System.out.println("Bem-vindo(a)!");
            System.out.println("Digite 1 para cadastrar um hóspede;");
            System.out.println("Digite 2 para editar os dados do hóspede;");
            System.out.println("Digite 3 para remover o hóspede;");
            System.out.println("Digite 4 para consultar um hóspede;");
            System.out.println("Digite 5 para consultar todos os hóspedes;");
            System.out.println("Digite 6 para sair");
            System.out.println("-------------------------------------------");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Digite um número válido!");
                continue;
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
                    this.consultarTodos();
                    break;
                case 6:
                    System.out.println("Volte sempre");
                    break;
                default:
                    System.out.println("Opção inválida! Digite um número entre 1 e 6.");
                    break;
            }
        } while (opcao != 6);
    }

    private void inserir() throws IOException {
        System.out.println("Cadastro de Hóspedes");

        while (true) {
            String cpf = lerString("CPF do hóspede ou exit para sair");
            if (cpf.equals("exit")){
                break;
            }
            if (!validaCpf.valida(cpf)) {
                System.out.println("CPF inválido! Verifique o número e tente novamente.");
                continue;
            }

            try {
                if (fachada.consultar(cpf) != null) {
                    System.out.println("CPF já cadastrado! Verifique o número e tente novamente.");
                    break;
                }
            } catch (ExcecaoNegocio excecao) {
            }
            
            HotelTipoQuarto hotelTipoQuarto = new Diaria();
             TipoQuarto tipoQuarto= null;
            while  (tipoQuarto==null){
            	int tipoQuartoEscolhido = lerInteiro("tipo de quarto (1-Simples, 2-Duplo, 3-Triplo)");
            	try {
            		tipoQuarto=TipoQuarto.fromValor(tipoQuartoEscolhido);
            
           
              switch  (tipoQuarto) {
                case SIMPLES:
                    hotelTipoQuarto = new Solteiro(hotelTipoQuarto);
                    break;
                case DUPLO:
                    hotelTipoQuarto = new QuartoDuplo(hotelTipoQuarto);
                    break;
                case TRIPLO:
                    hotelTipoQuarto = new QuartoTriplo(hotelTipoQuarto);
                    break;
                default:
                    System.out.println("Tipo de quarto inválido. Tente novamente.");
                    tipoQuarto=null;
                    break;
            }
            }catch (IllegalArgumentException e) {
                System.out.println("Entrada inválida. Por favor, escolha uma das opções (1-Simples, 2-Duplo, 3-Triplo).");
                tipoQuarto =null;
            }
            
            
            
            Hospede hospede = new Hospede.HospedeBuilder()
                    .cpf(cpf)
                    .nome(lerString("Nome"))
                    .endereco(lerString("Endereco"))
                    .quartosDisponiveis(hotelTipoQuarto)
                    .criar();

            cadastrarHospede(hospede);
            exibirFichaHospede(hospede);

            System.out.println("Deseja cadastrar outro hóspede? [s/n]");
            String resposta = scanner.nextLine().trim().toLowerCase();
            if (resposta.equals("n")) {
                break;
            }
         }
       }    
    }

    private void cadastrarHospede(Hospede hospede) {
        try {
            fachada.cadastrarHospede(hospede);
            System.out.println("Hóspede cadastrado com sucesso!");
            LogHotel.registrarHospedes("Hóspede cadastrado com sucesso!");
        } catch (ExcecaoNegocio negocio) {
            System.out.println("Erro ao cadastrar hóspede: " + negocio.getMessage());
        }
    }

    private void exibirFichaHospede(Hospede hospede) {
        System.out.println("\n--- Ficha do Hóspede ---");
        System.out.println("Nome: " + hospede.getNome());
        System.out.println("CPF: " + hospede.getCpf());
        if (hospede.getNuQuartosDisponiveis() != null) {
            System.out.println("Valor da Diária: R$" + hospede.getNuQuartosDisponiveis().getPagamento());
        } else {
            System.out.println("Nenhum quarto foi escolhido.");
        }

        System.out.println("--------------------------");
    }

    private void editar() {
        System.out.println("Editar Hóspede");

        String cpf = lerString("CPF do hóspede");

        try {
            Hospede hospedeExistente = fachada.consultar(cpf);

            if (hospedeExistente == null) {
                System.out.println("Hóspede não encontrado com o CPF: " + cpf);
                return;
            }

            String novoNome = lerString("novo nome");
            String novoCpf = lerString("novo CPF");

            // Atualiza os dados do hóspede existente
            hospedeExistente.setNome(novoNome);
            hospedeExistente.setCpf(novoCpf);

            fachada.editar(hospedeExistente);
            System.out.println("Hóspede editado com sucesso!");

        } catch (ExcecaoNegocio e) {
            System.out.println("Erro ao editar hóspede: " + e.getMessage());
        }
    }


    private void remover() {
        System.out.println("Remover Hóspede");

        String cpf = lerString("CPF do hóspede");

        try {
            fachada.remover(cpf);
            System.out.println("Hóspede removido com sucesso!");

        } catch (ExcecaoNegocio e) {
            System.out.println("Erro ao remover hóspede: " + e.getMessage());
        }
    }

    private void consultar() {
        System.out.println("Consulta de Hóspede");

        String cpf = lerString("CPF do hóspede");

        try {
            Hospede hospede = fachada.consultar(cpf);

            if (hospede != null) {
                System.out.println("Hóspede encontrado:");
                System.out.println("Nome: " + hospede.getNome());
                System.out.println("CPF: " + hospede.getCpf());
            } else {
                System.out.println("Hóspede não encontrado.");
            }

        } catch (ExcecaoNegocio e) {
            System.out.println("Erro ao consultar hóspede: " + e.getMessage());
        }
    }

    private void consultarTodos() {
        System.out.println("Lista de Todos os Hóspedes");

        try {
            List<Hospede> hospedes = fachada.listarTodos();

            if (!hospedes.isEmpty()) {
                System.out.println("Lista de hóspedes:");
                for (Hospede h : hospedes) {
                    System.out.println("---------------------------------------------");
                    System.out.println("Nome: " + h.getNome());
                    System.out.println("CPF: " + h.getCpf());
                }
                System.out.println("---------------------------------------------");
            } else {
                System.out.println("Não há hóspedes cadastrados.");
            }

        } catch (ExcecaoNegocio e) {
            System.out.println("Erro ao consultar hóspedes: " + e.getMessage());
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
