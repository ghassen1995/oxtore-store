package com.oxtore.store.repository;

import com.oxtore.store.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findAllByOwnerId(Long OwnerId);
}
