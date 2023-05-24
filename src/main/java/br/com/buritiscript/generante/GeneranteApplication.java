package br.com.buritiscript.generante;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import br.com.buritiscript.generante.storage.properties.StorageProperties;
import br.com.buritiscript.generante.storage.service.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class GeneranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeneranteApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService){
		return (args) -> {

		};
	}
}
