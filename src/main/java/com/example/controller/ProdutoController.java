package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Produto;
import com.example.repository.ProdutoRepository;

@RestController
public class ProdutoController {

	@Autowired//objeto para manipular a interface , para manipular os dados
	ProdutoRepository produtoRepository;

	public ProdutoController(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	//metodos do tipo mapping , get retonar, post addicionar, delete apagar, put para alterar
	@GetMapping(value = "/produtos")
	public List<Produto> getProdutos() {
		return produtoRepository.findAll();
	}

	@PostMapping("/produtos")
	public Produto addProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);

	}

	@GetMapping(value = "/produto/{id}")
	public Optional<Produto> getProduto(@PathVariable Long id) {
		return produtoRepository.findById(id);
	}

	@DeleteMapping("/produto/{id}")
	public void deleteProduto(@PathVariable Long id) {
		produtoRepository.deleteById(id);
	}

	@GetMapping(value = "/produtos/nome/{nome}")
	public List<Produto> getProdutos(@PathVariable String nome) {
		List<Produto> produtos = getProdutos();
		List<Produto> encontrados = new ArrayList<>();
		for (Produto produto : produtos) {
			if (produto.getNome().contains(nome)) {
				encontrados.add(produto);

			}
		}

		return encontrados;
	}
	//replace substituir
	@PutMapping("/produto/{id}")
	public Produto replaceProduto(@RequestBody Produto produto, @PathVariable Long id) {
		return produtoRepository.findById(id).map(p -> {
			p.setNome(produto.getNome());
			p.setDescricao(produto.getDescricao());
			p.setVendido(produto.getVendido());
			p.setValor(produto.getValor());
			return produtoRepository.save(p);

		}).orElseGet(() -> {
			produto.setId(id);
			return produtoRepository.save(produto);

		});
	}
}
