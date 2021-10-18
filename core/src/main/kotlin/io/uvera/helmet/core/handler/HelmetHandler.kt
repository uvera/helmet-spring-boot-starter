package io.uvera.helmet.core.handler

interface HelmetHandler {
    val headerName: String
    val headerValue: String
    fun <T : Any> handle(block: (headerName: String, headerValue: String) -> T): T = block(headerName, headerValue)
}

interface HelmetRemoveHeaderHandler {
    val headerName: String
    fun <T : Any> handle(block: (headerName: String) -> T): T = block(headerName)
}
