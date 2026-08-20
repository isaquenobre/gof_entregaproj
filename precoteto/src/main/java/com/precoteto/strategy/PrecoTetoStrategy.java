package com.precoteto.strategy;

public interface PrecoTetoStrategy {
  double calcularPrecoTeto(double lucroPorAcao, double taxaCrescimento);

  String avaliar(double cotacaoAtual, double precoTeto);
}
