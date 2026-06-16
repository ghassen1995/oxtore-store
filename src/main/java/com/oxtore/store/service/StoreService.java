package com.oxtore.store.service;

import com.oxtore.store.entities.Store;

import java.util.List;
import java.util.Optional;

public interface StoreService {
    Store createStore(Store store);
    Optional<Store> getStoreById(Long id);
    List<Store> getAllStoresByOwnerId(Long ownerId);
    void deleteStoreById(Long id);
}
