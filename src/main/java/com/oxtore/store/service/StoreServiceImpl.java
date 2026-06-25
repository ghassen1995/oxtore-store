package com.oxtore.store.service;

import com.oxtore.store.entities.Store;
import com.oxtore.store.kafka.StoreEventPublisher;
import com.oxtore.store.repository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final StoreEventPublisher storeEventPublisher;

    public StoreServiceImpl(StoreRepository storeRepository, StoreEventPublisher storeEventPublisher) {
        this.storeRepository = storeRepository;
        this.storeEventPublisher = storeEventPublisher;
    }

    @Transactional
    @Override
    public Store createStore(Store store) {
        Store saved = storeRepository.save(store);
        storeEventPublisher.publishStoreCreated(saved);
        return saved;
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
