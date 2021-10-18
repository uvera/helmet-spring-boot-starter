package io.uvera.helmet.webflux.filter

import io.uvera.helmet.core.handler.StrictTransportSecurityHandler
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@ConditionalOnProperty(prefix = "spring-helmet", name = ["enable-strict-transport-security"])
@Order(1)
@Component
class StrictTransportSecurityFilter(handler: StrictTransportSecurityHandler) :
    HelmetWebFilter<StrictTransportSecurityHandler>(handler)
