package com.precoteto.model;

public class AnaliseRequest {
  private double cotacao;
  private double lucroPorAcao;
  private double taxaCrescimento;
  private String estrategia; // "graham" ou "conservador"

  public double getCotacao() {
    return cotacao;
  }

  public void setCotacao(double cotacao) {
    this.cotacao = cotacao;
  }

  public double getLucroPorAcao() {
    return lucroPorAcao;
  }

  public void setLucroPorAcao(double lucroPorAcao) {
    this.lucroPorAcao = lucroPorAcao;
  }

  public double getTaxaCrescimento() {
    return taxaCrescimento;
  }

  public void setTaxaCrescimento(double taxaCrescimento) {
    this.taxaCrescimento = taxaCrescimento;
  }

  public String getEstrategia() {
    return estrategia;
  }

  public void setEstrategia(String estrategia) {
    this.estrategia = estrategia;
  }
}
