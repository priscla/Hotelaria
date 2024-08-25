package br.edu.ifpe.apoo.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogHotel {
	private static final String REGISTROS_HOSPEDES = "src/main/java/br/edu/ifpe/apoo/log/log.txt";

	public static void registrarHospedes(String descricao) {
		File arquivo = new File(REGISTROS_HOSPEDES);
		try {
			// Cria o diretório se ele não existir
			arquivo.getParentFile().mkdirs();
			// Cria o arquivo se ele não existir
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			// Escreve no arquivo
			try (FileWriter writer = new FileWriter(arquivo, true)) {
				writer.write(descricao + System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace(); // Imprime a stack trace para depuração
		}
	}
}