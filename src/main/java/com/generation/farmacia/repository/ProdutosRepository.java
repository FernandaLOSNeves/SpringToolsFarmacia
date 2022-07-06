package com.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.model.ProdutosModel;

@Repository
public interface ProdutosRepository extends JpaRepository <ProdutosModel, Long> {
	
	public List<ProdutosModel> findAllByNomeContainingIgnoreCase(String produto);
	
}
