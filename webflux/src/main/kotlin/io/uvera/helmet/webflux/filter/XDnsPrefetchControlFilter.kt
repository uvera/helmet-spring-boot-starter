package io.uvera.helmet.webflux.filter

import io.uvera.helmet.core.handler.XDnsPrefetchControlHandler
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@ConditionalOnProperty(prefix = "spring-helmet", name = ["enable-x-dns-prefetch-control"])
@Order(1)
@Component
class XDnsPrefetchControlFilter(handler: XDnsPrefetchControlHandler) :
    HelmetWebFilter<XDnsPrefetchControlHandler>(handler)
