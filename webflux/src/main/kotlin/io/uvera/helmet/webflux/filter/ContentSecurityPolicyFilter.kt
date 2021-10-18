package io.uvera.helmet.webflux.filter

import io.uvera.helmet.core.handler.ContentSecurityPolicyHandler
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@ConditionalOnProperty(prefix = "spring-helmet", name = ["enable-content-security-policy"])
@Order(1)
@Component
class ContentSecurityPolicyFilter(handler: ContentSecurityPolicyHandler) :
    HelmetWebFilter<ContentSecurityPolicyHandler>(handler)
