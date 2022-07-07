package com.trybe.listaprodutos;

import com.trybe.listaprodutos.model.Produto;
import com.trybe.listaprodutos.service.EstoqueService;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Classe EstoqueController.
 */

@ApplicationScoped
@Path("/")
public class EstoqueController {

  @Inject
  private EstoqueService service;

  /**
   * Métodos e atributos.
   *
   * @return
   */

  @GET
  @Path("/estoque")
  public List<Produto> listar() {
    return service.listar();
  }

  @GET
  @Path("/estoque/{id}")
  public Produto buscarPorId(@PathParam(value = "id") Integer id) {
    return service.buscarPorId(id);

  }

}
