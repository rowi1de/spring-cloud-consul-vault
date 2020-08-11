package com.scacap.cloudsecurity.config

import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent
import org.springframework.context.ApplicationListener
import reactor.core.publisher.Flux

class RefreshScopeRefreshedListener :
    ApplicationListener<RefreshScopeRefreshedEvent> {
    private val eventList: MutableList<RefreshScopeRefreshedEvent> = mutableListOf<RefreshScopeRefreshedEvent>()
    override fun onApplicationEvent(event: RefreshScopeRefreshedEvent) {
        println(event)
        eventList.add(event)
    }

    val events: Flux<String>
        get() = Flux.fromIterable(listOf("Events: ${eventList.size}") + eventList.map { it.name })
}
