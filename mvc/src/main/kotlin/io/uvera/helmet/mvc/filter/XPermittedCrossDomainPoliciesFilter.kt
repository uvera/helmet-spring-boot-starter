package io.uvera.helmet.mvc.filter

import io.uvera.helmet.core.handler.XPermittedCrossDomainPoliciesHandler
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@ConditionalOnProperty(prefix = "spring-helmet", name = ["enable-x-permitted-cross-domain-policies"])
@Order(1)
@Component
class XPermittedCrossDomainPoliciesFilter(handler: XPermittedCrossDomainPoliciesHandler) :
    HelmetFilter<XPermittedCrossDomainPoliciesHandler>(handler)
