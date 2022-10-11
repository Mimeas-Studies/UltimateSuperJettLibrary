package com.github.mimeas_studies.usjlib;

import org.eclipse.jetty.server.Server;
import java.net.InetSocketAddress;

public class LibraryServer {

    private final Server server;

    public LibraryServer(int port) {
        server = new Server(new InetSocketAddress("127.0.0.1", port));
    }

    public void start() throws Exception {
        server.start();
    }
}
