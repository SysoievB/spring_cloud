package com.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
public class GlobalFiltersConfig {

    @Order(1)
    @Bean
    public GlobalFilter secondPreFilter() {
        return (exchange, chain) -> {
            log.info("*********************SecondPreFilter was executed*********************");

            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() ->
                            log.info("*********************SecondPostFilter was executed*********************")
                    ));
        };
    }

    @Order(2)
    @Bean
    public GlobalFilter thirdPreFilter() {
        return (exchange, chain) -> {
            log.info("*********************ThirdPreFilter was executed*********************");

            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() ->
                            log.info("*********************ThirdPostFilter was executed*********************")
                    ));
        };
    }

    @Order(3)
    @Bean
    public GlobalFilter fourthPreFilter() {
        return (exchange, chain) -> {
            log.info("*********************FourthPreFilter was executed*********************");

            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() ->
                            log.info("*********************FourthPostFilter was executed*********************")
                    ));
        };
    }
}
