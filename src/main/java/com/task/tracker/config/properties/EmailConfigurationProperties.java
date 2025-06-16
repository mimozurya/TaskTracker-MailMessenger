package com.task.tracker.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.mail")
@Getter
@Setter
public class EmailConfigurationProperties {
    private String username;
}
