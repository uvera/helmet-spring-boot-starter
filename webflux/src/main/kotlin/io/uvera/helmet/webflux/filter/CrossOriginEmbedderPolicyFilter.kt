package io.uvera.helmet.webflux.filter

import io.uvera.helmet.core.handler.CrossOriginEmbedderPolicyHandler
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@ConditionalOnProperty(prefix = "spring-helmet", name = ["enable-cross-origin-embedder-policy"])
@Order(1)
@Component
class CrossOriginEmbedderPolicyFilter(handler: CrossOriginEmbedderPolicyHandler) :
    HelmetWebFilter<CrossOriginEmbedderPolicyHandler>(handler)
