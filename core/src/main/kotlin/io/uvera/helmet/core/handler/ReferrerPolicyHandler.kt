package io.uvera.helmet.core.handler

import io.uvera.helmet.core.HelmetProperties
import org.springframework.stereotype.Component

@Component
class ReferrerPolicyHandler(props: HelmetProperties) : HelmetHandler {
    override val headerName: String = "Referrer-Policy"
    override val headerValue: String = with(props.referrerPolicy) {
        return@with this.joinToString(separator = ",") { it.value }
    }
}
