@file:Suppress("unused")

package io.uvera.helmet.core

import DirectiveValuesValid
import io.uvera.helmet.core.validation.DefaultSrcDirectiveValid
import io.uvera.helmet.core.validation.DirectiveNameValid
import io.uvera.helmet.core.validation.DirectivesNotEmptyWhenUseDefaultIsFalse
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty

@Component
@Validated
@ConfigurationProperties(prefix = "spring-helmet")
@DirectivesNotEmptyWhenUseDefaultIsFalse
class HelmetProperties {
    var enableCrossOriginEmbedderPolicy: Boolean = true
    var enableCrossOriginOpenerPolicy: Boolean = true
    var enableCrossOriginResourcePolicy: Boolean = true
    var enableOriginAgentCluster: Boolean = true
    var enableReferrerPolicy: Boolean = true
    var enableStrictTransportSecurity: Boolean = true
    var enableDoNotSniffMimetype: Boolean = true
    var enableXDnsPrefetchControl: Boolean = true
    var enableXDownloadOptions: Boolean = true
    var enableXFrameOptions: Boolean = true
    var enableXPermittedCrossDomainPolicies: Boolean = true
    var removeXPoweredBy: Boolean = true
    var disableXXssProtection: Boolean = true
    var enableContentSecurityPolicy: Boolean = true


    var crossOriginResourcePolicy: CrossOriginResourcePolicy = CrossOriginResourcePolicy.SAME_ORIGIN
    var crossOriginOpenerPolicy: CrossOriginOpenerPolicy = CrossOriginOpenerPolicy.SAME_ORIGIN

    @NotEmpty
    var referrerPolicy: List<ReferrerPolicy> = listOf(ReferrerPolicy.NO_REFERRER)

    var strictTransportSecurity = StrictTransportSecurityProperties()

    class StrictTransportSecurityProperties {
        @Min(1)
        var maxAge: Long = 15552000L
        var includeSubDomains: Boolean = true
        var preload = false
    }

    var xDnsPrefetchControl: XDnsPrefetchControl = XDnsPrefetchControl.OFF
    var xFrameOptions: XFrameOptions = XFrameOptions.SAME_ORIGIN
    var xPermittedCrossDomainPolicies: XPermittedCrossDomainPolicies = XPermittedCrossDomainPolicies.NONE

    var contentSecurityPolicy: ContentSecurityPolicyProperties = ContentSecurityPolicyProperties()

    @Validated
    class ContentSecurityPolicyProperties {
        @get:DirectiveValuesValid
        @get:DirectiveNameValid
        @get:DefaultSrcDirectiveValid
        var directives: CSPDirectives = mapOf()
        var useDefault: Boolean = true
        var reportOnly: Boolean = false
    }
}

typealias CSPDirectives = Map<String, List<String>>

enum class CrossOriginOpenerPolicy(val value: String) {
    SAME_ORIGIN("same-origin"),
    SAME_ORIGIN_ALLOW_POPUPS("same-origin-allow-popups"),
    UNSAFE_NONE("unsafe-none")
}

enum class CrossOriginResourcePolicy(val value: String) {
    SAME_ORIGIN("same-origin"),
    SAME_SITE("same-site"),
    CROSS_ORIGIN("cross-origin")
}

enum class ReferrerPolicy(val value: String) {
    NO_REFERRER("no-referrer"),
    NO_REFERRER_WHEN_DOWNGRADE("no-referrer-when-downgrade"),
    SAME_ORIGIN("same-origin"),
    ORIGIN("origin"),
    STRICT_ORIGIN("strict-origin"),
    ORIGIN_WHEN_CROSS_ORIGIN("origin-when-cross-origin"),
    STRICT_ORIGIN_WHEN_CROSS_ORIGIN("strict-origin-when-cross-origin"),
    UNSAFE_URL("unsafe-url"),
    EMPTY_STRING(""),
}

enum class XDnsPrefetchControl {
    ON, OFF
}

enum class XFrameOptions(val value: String) {
    DENY("DENY"),
    SAME_ORIGIN("SAMEORIGIN")
}

enum class XPermittedCrossDomainPolicies(val value: String) {
    NONE("none"),
    MASTER_ONLY("master-only"),
    BY_CONTENT_TYPE("by-content-type"),
    ALL("all")
}
