package br.senai.sp.ProdutosCadastro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sp.ProdutosCadastro.Model.Produto;
import br.senai.sp.ProdutosCadastro.Repository.ProdutoRepositorio;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	ProdutoRepositorio produtoRepositorio;
	
	@PostMapping
	public Produto inserir(@RequestBody Produto produto) {
		
		return produtoRepositorio.inserir(produto);
	}
	
	@PutMapping("/{id}")
	public Produto alterar(@RequestBody Produto produto, @PathVariable int id) {
		
		produtoRepositorio.alterar(produto, id);
		
		return produto;
	}
	
	@GetMapping("/{id}")
	public Produto buscarPorId(@PathVariable("id") int id) {
		
		return produtoRepositorio.buscarPorId(id);
	}
	
	@GetMapping
	public List<Produto> buscarTodos() {
		return produtoRepositorio.buscarTodos();
	}
	
	@DeleteMapping("/{id}")
	public int excluir(@PathVariable int id) {
		produtoRepositorio.excluir(id);
		
		return id;
	}
	
}
