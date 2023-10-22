package com.mycompany.applicationone;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.client.TestRestTemplate.HttpClientOption;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApplicationOneApplicationTests {

	@Test
	void contextLoads() {
	}
	class GreetingsControllerTest {

    @LocalServerPort
    //private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testWelcomeEndpoint() {
        // Make an HTTP GET request to the /api/v1/welcome endpoint
        String url = "http://localhost:" + 8081 + "/api/v1/welcome";
        String response = restTemplate.getForObject(url, String.class);

        // Assert that the response matches your expected result
        assertEquals("Bonjour!", response);
    }

	
	}
}
