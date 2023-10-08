package br.edu.infnet.appmontadora;

import br.edu.infnet.appmontadora.model.domain.Fabrica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appmontadora.model.service.FabricaService;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(3)
@Component
public class FabricaLoader implements ApplicationRunner {
	
	@Autowired
	private FabricaService fabricaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("arquivos/fabrica.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();

		String[] campos = null;

		while(linha != null) {
			campos = linha.split(";");

			Fabrica fabrica = new Fabrica(
					campos[0],
					campos[1]
			);
			fabricaService.incluir(fabrica);

			linha = leitura.readLine();
		}

		leitura.close();
	}
}