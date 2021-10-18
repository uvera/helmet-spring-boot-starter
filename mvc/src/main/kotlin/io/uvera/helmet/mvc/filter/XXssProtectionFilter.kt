package io.uvera.helmet.mvc.filter

import io.uvera.helmet.core.handler.XXssProtectionHandler
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@ConditionalOnProperty(prefix = "spring-helmet", name = ["disable-x-xss-protection"])
@Order(1)
@Component
class XXssProtectionFilter(handler: XXssProtectionHandler) : HelmetFilter<XXssProtectionHandler>(handler)
