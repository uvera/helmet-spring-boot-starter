package io.uvera.helmet.mvc.filter

import io.uvera.helmet.core.handler.XFrameOptionsHandler
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component


@ConditionalOnProperty(prefix = "spring-helmet", name = ["enable-x-frame-options"])
@Order(1)
@Component
class XFrameOptionsFilter(handler: XFrameOptionsHandler) : HelmetFilter<XFrameOptionsHandler>(handler)
