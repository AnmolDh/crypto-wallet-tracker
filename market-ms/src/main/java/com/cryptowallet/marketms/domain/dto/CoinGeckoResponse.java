package com.cryptowallet.marketms.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoinGeckoResponse {
    private String id;
    private MarketData market_data;

    public double getPrice() {
        return market_data != null && market_data.getCurrent_price() != null
                ? market_data.getCurrent_price().getUsd()
                : 0.0;
    }

    public double getDaily_change() {
        return market_data != null ? market_data.getPrice_change_percentage_24h() : 0.0;
    }

    public double getWeekly_change() {
        return market_data != null ? market_data.getPrice_change_percentage_7d() : 0.0;
    }

    @Data
    public static class MarketData {
        private Price current_price;
        private double price_change_percentage_24h;
        private double price_change_percentage_7d;
    }

    @Data
    public static class Price {
        private double usd;
    }
}
