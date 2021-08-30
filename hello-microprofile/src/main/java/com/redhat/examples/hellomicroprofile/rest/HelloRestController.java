package com.redhat.examples.hellomicroprofile.rest;

import javax.inject.*;
import javax.ws.rs.*;
import java.net.*;
import org.eclipse.microprofile.config.*;
import org.eclipse.microprofile.config.inject.*;



@Path("/api")
public class HelloRestController {

        @Inject
        @ConfigProperty(name="helloapp.saying")
        private String saying;

        @GET
        @Produces("text/plain")
        @Path("/hello")
        public String hello() {
            String hostname = null;
            try {
                hostname = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                hostname = "unknow";
            }
            return saying + " " + hostname;
        }
    
}
