package br.senai.sp.ProdutosCadastro.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.senai.sp.ProdutosCadastro.Model.Produto;

@Repository
public class ProdutoRepositorio {
	
	private static final String INSERIR_PRODUTO = "INSERT INTO produtos(nome, descricao, preco) VALUES (?,?,?)";
    private static final String ALTERAR_PRODUTO = "UPDATE produtos SET nome = ?, descricao = ?, preco = ? WHERE id = ?";
	private static final String BUSCAR_PRODUTOS = "SELECT id, nome, descricao, preco FROM produtos";
    private static final String BUSCAR_PRODUTO_ID = "SELECT id, nome, descricao, preco FROM produtos WHERE id = ?";
    private static final String DELETAR_PRODUTO = "DELETE FROM produtos WHERE id=?";
    
    @Autowired
     private JdbcTemplate jdbcTemplate;

    public Produto inserir(Produto produto) {

        jdbcTemplate.update(INSERIR_PRODUTO, produto.getNome(), produto.getDescricao(), produto.getPreco());

        return produto;
    }
    
    public int alterar(Produto produto, int id) {
    	Object[] params = {produto.getNome(), produto.getDescricao(), produto.getPreco()};
    	
    	int result =  jdbcTemplate.update(ALTERAR_PRODUTO, params, id);
    	
        return result;
    }
    
    public Produto buscarPorId(int id) {
        return jdbcTemplate.queryForObject(BUSCAR_PRODUTO_ID,
                new Object[]{id},
                (rs,rowNum) ->
                        new Produto(rs.getInt("id"),
                        		    rs.getString("nome"),
                        		    rs.getString("descricao"),
                        		    rs.getDouble("preco")));
    }
    
    
    public int excluir(int id) {
    	Object[] params = {id};
    	
    	int result = jdbcTemplate.update(DELETAR_PRODUTO, params);
        
        return result;
    }

    public List<Produto> buscarTodos() {

        return jdbcTemplate.query(BUSCAR_PRODUTOS, (rs,rowNum) ->
                new Produto(rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("descricao"),
                            rs.getDouble("preco")));
    }
	
}
