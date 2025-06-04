package com.cryptowallet.marketms.domain.mapper;

import com.cryptowallet.marketms.domain.dto.CoinGeckoResponse;
import com.cryptowallet.marketms.domain.dto.CoinDataResponse;
import com.cryptowallet.marketms.domain.entity.CoinData;
import org.springframework.stereotype.Component;

@Component
public class CoinDataMapper {
    public CoinData map(CoinDataResponse coinDataResponse) {
        return CoinData.builder()
                .coin_symbol(coinDataResponse.getId())
                .price(coinDataResponse.getPrice())
                .daily_change(coinDataResponse.getDaily_change())
                .weekly_change(coinDataResponse.getWeekly_change())
                .build();
    }

    public CoinDataResponse map(CoinData coinData) {
        return CoinDataResponse.builder()
                .id(coinData.getCoin_symbol())
                .price(coinData.getPrice())
                .daily_change(coinData.getDaily_change())
                .weekly_change(coinData.getWeekly_change())
                .build();
    }

    public CoinData map(CoinGeckoResponse coinGeckoResponse) {
        return CoinData.builder()
                .coin_symbol(coinGeckoResponse.getId())
                .price(coinGeckoResponse.getPrice())
                .daily_change(coinGeckoResponse.getDaily_change())
                .weekly_change(coinGeckoResponse.getWeekly_change())
                .build();
    }
}
