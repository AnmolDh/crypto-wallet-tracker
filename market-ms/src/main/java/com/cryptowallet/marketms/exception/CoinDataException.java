package com.cryptowallet.marketms.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CoinDataException extends RuntimeException {
    private final String endpoint;
    private final LocalDateTime timestamp;

    public CoinDataException(String message, String endpoint) {
      super(message);
      this.endpoint = endpoint;
      this.timestamp = LocalDateTime.now();
    }
}
