package org.frh.customerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

//record automatically provides:Constructor, Getters, equals(), hashCode(), toString()
@ConfigurationProperties(prefix = "global.params")
public record GlobalConfig(int p1, int p2) {

}
