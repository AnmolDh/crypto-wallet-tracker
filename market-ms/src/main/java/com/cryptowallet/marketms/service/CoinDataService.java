package com.cryptowallet.marketms.service;

import com.cryptowallet.marketms.client.CoinGeckoClient;
import com.cryptowallet.marketms.domain.dto.CoinGeckoResponse;
import com.cryptowallet.marketms.domain.dto.CoinDataResponse;
import com.cryptowallet.marketms.domain.entity.CoinData;
import com.cryptowallet.marketms.domain.mapper.CoinDataMapper;
import com.cryptowallet.marketms.exception.CoinDataException;
import com.cryptowallet.marketms.repository.CoinDataRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinDataService {
    private final CoinDataRepository coinDataRepository;
    private final CoinGeckoClient coinGeckoClient;
    private final CoinDataMapper coinDataMapper;

    public CoinDataService(CoinDataRepository coinDataRepository,
                           CoinGeckoClient coinGeckoClient, CoinDataMapper coinDataMapper) {
        this.coinDataRepository = coinDataRepository;
        this.coinGeckoClient = coinGeckoClient;
        this.coinDataMapper = coinDataMapper;
    }


    public List<CoinDataResponse> getAllCoinData() {
        return coinDataRepository.findAll()
                .stream().map(coinDataMapper::map).toList();
    }

    public CoinDataResponse getCoinData(String symbol) {
        CoinData coinData = coinDataRepository.findById(symbol)
                .orElseThrow(() -> new CoinDataException(
                        "Symbol not found",
                        "/market/{symbol}"
                ));

        return coinDataMapper.map(coinData);
    }


    @Scheduled(fixedRate = 300000)
    protected void syncCoinData() {
        List<String> coins = List.of("bitcoin", "ethereum");

        for (String coin : coins) {
            CoinGeckoResponse response = coinGeckoClient.getCoinData(
                    coin,
                    false, false,
                    true, false,
                    false, false
            );
            coinDataRepository.save(coinDataMapper.map(response));
        }
    }
}
