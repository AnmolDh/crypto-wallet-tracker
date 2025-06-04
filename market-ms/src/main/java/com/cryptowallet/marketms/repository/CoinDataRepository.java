package com.cryptowallet.marketms.repository;

import com.cryptowallet.marketms.domain.entity.CoinData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinDataRepository extends JpaRepository<CoinData, String> {
}
