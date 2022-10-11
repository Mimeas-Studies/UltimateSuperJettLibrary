package com.github.mimeas_studies.usjlib;

public class Program {
    public static void main(String[] args) throws Exception {

        String env_port = System.getenv().get("PORT");
        int port = env_port == null? 8080: Integer.parseInt(env_port);

        LibraryServer server = new LibraryServer(port);

        server.start();
    }
}
