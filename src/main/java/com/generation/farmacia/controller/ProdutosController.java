package com.generation.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.farmacia.model.ProdutosModel;
import com.generation.farmacia.repository.ProdutosRepository;


@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutosController {

		@Autowired
		private ProdutosRepository repository;
		
		@GetMapping
		public ResponseEntity<List<ProdutosModel>> GetAll() {
			return ResponseEntity.ok(repository.findAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<ProdutosModel> GetById(@PathVariable Long id) {
			return repository.findById(id)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping("/nome/{nome}")
		public ResponseEntity<List<ProdutosModel>> GetByNome(@PathVariable String nome) {
			return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
		}
		
		@PostMapping
		public ResponseEntity<ProdutosModel> post (@RequestBody ProdutosModel produto) {
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
		}
		
		@PutMapping
		public ResponseEntity<ProdutosModel> put (@RequestBody ProdutosModel produto) {
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
		}
		
		@DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {
			repository.deleteById(id);
		}
}
