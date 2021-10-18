package io.uvera.helmet.mvc.filter

import io.uvera.helmet.core.handler.OriginAgentClusterHandler
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@ConditionalOnProperty(prefix = "spring-helmet", name = ["enable-origin-agent-cluster"])
@Order(1)
@Component
class OriginAgentClusterFilter(handler: OriginAgentClusterHandler) :
    HelmetFilter<OriginAgentClusterHandler>(handler) {
}
