package br.com.mcsvpassword.mcsvpassword.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

import br.com.mcsvpassword.mcsvpassword.model.dto.PasswordInput;
import br.com.mcsvpassword.mcsvpassword.model.dto.PasswordOutput;
import br.com.mcsvpassword.mcsvpassword.service.PasswordService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.HttpServerErrorException;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PasswordController.class)
public class PasswordControllerTest extends Mockito {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    public PasswordController passwordController;

    @MockBean
    public PasswordService passwordService;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.passwordController);
    }


    @Test
    public void testConstructor() {
        PasswordController passwordController = new PasswordController(this.passwordService);
        assertEquals(passwordController, passwordController);
    }


    @Test
    @Description("Testando a funcionalidade de validação")
    public void testValidateWithSuccessStatus() throws Exception {
        passwordService = mock(PasswordService.class);
        when(this.passwordService.validate("teste")).thenReturn(true);

        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/v1/password/validate")
                        .content(String.valueOf(asJsonString(new PasswordInput("teste"))))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(new PasswordOutput(false))));

    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
