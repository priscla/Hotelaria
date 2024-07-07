package br.edu.ifpe.apoo.entidades;

public class Hotel {
	private String nome;
    private String localizacao;
    private int quartosDisponiveis;
    private boolean servicoLavanderia;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public int getQuartosDisponiveis() {
		return quartosDisponiveis;
	}
	public void setQuartosDisponiveis(int quartosDisponiveis) {
		this.quartosDisponiveis = quartosDisponiveis;
	}
	public boolean isServicoLavanderia() {
		return servicoLavanderia;
	}
	public void setServicoLavanderia(boolean servicoLavanderia) {
		this.servicoLavanderia = servicoLavanderia;
	}

    
    
    

}
