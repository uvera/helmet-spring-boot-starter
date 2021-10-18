package io.uvera.helmet.webflux.filter

import io.uvera.helmet.core.handler.HelmetHandler
import io.uvera.helmet.core.handler.HelmetRemoveHeaderHandler
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

abstract class HelmetWebFilter<T : HelmetHandler>(val handler: T) : WebFilter {
    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> =
        handler.handle { name, value ->
            exchange.response.headers.set(name, value)
            chain.filter(exchange)
        }
}

abstract class HelmetRemoveHeaderWebFilter<T : HelmetRemoveHeaderHandler>(val handler: T) : WebFilter {
    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> =
        handler.handle { name ->
            exchange.response.headers.remove(name)
            chain.filter(exchange)
        }
}
