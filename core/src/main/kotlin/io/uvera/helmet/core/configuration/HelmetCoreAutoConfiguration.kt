package io.uvera.helmet.core.configuration

import io.uvera.helmet.core.HelmetProperties
import io.uvera.helmet.core.handler.*
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
    HelmetProperties::class,
    ContentSecurityPolicyHandler::class,
    CrossOriginEmbedderPolicyHandler::class,
    CrossOriginOpenerPolicyHandler::class,
    CrossOriginResourcePolicyHandler::class,
    OriginAgentClusterHandler::class,
    ReferrerPolicyHandler::class,
    StrictTransportSecurityHandler::class,
    XContentTypeOptionsHandler::class,
    XDnsPrefetchControlHandler::class,
    XDownloadOptionsHandler::class,
    XFrameOptionsHandler::class,
    XPermittedCrossDomainPoliciesHandler::class,
    XPoweredByHandler::class,
    XXssProtectionHandler::class,
)
class HelmetCoreAutoConfiguration
