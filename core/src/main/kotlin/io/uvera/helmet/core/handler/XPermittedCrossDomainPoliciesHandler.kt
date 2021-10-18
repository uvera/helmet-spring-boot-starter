package io.uvera.helmet.core.handler

import io.uvera.helmet.core.HelmetProperties
import org.springframework.stereotype.Component

@Component
class XPermittedCrossDomainPoliciesHandler(props: HelmetProperties) : HelmetHandler {
    override val headerName: String = "X-Permitted-Cross-Domain-Policies"
    override val headerValue: String = props.xPermittedCrossDomainPolicies.value
}
