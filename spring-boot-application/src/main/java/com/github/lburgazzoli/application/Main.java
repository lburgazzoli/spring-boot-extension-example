package com.github.lburgazzoli.application;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }

    @Component
    public static class MainRouteBuilder extends RouteBuilder {
        @Override
        public void configure() throws Exception {
            from("timer:main")
                .log("Main route");
        }
    }
}
