package br.edu.ifpe.apoo.util;

public class AdapterCpfImpl implements AdapterCpf{
	@Override
    public String formatarCpf(String cpf) {
        // Suponha que o CPF é fornecido no formato '12345678900'
        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido");
        }
        return cpf.substring(0, 3) + "." +
               cpf.substring(3, 6) + "." +
               cpf.substring(6, 9) + "-" +
               cpf.substring(9, 11);
    }

    @Override
    public String desformatarCpf(String cpfFormatado) {
        // Remove os caracteres de formatação do CPF
        if (cpfFormatado == null || cpfFormatado.length() != 14) {
            throw new IllegalArgumentException("CPF formatado inválido");
        }
        return cpfFormatado.replaceAll("[.-]", "");
    }


}
