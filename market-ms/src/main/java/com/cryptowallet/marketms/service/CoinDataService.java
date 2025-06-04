package com.cryptowallet.marketms.service;

import com.cryptowallet.marketms.client.CoinGeckoClient;
import com.cryptowallet.marketms.domain.dto.CoinGeckoResponse;
import com.cryptowallet.marketms.domain.dto.CoinDataResponse;
import com.cryptowallet.marketms.domain.entity.CoinData;
import com.cryptowallet.marketms.domain.mapper.CoinDataMapper;
import com.cryptowallet.marketms.repository.CoinDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoinDataService {
    private final CoinDataRepository coinDataRepository;
    private final CoinGeckoClient coinGeckoClient;
    private final CoinDataMapper coinDataMapper;


    public List<CoinDataResponse> getAllCoinData() {
        return coinDataRepository.findAll()
                .stream().map(coinDataMapper::map).toList();
    }

    public CoinDataResponse getCoinData(String symbol) {
        CoinData coinData = coinDataRepository.findById(symbol)
                .orElseThrow(() -> new RuntimeException("not found"));

        return coinDataMapper.map(coinData);
    }


    @Scheduled(fixedRate = 300000)
    private void syncCoinData() {
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
