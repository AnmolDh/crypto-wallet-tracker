package com.cryptowallet.marketms.client;

import com.cryptowallet.marketms.domain.dto.CoinGeckoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "coingecko",
        url = "https://api.coingecko.com/api/v3"
)
public interface CoinGeckoClient {
    @GetMapping("/coins/{id}")
    CoinGeckoResponse getCoinData(
            @PathVariable("id") String coinId,
            @RequestParam(name = "localization", defaultValue = "false") boolean localization,
            @RequestParam(name = "tickers", defaultValue = "false") boolean tickers,
            @RequestParam(name = "market_data", defaultValue = "true") boolean marketData,
            @RequestParam(name = "community_data", defaultValue = "false") boolean communityData,
            @RequestParam(name = "developer_data", defaultValue = "false") boolean developerData,
            @RequestParam(name = "sparkline", defaultValue = "false") boolean sparkline
    );
}
