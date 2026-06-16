package com.oxtore.store.service;

import com.oxtore.store.entities.Store;
import com.oxtore.store.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Optional<Store> getStoreById(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> getAllStoresByOwnerId(Long ownerId) {
        return storeRepository.findAllByOwnerId(ownerId);
    }

    @Override
    public void deleteStoreById(Long id) {
        storeRepository.deleteById(id);
    }
}
