package io.uvera.helmet.core.handler

import org.springframework.stereotype.Component

@Component
class XContentTypeOptionsHandler : HelmetHandler {
    override val headerName: String = "X-Content-Type-Options"
    override val headerValue: String = "nosniff"
}
