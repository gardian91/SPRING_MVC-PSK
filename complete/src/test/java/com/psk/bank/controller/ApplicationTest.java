package com.psk.bank.controller;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;


    
    @Test
    public void handleGetRequestTest() throws Exception {
        mockMvc.perform(get("/model"))
                .andExpect(content().string(containsString("get request : variant 1")));
    }
    
    @Test
    public void getDetailsTest() throws Exception {
        mockMvc.perform(get("/pathVariableExample/1234/Adrian"))
                .andExpect(content().string(containsString("1234 Adrian")));
    }
    
    @Test
    public void getDetailsResponseTest() throws Exception {
        this.mockMvc.perform(get("/pathVariableExample/1234/Adrian").accept(MediaType.parseMediaType("text/html;charset=UTF-8")))
                .andExpect(status().is(200))
                .andExpect(content().contentType("text/html;charset=UTF-8"));

    }
    
 
    
    @Test
    public void deleteWithPathVariableExampleShouldReturnDeletedUser() throws Exception {
    	mockMvc.perform(delete("/deleteUserWithGivenId/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is("1")))
        .andExpect(jsonPath("$.name", is("User1")))
        .andExpect(jsonPath("$.date", is("2017-01-02T21:32:00")));
    } 
    
    
    @Test
    public void postMethodExampleShouldReturnString() throws Exception{
    	
    	mockMvc.perform(post("/addUser")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", "1")
                .param("name", "NewUser")
                .param("date","2017-01-02T21:32:00"))
    	        .andExpect(content().string(containsString("User added successfully")));
    }
    
    
}
