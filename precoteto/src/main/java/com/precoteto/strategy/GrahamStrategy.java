package com.precoteto.strategy;

import org.springframework.stereotype.Component;

@Component("graham")
public class GrahamStrategy implements PrecoTetoStrategy {

  @Override
  public double calcularPrecoTeto(double lucroPorAcao, double taxaCrescimento) {
    // Fórmula simplificada de Benjamin Graham: V = LPA * (8.5 + 2g)
    return lucroPorAcao * (8.5 + 2 * taxaCrescimento);
  }

  @Override
  public String avaliar(double cotacaoAtual, double precoTeto) {
    if (cotacaoAtual < precoTeto * 0.80) {
      return "BARATO (boa margem de segurança)";
    } else if (cotacaoAtual <= precoTeto) {
      return "JUSTO";
    } else {
      return "CARO";
    }
  }
}
