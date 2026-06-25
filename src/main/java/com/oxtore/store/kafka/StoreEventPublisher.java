package com.oxtore.store.kafka;

import com.oxtore.store.config.KafkaProducerConfig;
import com.oxtore.store.entities.Store;
import com.oxtore.store.event.StoreCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class StoreEventPublisher {

    private final KafkaTemplate<String, StoreCreatedEvent> kafkaTemplate;

    public void publishStoreCreated(Store store) {
        StoreCreatedEvent event = new StoreCreatedEvent(
                store.getId(),
                store.getOwnerId(),
                LocalDateTime.now()
        );
        kafkaTemplate.send(KafkaProducerConfig.STORE_CREATED_TOPIC,
                        String.valueOf(store.getId()), event)
                .whenComplete((result, ex) -> {
                    if (ex != null) {
                        log.error("Failed to publish StoreCreatedEvent for storeId={}", store.getId(), ex);
                    } else {
                        log.info("Published StoreCreatedEvent for storeId={}", store.getId());
                    }
                });
    }
}