package com.github.mimeas_studies.usjlib;

import org.eclipse.jetty.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class LibraryServer {

    private final Logger logger = LoggerFactory.getLogger(LibraryServer.class);
    private final Server server;

    public LibraryServer(int port) {
        server = new Server(port);
    }

    public URL getURL() throws MalformedURLException {
        return server.getURI().toURL();
    }

    public void start() throws Exception {
        server.start();
        logger.info("Started server at {}", getURL());
    }
}
