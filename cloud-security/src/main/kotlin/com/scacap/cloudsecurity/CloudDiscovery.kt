package com.scacap.cloudsecurity

import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux


@Service
@RefreshScope
internal class CloudDiscovery(private val discoveryClient: DiscoveryClient) {

    val services: Flux<String>
        get() = Flux.fromIterable(discoveryClient.services)
            .map { "$it at ${discoveryClient.getInstances(it).map { it.uri }}" }
}