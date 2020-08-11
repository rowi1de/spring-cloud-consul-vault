package com.scacap.cloudsecurity

import com.scacap.cloudsecurity.config.RefreshScopeRefreshedListener
import org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration
import java.time.LocalDateTime

@RestController
internal class CloudController(
    private val cloudProperties: CloudProperties,
    private val cloudSecret: CloudSecret,
    private val remoteApplicationEventListener: RefreshScopeRefreshedListener,
    private val discovery: CloudDiscovery
) {
    @GetMapping("hello", produces = [TEXT_EVENT_STREAM_VALUE])
    fun helloCloud(): Flux<String> =
        Flux.interval(Duration.ofSeconds(5)).map { "${cloudProperties.hello} : ${LocalDateTime.now()}" }

    @GetMapping("events", produces = [TEXT_EVENT_STREAM_VALUE])
    fun events(): Flux<String> = remoteApplicationEventListener.events

    @GetMapping("services", produces = [TEXT_EVENT_STREAM_VALUE])
    fun services(): Flux<String> = discovery.services

    @GetMapping("secret")
    fun secret() = cloudSecret.shared
}
