package com.trybe.listaprodutos.repository;

import com.trybe.listaprodutos.model.Produto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;

// TODO: Auto-generated Javadoc
/**
 * The Class EstoqueRepository.
 */
@ApplicationScoped
public class EstoqueRepository {

  /** The produtos. */
  public Map<Integer, Produto> produtos;

  /**
   * Instantiates a new estoque repository.
   */
  public EstoqueRepository() {
    produtos = new HashMap<Integer, Produto>();
    produtos.put(1, new Produto(1, "Leite"));
    produtos.put(2, new Produto(2, "Ovo"));
    produtos.put(3, new Produto(3, "Suco"));
    produtos.put(4, new Produto(4, "Pão"));
  }

  /**
   * Find all.
   *
   * @return the list
   */
  public List<Produto> findAll() {
    return produtos.values().stream().collect(Collectors.toList());
  }

  /**
   * Find by id.
   *
   * @param id the id
   * @return the produto
   */
  public Produto findById(Integer id) {
    return produtos.get(id);
  }
}
