package com.platzi.springboot.supermercado.domain.repository;

import com.platzi.springboot.supermercado.domain.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);

}
