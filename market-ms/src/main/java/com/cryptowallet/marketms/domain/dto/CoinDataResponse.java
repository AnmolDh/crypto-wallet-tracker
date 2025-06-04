package com.cryptowallet.marketms.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoinDataResponse{
    private String id;
    private double price;
    private double daily_change;
    private double weekly_change;
}
