package com.cryptowallet.marketms.controller;

import com.cryptowallet.marketms.domain.dto.CoinDataResponse;
import com.cryptowallet.marketms.service.CoinDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/market")
public class CoinDataController {
    private final CoinDataService coinDataService;

    public CoinDataController(CoinDataService coinDataService) {
        this.coinDataService = coinDataService;
    }

    @GetMapping()
    public ResponseEntity<List<CoinDataResponse>> getAllCoinData() {
        return new ResponseEntity<>(coinDataService.getAllCoinData(), HttpStatus.OK);
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<CoinDataResponse> getCoinData(@PathVariable String symbol) {
        return new ResponseEntity<>(coinDataService.getCoinData(symbol), HttpStatus.OK);
    }
}
