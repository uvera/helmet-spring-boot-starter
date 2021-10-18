package io.uvera.helmet.core.handler

import io.uvera.helmet.core.HelmetProperties
import io.uvera.helmet.core.configuration.ContentSecurityPolicyValues
import org.springframework.stereotype.Component


@Component
class ContentSecurityPolicyHandler(props: HelmetProperties) : HelmetHandler {

    override val headerName = parseHeaderName(props)
    override val headerValue = parseHeaderValue(props)

    private fun parseHeaderValue(props: HelmetProperties): String {
        val directives =
            if (props.contentSecurityPolicy.useDefault) ContentSecurityPolicyValues.defaultValues.toMutableMap() else mutableMapOf()
        props.contentSecurityPolicy.directives
            .forEach { (key, value) ->
                val newKey = key.dashify()
                directives[newKey] = value
            }

        val result = directives
            .mapKeys { it.key.dashify() }
            .map { (entry, value) ->
                val directiveValue = value.joinToString(separator = " ")
                if (directiveValue.isBlank()) {
                    entry
                } else {
                    "$entry $directiveValue"
                }
            }
        return result.joinToString(separator = ";")
    }

    private fun parseHeaderName(props: HelmetProperties): String =
        if (props.contentSecurityPolicy.reportOnly) "Content-Security-Policy-Report-Only"
        else "Content-Security-Policy"


    companion object {
        private val dashifyRegex: Regex = Regex("[A-Z]")
    }

    private fun String.dashify() = this.replace(dashifyRegex) {
        "-${it.value.lowercase()}"
    }
}
