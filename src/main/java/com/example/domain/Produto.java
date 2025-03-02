package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // se transforma em tabela do banco de dados
public class Produto {
// atributos da classe produto 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double valor;
	private String descricao;
	private Boolean vendido;

	// construtor sem parametro
	public Produto() {
	}

	// construtor com parametro
	public Produto(String nome, Double valor, String descricao, Boolean vendido) {
		this.nome = nome;
		this.valor = valor;
		this.descricao = descricao;
		this.vendido = vendido;
	}

	// os metodos gets(pega o atributo privado e mostra fora da classe) e
	// sets(altera)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getVendido() {
		return vendido;
	}

	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}

}
