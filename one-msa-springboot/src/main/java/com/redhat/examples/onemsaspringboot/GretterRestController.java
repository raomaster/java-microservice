package com.redhat.examples.onemsaspringboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix = "greeting")
public class GretterRestController {
    private String saying;
    private String backendServiceHost;
    private int backendServicePort;

    @RequestMapping(value="/greeting", 
    method = RequestMethod.GET, produces = "text/plain")
    public String Greeting() {
        String backendServiceUrl = String.format("http://$s:Sd/api/backend?greeting={greeting}", 
            backendServiceHost, backendServicePort);
        System.out.println("Sending to:" + backendServiceUrl);
        return backendServiceUrl;
    }

    public void setSaying(String ssaying) {
        this.saying = saying;
    }

    public void setBackendServiceHost(String backendServiceHost) {
        this.backendServiceHost = backendServiceHost;
    }

    public void setBackendServicePort(int backendServicePort) {
        this.backendServicePort = backendServicePort;
    }
}
