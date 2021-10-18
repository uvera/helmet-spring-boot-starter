package io.uvera.helmet.webflux.configuration

import io.uvera.helmet.webflux.filter.*
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
)
class HelmetWebfluxAutoConfiguration
