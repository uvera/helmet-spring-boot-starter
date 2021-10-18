package io.uvera.helmet.webflux.filter

import io.uvera.helmet.core.handler.ReferrerPolicyHandler
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@ConditionalOnProperty(prefix = "spring-helmet", name = ["enable-referrer-policy"])
@Order(1)
@Component
class ReferrerPolicyFilter(handler: ReferrerPolicyHandler): HelmetWebFilter<ReferrerPolicyHandler>(handler) {
}
