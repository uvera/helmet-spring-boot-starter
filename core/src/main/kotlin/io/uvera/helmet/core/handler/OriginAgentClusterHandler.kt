package io.uvera.helmet.core.handler

import org.springframework.stereotype.Component

@Component
class OriginAgentClusterHandler : HelmetHandler {
    override val headerName: String = "Origin-Agent-Cluster"
    override val headerValue: String = "?1"
}
