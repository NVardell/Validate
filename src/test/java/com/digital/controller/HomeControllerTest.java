package com.digital.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * TODO - Class definition
 *
 * @author Nate Vardell
 * @since 3/28/2018
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    /**
     * Starts server with random port & sends HTTP request & asserts response
     * @throws Exception
     */
    @Test
    public void testHealthMapping() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/health", String.class)).contains("UP");
    }

    /**
     * Full Spring app context is started, but without server
     * Sends HTTP Request & asserts response
     * @throws Exception
     */
    @Test
    public void testHealthMapping2() throws Exception {
        this.mockMvc.perform(get("/health")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("UP")));
    }
}
