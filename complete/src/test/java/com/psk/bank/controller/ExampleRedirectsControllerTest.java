package com.psk.bank.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Matchers.contains;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ExampleRedirectsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldRedirectToView() throws Exception {
        mockMvc.perform(get("/do-and-redirect-1")).andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", containsString("/destination")));
    }

    @Test
    public void shouldForwardView() throws Exception {
        mockMvc.perform(get("/do-and-forward")).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void shouldAcceptPlainText() throws Exception {
        mockMvc.perform(post("/consume-produce-example").contentType(MediaType.TEXT_PLAIN).content("input")
                .accept(MediaType.TEXT_PLAIN)).andExpect(status().is2xxSuccessful())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN));
    }

    @Test
    public void shouldRespondWithErrorWheNotPlainText() throws Exception {
        mockMvc.perform(post("/consume-produce-example").contentType(MediaType.APPLICATION_OCTET_STREAM)
                .accept(MediaType.TEXT_PLAIN).content("input")).andExpect(status().is4xxClientError());
    }
}
