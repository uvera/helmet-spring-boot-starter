package io.uvera.helmet.mvc.filter

import io.uvera.helmet.core.handler.XContentTypeOptionsHandler
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@ConditionalOnProperty(prefix = "spring-helmet", name = ["enable-do-not-sniff-mimetype"])
@Order(1)
@Component
class XContentTypeOptionsFilter(handler: XContentTypeOptionsHandler) :
    HelmetFilter<XContentTypeOptionsHandler>(handler)
