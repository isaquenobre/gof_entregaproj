package com.precoteto.service;

import org.springframework.stereotype.Service;

import com.precoteto.strategy.PrecoTetoStrategy;

@Service
public class AnaliseAcaoFacade {

  private final AvaliadorAcao avaliador;

  public AnaliseAcaoFacade(AvaliadorAcao avaliador) {
    this.avaliador = avaliador;
  }

  public String analisarAcao(double cotacao, double lpa, double crescimento) {
    return avaliador.analisar(cotacao, lpa, crescimento);
  }

  public void trocarEstrategia(PrecoTetoStrategy novaEstrategia) {
    avaliador.setStrategy(novaEstrategia);
  }
}
