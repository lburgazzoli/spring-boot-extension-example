package com.github.lburgazzoli.application.extension.beans;

import org.apache.camel.Handler;

public class MyExtension {

    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Handler
    public String handle() {
        return String.format("Hello %s", subject);
    }
}
