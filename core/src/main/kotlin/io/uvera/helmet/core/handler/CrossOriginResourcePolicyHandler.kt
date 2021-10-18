package io.uvera.helmet.core.handler

import io.uvera.helmet.core.HelmetProperties
import org.springframework.stereotype.Component

@Component
class CrossOriginResourcePolicyHandler(props: HelmetProperties) : HelmetHandler {
    override val headerName: String = "Cross-Origin-Resource-Policy"
    override val headerValue: String = props.crossOriginResourcePolicy.value
}
