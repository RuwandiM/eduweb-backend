package eduweb.eduweb_backend.controller;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import eduweb.eduweb_backend.model.User;
import eduweb.eduweb_backend.repository.UserRepository;
import eduweb.eduweb_backend.response.ResponseHandler;
import eduweb.eduweb_backend.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectWriter;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    User user;

    @BeforeEach
    void setUp() {
        user = new User("001", "testuser1", "1234", 1, "testuser1@gmail.com");
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testGetUser() throws Exception {
        ResponseEntity<Object> response =  ResponseHandler.responseBuilder(
                "User found", HttpStatus.FOUND, user
        );
        when(userService.getUser("001")).thenReturn(response);
        this.mockMvc.perform(get("/user/001")).andDo(print()).andExpect(status().isFound());
    }

    @Test
    void testRegister() throws Exception {

        ObjectMapper mapper =  new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(user);

        ResponseEntity<Object> response =  ResponseHandler.responseBuilder(
                "User created successfully", HttpStatus.CREATED, user
        );
        when(userService.register(user)).thenReturn(response);
        this.mockMvc.perform(post("/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testLogin() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode loginCredentials = mapper.createObjectNode();
        loginCredentials.put("email", "testuser1@gmail.com");
        loginCredentials.put("password", "1234");

        // Convert to JSON string
        String requestJson = mapper.writeValueAsString(loginCredentials);

        ResponseEntity<Object> response = ResponseHandler.responseBuilder(
                "User found", HttpStatus.OK, user
        );

        when(userService.login("testuser1@gmail.com", "1234")).thenReturn(response);

        this.mockMvc.perform(post("/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    void testForgetpassword() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode loginCredentials = mapper.createObjectNode();
        loginCredentials.put("email", "testuser1@gmail.com");
        loginCredentials.put("password", "2345");

        // Convert to JSON string
        String requestJson = mapper.writeValueAsString(loginCredentials);

        ResponseEntity<Object> response =  ResponseHandler.responseBuilder(
                "User password updated successfully", HttpStatus.OK, user
        );
        when(userService.forgetPassword("testuser1@gmail.com", "2345")).thenReturn(response);
        this.mockMvc.perform(put("/user/forgetpassword")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }
}