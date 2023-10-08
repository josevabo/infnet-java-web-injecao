package br.edu.infnet.appmontadora;

import br.edu.infnet.appmontadora.model.domain.Cargo;
import br.edu.infnet.appmontadora.model.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(1)
@Component
public class CargoLoader implements ApplicationRunner {

	@Autowired
	private CargoService cargoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader file = new FileReader("arquivos/cargos.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while(linha != null) {
			campos = linha.split(";"); 
			
			var cargo = new Cargo(
					campos[0],
					Boolean.valueOf(campos[1])
			);
			cargoService.incluir(cargo);
			
			linha = leitura.readLine();
		}

		leitura.close();			
	}
}