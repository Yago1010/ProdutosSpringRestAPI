package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Produto;

@Repository//conectar com o banco de dados
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
