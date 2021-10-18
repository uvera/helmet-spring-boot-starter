package io.uvera.helmet.core.handler

import org.springframework.stereotype.Component

@Component
class XXssProtectionHandler : HelmetHandler {
    override val headerName: String = "X-XSS-Protection"
    override val headerValue: String = "0"
}
