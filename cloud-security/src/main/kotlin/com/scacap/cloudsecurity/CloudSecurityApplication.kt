package com.scacap.cloudsecurity

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(CloudProperties::class)
class CloudSecurityApplication

fun main(args: Array<String>) {
	runApplication<CloudSecurityApplication>(*args)
}
