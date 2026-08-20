package com.precoteto.strategy;

//package com.exemplo.precoteto.strategy;

import org.springframework.stereotype.Component;

@Component("conservador")
public class MultiploConservadorStrategy implements PrecoTetoStrategy {

  @Override
  public double calcularPrecoTeto(double lucroPorAcao, double taxaCrescimento) {
    return lucroPorAcao * (12 + taxaCrescimento * 0.5);
  }

  @Override
  public String avaliar(double cotacaoAtual, double precoTeto) {
    double margem = (precoTeto - cotacaoAtual) / precoTeto * 100;

    if (margem > 25)
      return "MUITO BARATO";
    if (margem > 0)
      return "BARATO";
    if (margem > -15)
      return "JUSTO / LEVE CARO";
    return "CARO";
  }
}
