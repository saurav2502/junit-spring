package com.junit.spring.junittest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.junit.spring.ApplicationTests;
import com.junit.spring.junittest.model.UserModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class JunitTestControllerTest extends ApplicationTests {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findAllUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/finAlldUser/2/15"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
        .andReturn();
    }

    @Test
    public void createUserTest()throws Exception{
        UserModel model = new UserModel();
        model.setUserId(985647);
        model.setUserName("Doing Any");
        model.setUserPassword("Offcource doing");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(model);
        System.out.println(model);
        mockMvc.perform(MockMvcRequestBuilders.post("/user/createUser")
        .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}