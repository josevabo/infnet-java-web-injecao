package br.edu.infnet.appmontadora;

import java.io.BufferedReader;
import java.io.FileReader;

import br.edu.infnet.appmontadora.model.domain.Fabrica;
import br.edu.infnet.appmontadora.model.domain.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appmontadora.model.domain.Funcionario;
import br.edu.infnet.appmontadora.model.service.FuncionarioService;

@Order(2)
@Component
public class FuncionarioLoader implements ApplicationRunner {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader file = new FileReader("arquivos/funcionarios.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while(linha != null) {
			campos = linha.split(";"); 
			
			Funcionario funcionario = new Funcionario();
			funcionario.setEmail(campos[0]);
			funcionario.setNome(campos[1]);
			funcionario.setSenha(campos[2]);
			funcionario.setFabrica(new Fabrica(Integer.valueOf(campos[3])));
			funcionario.setCargo(new Cargo(Integer.valueOf(campos[4])));

			funcionarioService.incluir(funcionario);
			
			linha = leitura.readLine();
		}

		leitura.close();			
	}
}