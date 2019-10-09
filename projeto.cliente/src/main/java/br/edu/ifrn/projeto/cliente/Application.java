package br.edu.ifrn.projeto.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.edu.ifrn.projeto.cliente.config",
		"br.edu.ifrn.projeto.cliente.controller", "br.edu.ifrn.projeto.cliente.service"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
