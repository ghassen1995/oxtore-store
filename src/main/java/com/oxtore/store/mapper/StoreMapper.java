package com.oxtore.store.mapper;

import com.oxtore.store.DTO.CreateStoreRequest;
import com.oxtore.store.DTO.StoreResponse;
import com.oxtore.store.entities.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StoreMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ownerId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Store toEntity(CreateStoreRequest request);

    StoreResponse toResponse(Store store);
}