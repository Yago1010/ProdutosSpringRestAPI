package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;

	public ProdutoController(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@GetMapping(value = "/produtos")
	public List<Produto> getProdutos() {
		return produtoRepository.findAll();
	}
	
}
