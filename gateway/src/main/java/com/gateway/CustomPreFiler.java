package com.gateway;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class CustomPreFiler implements GlobalFilter, Ordered {
    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("*********************CustomPreFiler was executed*********************");
        val pathRequest = exchange.getRequest().getPath().toString();
        log.info("*********************pathRequest = {}*********************", pathRequest);

        exchange.getRequest().getHeaders()
                .forEach((key, value) -> log.info("***{} = {}***", key, value.toString()));

        return chain.filter(exchange);
    }
}
