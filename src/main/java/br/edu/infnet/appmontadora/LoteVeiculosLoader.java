package br.edu.infnet.appmontadora;

import br.edu.infnet.appmontadora.model.domain.*;
import br.edu.infnet.appmontadora.model.service.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(6)
@Component
public class LoteVeiculosLoader implements ApplicationRunner {

	@Autowired
	private LoteService loteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("arquivos/loteveiculos.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();

		String[] campos = null;

		while(linha != null) {
			campos = linha.split(";");

			Lote lote = new Lote();
			lote.setId(Integer.valueOf(campos[0]));
			Veiculo veiculo = new Carro();
			veiculo.setId(Integer.valueOf(campos[1]));
			lote.incluiVeiculo(veiculo);
			loteService.incluir(lote);

			linha = leitura.readLine();
		}

		leitura.close();
	}
}