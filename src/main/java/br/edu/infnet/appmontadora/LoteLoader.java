package br.edu.infnet.appmontadora;

import br.edu.infnet.appmontadora.model.domain.Fabrica;
import br.edu.infnet.appmontadora.model.domain.Funcionario;
import br.edu.infnet.appmontadora.model.domain.Lote;
import br.edu.infnet.appmontadora.model.service.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;

@Order(5)
@Component
public class LoteLoader implements ApplicationRunner {

	@Autowired
	private LoteService loteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("arquivos/lotes.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();

		String[] campos = null;

		while(linha != null) {
			campos = linha.split(";");
			var fabrica = new Fabrica();
			fabrica.setId(Integer.valueOf(campos[0]));
			var responsavel = new Funcionario();
			responsavel.setId(Integer.valueOf(campos[1]));

			Lote lote = new Lote(
					fabrica,
					Collections.emptyList(),
					responsavel
			);
			loteService.incluir(lote);

			linha = leitura.readLine();
		}

		leitura.close();
	}
}