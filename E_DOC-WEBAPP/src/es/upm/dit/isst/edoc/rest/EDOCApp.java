package es.upm.dit.isst.edoc.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class EDOCApp extends ResourceConfig {
    public EDOCApp() {
        packages("es.upm.dit.isst.tfg.rest");
        }
}