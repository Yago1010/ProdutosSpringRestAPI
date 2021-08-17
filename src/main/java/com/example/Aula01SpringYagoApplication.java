package com.example;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domain.Produto;
import com.example.repository.ProdutoRepository;

@SpringBootApplication
public class Aula01SpringYagoApplication implements CommandLineRunner {
    
	@Autowired
	ProdutoRepository produtoRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(Aula01SpringYagoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Produto p1 = new Produto("moto", 1200.00,"semi nova" , false);
		Produto p2 = new Produto("carro", 25000.00,"novo" , true);
		Produto p3 = new Produto("computador", 2500.00,"semi nova" , false);
		Produto p4 = new Produto("bicicleta", 500.00,"usada" , true);
		
		//produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
	}

}
