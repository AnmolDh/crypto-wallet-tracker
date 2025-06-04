package com.cryptowallet.marketms.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoinData {
    @Id
    private String coin_symbol;

    private double price;

    private double daily_change;

    private double weekly_change;
}
