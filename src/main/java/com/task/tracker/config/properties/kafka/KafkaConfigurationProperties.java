package com.task.tracker.config.properties.kafka;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "spring.kafka")
@Getter
@Setter
public class KafkaConfigurationProperties {
    private String bootstrapServers;

    @NestedConfigurationProperty
    private final ConsumerConfigurationProperties consumer = new ConsumerConfigurationProperties();
}
