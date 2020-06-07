package com.exemplo.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.demo.model.Produto;
import com.exemplo.demo.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto novo(Produto produto) {
		produto = produtoRepository.save(produto);
		return produto;
	}
	
	public List<Produto> lista(){
		return produtoRepository.findAll();
	}

	public Produto buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return produtoRepository.findById(id).orElse(null);
	}
	public Produto atualizar(Produto produto) throws Exception {
		Produto produtoOriginal = produtoRepository.findById(produto.getId())
				.orElseThrow(() -> new Exception("Produto não existe"));
		
		produtoOriginal.setNome(produto.getNome());
		produtoOriginal.setValor(produto.getValor());
		produtoOriginal = produtoRepository.save(produtoOriginal);
		return produtoOriginal;
	}
	public void delete(Produto produto) throws Exception {
		Produto produtoOriginal = produtoRepository.findById(produto.getId())
				.orElseThrow(() -> new Exception("Produto não existe"));
	
		
		produtoRepository.delete(produtoOriginal);

	}
	
	
}
