package io.uvera.helmet.mvc.filter

import io.uvera.helmet.core.handler.XPoweredByHandler
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@ConditionalOnProperty(prefix = "spring-helmet", name = ["remove-x-powered-by"])
@Order(1)
@Component
class XPoweredByFilter(handler: XPoweredByHandler) : HelmetRemoveHeaderWebFilter<XPoweredByHandler>(handler)
