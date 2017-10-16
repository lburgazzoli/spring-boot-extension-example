package com.github.lburgazzoli.application.extension;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExtensionRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:boot-extension")
            .log("Extension route (boot)");
    }
}