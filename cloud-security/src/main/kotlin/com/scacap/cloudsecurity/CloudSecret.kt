package com.scacap.cloudsecurity

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.cloud.context.config.annotation.RefreshScope

@RefreshScope
@ConfigurationProperties("vault")
class CloudSecret {

    lateinit var shared: String

    lateinit var own: String
}
