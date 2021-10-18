package io.uvera.helmet.core.handler

import io.uvera.helmet.core.HelmetProperties
import org.springframework.stereotype.Component

@Component
class StrictTransportSecurityHandler(props: HelmetProperties) : HelmetHandler {
    override val headerName: String = "Strict-Transport-Security"
    override val headerValue: String = with(props.strictTransportSecurity) {
        val result = mutableListOf(
            "max-age=${this.maxAge}"
        )
        if (this.includeSubDomains) {
            result.add("includeSubDomains")
        }
        if (this.preload) {
            result.add("preload")
        }
        result.joinToString(separator = "; ")
    }
}
