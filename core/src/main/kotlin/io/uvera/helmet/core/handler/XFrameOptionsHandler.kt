package io.uvera.helmet.core.handler

import io.uvera.helmet.core.HelmetProperties
import org.springframework.stereotype.Component

@Component
class XFrameOptionsHandler(props: HelmetProperties) : HelmetHandler {
    override val headerName: String = "X-Frame-Options"
    override val headerValue: String = props.xFrameOptions.value
}
