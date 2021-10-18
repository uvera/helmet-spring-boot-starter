package io.uvera.helmet.core.configuration

object ContentSecurityPolicyValues {
    val defaultValues: Map<String, List<String>> = mapOf(
        "default-src" to listOf("'self'"),
        "base-uri" to listOf("'self'"),
        "block-all-mixed-content" to listOf(),
        "font-src" to listOf("'self'", "https:", "data:"),
        "frame-ancestors" to listOf("'self'"),
        "img-src" to listOf("'self'", "data:"),
        "object-src" to listOf("'none'"),
        "script-src" to listOf("'self'"),
        "script-src-attr" to listOf("'none'"),
        "style-src" to listOf("'self'", "https:", "'unsafe-inline'"),
        "upgrade-insecure-requests" to listOf()
    )
}
