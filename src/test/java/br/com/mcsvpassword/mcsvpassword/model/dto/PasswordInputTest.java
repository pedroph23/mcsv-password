package br.com.mcsvpassword.mcsvpassword.model.dto;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordInputTest extends Mockito{

    @Test
    @Description("Validando o construtor do objeto PasswordInput")
    public void testConstructor() {
       PasswordInput pi = new PasswordInput();
       assertEquals(pi, pi);
    }

    @Test
    @Description("Validando o construtor com o parametro password do objeto PasswordInput")
    public void testConstructorWithParamPassword() {
        PasswordInput pi = new PasswordInput("teste");
        assertEquals("teste", pi.getPassword());
    }

    @Test
    @Description("Validando a funcionalidade getPassword do objeto PasswordInput")
    public void testGetPassword() {
        PasswordInput passwordInput = mock(PasswordInput.class);
        when(passwordInput.getPassword()).thenReturn("teste");
        assertEquals("teste", passwordInput.getPassword());
    }

    @Test
    @Description("Validando a funcionalidade setPassword do objeto PasswordInput")
    public void testSetPassword() {
        PasswordInput passwordInput = new PasswordInput("teste");
        passwordInput.setPassword("teste");
        assertEquals("teste", passwordInput.getPassword());
    }

}
