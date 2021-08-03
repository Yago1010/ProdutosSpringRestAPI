package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domain.Produto;
import com.example.repositories.ProdutoRepository;

@SpringBootApplication
public class Aula01SpringYagoApplication implements CommandLineRunner {
    
	@Autowired
	ProdutoRepository produtoRepository;  
	
	public static void main(String[] args) {
		SpringApplication.run(Aula01SpringYagoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Produto p1 = new Produto("moto", 1.2,"semi nova" , false); 
		produtoRepository.save(p1);
		
	}

}
