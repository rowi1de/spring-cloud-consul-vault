package com.scacap.cloudsecurity.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RefreshScopeConfig {
    @Bean
    fun remoteApplicationEventListener(): RefreshScopeRefreshedListener {
        return RefreshScopeRefreshedListener()
    }
}
