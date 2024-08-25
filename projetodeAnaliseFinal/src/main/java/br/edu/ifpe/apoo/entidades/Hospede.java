package br.edu.ifpe.apoo.entidades;

public class Hospede extends EntidadeBase {
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private String verificacaoReserva;
	private HotelTipoQuarto quartosDisponiveis;

	public Hospede(String nome, String cpf, HotelTipoQuarto quartosDisponiveis, String endereco, String telefone,
				   String verificacaoReservas) {

		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.verificacaoReserva = verificacaoReservas;
		this.quartosDisponiveis = quartosDisponiveis;
	}

	public Hospede(String nome,String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	public Hospede() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getVerificacaoReserva() {
		return verificacaoReserva;
	}

	public void setVerificacaoReserva(String verificacaoReserva) {
		this.verificacaoReserva = verificacaoReserva;
	}

	public HotelTipoQuarto getNuQuartosDisponiveis() {
		return quartosDisponiveis;
	}

	public void setNuQuartosDisponiveis(HotelTipoQuarto quartosDisponiveis) {
		this.quartosDisponiveis = quartosDisponiveis;
	}

	public static class HospedeBuilder {
		private String id;
		private String nome;
		private String cpf;
		private String endereco;
		private String telefone;
		private HotelTipoQuarto quartosDisponiveis;
		private String verificacaoReservas;

		public HospedeBuilder id(String id) {
			this.id = id;
			return this;
		}

		public HospedeBuilder nome(String nome) {
			this.nome = nome;
			return this;
		}

		public HospedeBuilder cpf(String cpf) {
			this.cpf = cpf;
			return this;
		}

		public HospedeBuilder endereco(String endereco) {
			this.endereco = endereco;
			return this;
		}

		public HospedeBuilder telefone(String telefone) {
			this.telefone = telefone;
			return this;
		}

		public HospedeBuilder verificacao(String verificacaoReserva) {
			this.verificacaoReservas = verificacaoReserva;
			return this;
		}

		public HospedeBuilder quartosDisponiveis(HotelTipoQuarto quartosDisponiveis) {
			this.quartosDisponiveis = quartosDisponiveis;
			return this;
		}

		public Hospede criar() {
			return new Hospede(this.nome, this.cpf, this.quartosDisponiveis, this.endereco, this.telefone,
					this.verificacaoReservas);
		}
	}
}
