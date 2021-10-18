package io.uvera.helmet.core.handler

import org.springframework.stereotype.Component

@Component
class CrossOriginEmbedderPolicyHandler : HelmetHandler {
    override val headerName: String = "Cross-Origin-Embedder-Policy"
    override val headerValue: String = "require-corp"
}
