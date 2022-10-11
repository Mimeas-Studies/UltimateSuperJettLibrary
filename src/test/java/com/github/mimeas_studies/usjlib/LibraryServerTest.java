package com.github.mimeas_studies.usjlib;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class LibraryServerTest {

    private LibraryServer server;

    @BeforeEach
    public void setup() throws Exception {
        server = new LibraryServer(0);
        server.start();
    }

    private HttpURLConnection getOpenConnection(String path) throws IOException {
        return (HttpURLConnection) new URL(server.getURL(), path).openConnection();
    }

    @Test
    void servesStaticSite() throws IOException {
        var connection = getOpenConnection("/");
        assertThat(connection.getResponseCode()).as(connection.getResponseMessage())
                .isEqualTo(200);
    }

}
