package com.backend.zuul.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class PreFilter extends ZuulFilter{
    private static final Logger logger = LoggerFactory.getLogger(PreFilter.class);

    @Override
    public String filterType() {
        return "pre"; 
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true; 
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String requestId = java.util.UUID.randomUUID().toString();
        ctx.addZuulRequestHeader("X-Request-ID", requestId);
        logger.info("Filtro 'Agregar Header' - Se agregó el encabezado X-Request-ID con el valor: " + requestId);
        return null;
    }
}
