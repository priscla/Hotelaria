package br.edu.ifpe.apoo.entidades;

public enum TipoQuarto {
    SIMPLES(1), DUPLO(2), TRIPLO(3);

    private final int valor;

    TipoQuarto(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static TipoQuarto fromValor(int valor) {
        for (TipoQuarto tipo : TipoQuarto.values()) {
            if (tipo.getValor() == valor) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de quarto inválido.");
    }
}
