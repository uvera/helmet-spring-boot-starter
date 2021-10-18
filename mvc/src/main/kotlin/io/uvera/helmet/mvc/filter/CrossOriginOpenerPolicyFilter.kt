package io.uvera.helmet.mvc.filter

import io.uvera.helmet.core.handler.CrossOriginOpenerPolicyHandler
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@ConditionalOnProperty(prefix = "spring-helmet", name = ["enable-cross-origin-opener-policy"])
@Order(1)
@Component
class CrossOriginOpenerPolicyFilter(handler: CrossOriginOpenerPolicyHandler) :
    HelmetFilter<CrossOriginOpenerPolicyHandler>(handler)
