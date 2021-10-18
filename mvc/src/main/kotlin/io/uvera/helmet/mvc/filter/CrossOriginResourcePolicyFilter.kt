package io.uvera.helmet.mvc.filter

import io.uvera.helmet.core.handler.CrossOriginResourcePolicyHandler
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@ConditionalOnProperty(prefix = "spring-helmet.reactive", name = ["enable-cross-origin-resource-policy"])
@Order(1)
@Component
class CrossOriginResourcePolicyFilter(handler: CrossOriginResourcePolicyHandler) :
    HelmetFilter<CrossOriginResourcePolicyHandler>(handler)
