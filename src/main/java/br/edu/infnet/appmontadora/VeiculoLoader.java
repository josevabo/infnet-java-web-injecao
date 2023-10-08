package br.edu.infnet.appmontadora;

import java.io.BufferedReader;
import java.io.FileReader;

import br.edu.infnet.appmontadora.model.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appmontadora.model.service.VeiculoService;

@Order(4)
@Component
public class VeiculoLoader implements ApplicationRunner {
	
	@Autowired
	private VeiculoService veiculoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("arquivos/veiculos.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();

		String[] campos = null;

		while(linha != null) {
			campos = linha.split(";");

			switch (campos[0]) {
			case "O":
				Onibus onibus = new Onibus(
						campos[1],
						Float.valueOf(campos[2]),
						Integer.valueOf(campos[3]),
						Integer.valueOf(campos[4]),
						Boolean.valueOf(campos[5])
					);
				veiculoService.incluir(onibus);
				break;

			case "C":
				Carro carro = new Carro(
						campos[1],
						Float.valueOf(campos[2]),
						Integer.valueOf(campos[3]),
						Boolean.valueOf(campos[4]),
						Boolean.valueOf(campos[5]),
						campos[6],
						Boolean.valueOf(campos[5])
					);

				veiculoService.incluir(carro);
				break;

			case "M":
				Caminhao caminhao = new Caminhao(
						campos[1],
						Float.valueOf(campos[2]),
						Integer.valueOf(campos[3]),
						Float.valueOf(campos[3]),
						Integer.valueOf(campos[3])
					);

				veiculoService.incluir(caminhao);
				break;

			default:
				break;
			}

			linha = leitura.readLine();
		}

		leitura.close();
	}
}