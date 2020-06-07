package com.exemplo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.demo.model.Produto;
import com.exemplo.demo.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	@Autowired 
	private ProdutoService produtoService;
	
	@PostMapping
	public ResponseEntity<?> novo(@RequestBody Produto produto){
		
		return ResponseEntity.ok(produtoService.novo(produto));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id){
		Produto produto = produtoService.buscarPorId(id);
		
		if(produto!=null) 
			return ResponseEntity.ok(produto);
		else 
			return ResponseEntity.notFound().build();
		
	}
	
	@GetMapping
	public ResponseEntity<?> lista(){
		
		return ResponseEntity.ok(produtoService.lista());
		
	}

	@PutMapping
	public ResponseEntity<?> atualizar(@RequestBody Produto produto) throws Exception{
		
		return ResponseEntity.ok(produtoService.atualizar(produto));
		
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestBody Produto produto) throws Exception{
		produtoService.delete(produto);
		return ResponseEntity.noContent().build();
	}
	
	
	
}
