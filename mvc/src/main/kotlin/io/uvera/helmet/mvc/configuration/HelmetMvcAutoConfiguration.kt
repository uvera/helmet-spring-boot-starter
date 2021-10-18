package io.uvera.helmet.mvc.configuration

import io.uvera.helmet.core.configuration.HelmetCoreAutoConfiguration
import io.uvera.helmet.mvc.filter.*
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
    ContentSecurityPolicyFilter::class,
    CrossOriginEmbedderPolicyFilter::class,
    CrossOriginOpenerPolicyFilter::class,
    CrossOriginResourcePolicyFilter::class,
    OriginAgentClusterFilter::class,
    ReferrerPolicyFilter::class,
    StrictTransportSecurityFilter::class,
    XContentTypeOptionsFilter::class,
    XDnsPrefetchControlFilter::class,
    XDownloadOptionsFilter::class,
    XFrameOptionsFilter::class,
    XPermittedCrossDomainPoliciesFilter::class,
    XPoweredByFilter::class,
    XXssProtectionFilter::class,
    HelmetCoreAutoConfiguration::class,
)
class HelmetMvcAutoConfiguration
