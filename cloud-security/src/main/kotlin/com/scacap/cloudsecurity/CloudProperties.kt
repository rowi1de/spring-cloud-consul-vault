package com.scacap.cloudsecurity

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.cloud.context.config.annotation.RefreshScope

@RefreshScope
@ConfigurationProperties("cloud")
class CloudProperties {
    lateinit var hello: String
}
