package io.uvera.helmet.core.handler

import io.uvera.helmet.core.HelmetProperties
import io.uvera.helmet.core.XDnsPrefetchControl
import org.springframework.stereotype.Component

@Component
class XDnsPrefetchControlHandler(props: HelmetProperties) : HelmetHandler {
    override val headerName: String = "X-DNS-Prefetch-Control"
    override val headerValue: String = with(props.xDnsPrefetchControl) {
        when (this) {
            XDnsPrefetchControl.ON -> "on"
            XDnsPrefetchControl.OFF -> "off"
        }
    }
}
