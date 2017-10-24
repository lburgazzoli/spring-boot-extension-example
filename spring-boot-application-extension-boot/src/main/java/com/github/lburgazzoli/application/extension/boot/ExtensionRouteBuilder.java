package com.github.lburgazzoli.application.extension.boot;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExtensionRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:boot-extension?period=5s")
            .to("http4://www.google.com")
            .to("log:com.github.lburgazzoli.application.extension.boot?level=INFO&showAll=true&multiline=true");
    }
}