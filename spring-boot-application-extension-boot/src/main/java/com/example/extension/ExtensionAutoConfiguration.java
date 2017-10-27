package com.example.extension;

import io.syndesis.integration.runtime.api.SyndesisExtensionRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ExtensionAutoConfiguration {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @ConditionalOnProperty(prefix = "com.example.extension.simple-timer", name = "enabled")
    public RouteBuilder simpleTimer() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("timer:my-extension?period=2s")
                    .log("MyExtension timer");
            }
        };
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @ConditionalOnProperty(prefix = "com.example.extension.ping-google", name = "enabled")
    public RouteBuilder pingGoogle() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("timer:ping-google?period=5s")
                    //.to("http4://www.google.com")
                    .to("log:com.example.extension?level=INFO&showAll=true&multiline=false");
            }
        };
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @ConditionalOnProperty(prefix = "com.example.extension.simple-definition", name = "enabled")
    public RouteDefinition simpleDefinition() {
        return SyndesisExtensionRoute.from("timer:simple-definition?period=3s").log("MyDefinition timer");
    }
}
