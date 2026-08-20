package com.precoteto.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import com.precoteto.model.AnaliseRequest;
import com.precoteto.model.AnaliseResponse;
import com.precoteto.service.AnaliseAcaoFacade;
import com.precoteto.strategy.PrecoTetoStrategy;

@RestController
@RequestMapping("/api/analise")
public class AnaliseController {

  private final AnaliseAcaoFacade facade;
  private final PrecoTetoStrategy grahamStrategy;
  private final PrecoTetoStrategy conservadorStrategy;

  public AnaliseController(
      AnaliseAcaoFacade facade,
      @Qualifier("graham") PrecoTetoStrategy grahamStrategy,
      @Qualifier("conservador") PrecoTetoStrategy conservadorStrategy) {
    this.facade = facade;
    this.grahamStrategy = grahamStrategy;
    this.conservadorStrategy = conservadorStrategy;
  }

  @PostMapping
  public AnaliseResponse analisar(@RequestBody AnaliseRequest request) {

    if ("conservador".equalsIgnoreCase(request.getEstrategia())) {
      facade.trocarEstrategia(conservadorStrategy);
    } else {
      facade.trocarEstrategia(grahamStrategy);
    }

    String resultado = facade.analisarAcao(
        request.getCotacao(),
        request.getLucroPorAcao(),
        request.getTaxaCrescimento());

    return new AnaliseResponse(resultado);
  }

}
