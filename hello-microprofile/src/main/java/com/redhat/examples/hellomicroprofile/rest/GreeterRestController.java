package com.redhat.examples.hellomicroprofile.rest;

import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/api")
public class GreeterRestController {

    @Inject
    @ConfigProperty(name = "greeting.saying", defaultValue = "hello")
    private String saying;

    @Inject
    @ConfigProperty(name = "greeting.backendServiceHost", defaultValue = "localhost")
    private String backendServiceHost;

    @Inject
    @ConfigProperty(name = "greeting.backendServicePort", defaultValue = "8080")
    private int backendServicePort;

    @GET
    @Produces("text/plain")
    @Path("greeting")
    public String greeting() {

        String backendServiceUrl = String.format("http://%s:%d", 
            backendServiceHost, backendServicePort);
        System.out.println("Sending to: " + backendServiceUrl);

        Client client = ClientBuilder.newClient();
        BackendDTO backendDTO = client.target(backendServiceUrl)
        .path("api")
        .path("backend")
        .queryParam("greeting", saying)
        .request(MediaType.APPLICATION_JSON_TYPE)
        .get(BackendDTO.class);
        return backendDTO.getGreeting()
        + " at host: " + backendDTO.getIp();
    }
}
