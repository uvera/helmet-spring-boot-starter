package io.uvera.helmet.core.handler

import io.uvera.helmet.core.HelmetProperties
import org.springframework.stereotype.Component

@Component
class CrossOriginOpenerPolicyHandler(props: HelmetProperties) : HelmetHandler {
    override val headerName: String = "Cross-Origin-Opener-Policy"
    override val headerValue: String = props.crossOriginOpenerPolicy.value
}
