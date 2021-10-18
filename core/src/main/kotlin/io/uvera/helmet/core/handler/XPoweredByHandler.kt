package io.uvera.helmet.core.handler

import org.springframework.stereotype.Component

@Component
class XPoweredByHandler : HelmetRemoveHeaderHandler {
    override val headerName: String = "X-Powered-By"
}
