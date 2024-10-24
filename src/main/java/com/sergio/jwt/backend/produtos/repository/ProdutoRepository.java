package com.sergio.jwt.backend.produtos.repository;

import com.sergio.jwt.backend.produtos.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}
