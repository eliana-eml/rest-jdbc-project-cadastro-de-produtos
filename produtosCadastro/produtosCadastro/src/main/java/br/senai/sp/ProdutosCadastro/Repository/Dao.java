package br.senai.sp.ProdutosCadastro.Repository;

import java.util.List;

import br.senai.sp.ProdutosCadastro.Model.Produto;

public interface Dao {
	
	Produto inserir(Produto produto);
	List<Produto> buscarTodos();
	Produto buscarPorId(int id);
	String excluir(int id);
	String alterar(Produto produto, int id);
}
