package com.precoteto.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.precoteto.strategy.PrecoTetoStrategy;

@Service
public class AvaliadorAcao {

  private PrecoTetoStrategy strategy;

  public AvaliadorAcao(@Qualifier("graham") PrecoTetoStrategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(PrecoTetoStrategy strategy) {
    this.strategy = strategy;
  }

  public String analisar(double cotacaoAtual, double lucroPorAcao, double taxaCrescimento) {
    double precoTeto = strategy.calcularPrecoTeto(lucroPorAcao, taxaCrescimento);
    String avaliacao = strategy.avaliar(cotacaoAtual, precoTeto);

    return String.format(
        "Preço-teto: R$ %.2f | Cotação: R$ %.2f | Resultado: %s",
        precoTeto, cotacaoAtual, avaliacao);
  }
}
