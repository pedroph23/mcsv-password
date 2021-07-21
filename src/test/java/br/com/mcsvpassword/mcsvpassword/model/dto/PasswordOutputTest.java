package br.com.mcsvpassword.mcsvpassword.model.dto;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordOutputTest extends Mockito{

    @Test
    @Description("Validando o construtor do objeto PasswordOutput")
    public void testConstructor() {
       PasswordOutput po = new PasswordOutput(true);
       assertEquals(true, po.isValid());
    }

    @Test
    @Description("Validando a funcionalidade getPassword do objeto PasswordOutput")
    public void testIsValid() {
        PasswordOutput passwordInput = mock(PasswordOutput.class);
        when(passwordInput.isValid()).thenReturn(true);
        assertEquals(true, passwordInput.isValid());
    }

    @Test
    @Description("Validando a funcionalidade setPassword do objeto PasswordOutput")
    public void testSetValid() {
        PasswordOutput passwordInput = new PasswordOutput(true);
        passwordInput.setValid(true);
        assertEquals(true, passwordInput.isValid());
    }

}
