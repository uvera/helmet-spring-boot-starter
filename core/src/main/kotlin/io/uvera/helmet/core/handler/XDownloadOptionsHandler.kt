package io.uvera.helmet.core.handler

import org.springframework.stereotype.Component

@Component
class XDownloadOptionsHandler : HelmetHandler {
    override val headerName: String = "X-Download-Options"
    override val headerValue: String = "noopen"
}
