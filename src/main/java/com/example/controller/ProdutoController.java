package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Produto;
import com.example.repository.ProdutoRepository;

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
	
	@PostMapping("/produtos")
	public Produto addProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	
	
	}
    
	@GetMapping(value = "/produto/{id}")
	public Optional<Produto> getProduto(@PathVariable Long id){
		return produtoRepository.findById(id);
	}
	@DeleteMapping("/produto/{id}")
	public void deleteProduto(@PathVariable Long id) {
		produtoRepository.deleteById(id);
	}
}




