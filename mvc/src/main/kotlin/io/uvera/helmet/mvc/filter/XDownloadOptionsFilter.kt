package io.uvera.helmet.mvc.filter

import io.uvera.helmet.core.handler.XDownloadOptionsHandler
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component


@ConditionalOnProperty(prefix = "spring-helmet", name = ["enable-x-download-options"])
@Order(1)
@Component
class XDownloadOptionsFilter(handler: XDownloadOptionsHandler) : HelmetFilter<XDownloadOptionsHandler>(handler)
