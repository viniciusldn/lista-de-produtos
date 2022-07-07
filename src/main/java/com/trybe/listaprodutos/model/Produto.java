package com.trybe.listaprodutos.model;

/**
 * Classe Produto.
 */
public class Produto {

  /**
   * Métodos e atributos.
   */
  private int id;

  private String nome;

  /**
   * Construtores.
   */
  public Produto() {
  }

  public Produto(int id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

}
