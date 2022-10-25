package com.github.mimeas_studies.usjlib;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.util.resource.Resource;
import org.glassfish.jersey.servlet.ServletContainer;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class LibraryServer {

    private final Logger logger = LoggerFactory.getLogger(LibraryServer.class);
    private final Server server;

    public LibraryServer(int port) throws IOException {
        server = new Server(port);
        server.setHandler(createWebApp());
    }

    private WebAppContext createWebApp() throws IOException {
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");

        Resource resource = Resource.newClassPathResource("/webapp");
        var filepath = new File(
                resource.getFile()
                        .getAbsoluteFile()
                        .toString()
                        .replace("\\", "/")
                        .replace("target/classes", "src/main/resources")
        );
        if (filepath.isDirectory()) {
            webapp.setBaseResource(Resource.newResource(filepath));
            webapp.setInitParameter(DefaultServlet.CONTEXT_INIT + "useFileMappedBuffer", "false");
        }
        else {
            webapp.setBaseResource(resource);
        }

        var apiServlet = webapp.addServlet(ServletContainer.class, "/api/*");
        webapp.setInitParameter("jersey.config.server.provider.packages", "com.github.mimeas_studies.usjlib");


        return webapp;
    }

    public URL getURL() throws MalformedURLException {
        return server.getURI().toURL();
    }

    public void start() throws Exception {
        server.start();
        logger.info("Started server at {}", getURL());
    }
}
