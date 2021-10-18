package io.uvera.helmet.mvc.filter

import io.uvera.helmet.core.handler.HelmetHandler
import io.uvera.helmet.core.handler.HelmetRemoveHeaderHandler
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

abstract class HelmetFilter<T : HelmetHandler>(val handler: T) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) = handler.handle { name, value ->
        response.setHeader(name, value)
        filterChain.doFilter(request, response)
    }

}

abstract class HelmetRemoveHeaderWebFilter<T : HelmetRemoveHeaderHandler>(val handler: T) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) = handler.handle { name ->
        response.setHeader(name, null)
        filterChain.doFilter(request, response)
    }
}
