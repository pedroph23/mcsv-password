package br.com.mcsvpassword.mcsvpassword.service.impl;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PasswordServiceImplTest {

    public PasswordServiceImpl passwordService;

    @Test
    @Description("Caso de sucesso passando a senha 'AbTp9!fok' ")
    public void testValidatePasswordCase1() {
        passwordService = new PasswordServiceImpl();
        assertEquals(true, passwordService.validate("AbTp9!fok"));
    }

    @Test
    @Description("Caso de erro passando a senha vazia")
    public void testValidatePasswordCase2() {
        passwordService = new PasswordServiceImpl();
        assertEquals(false, passwordService.validate(""));
    }

    @Test
    @Description("Caso de sucesso passando a senha 'aa'")
    public void testValidatePasswordCase3() {
        passwordService = new PasswordServiceImpl();
        assertEquals(false, passwordService.validate("aa"));
    }

    @Test
    @Description("Caso de sucesso passando a senha 'ab")
    public void testValidatePasswordCase4() {
        passwordService = new PasswordServiceImpl();
        assertEquals(false, passwordService.validate("ab"));
    }

    @Test
    @Description("Caso de sucesso passando a senha 'AAAbbbCc")
    public void testValidatePasswordCase5() {
        passwordService = new PasswordServiceImpl();
        assertEquals(false, passwordService.validate("AAAbbbCc"));
    }

    @Test
    @Description("Caso de sucesso passando a senha 'AbTp9!foo")
    public void testValidatePasswordCase6() {
        passwordService = new PasswordServiceImpl();
        assertEquals(false, passwordService.validate("AbTp9!foo"));
    }

    @Test
    @Description("Caso de sucesso passando a senha 'AbTp9!foA")
    public void testValidatePasswordCase7() {
        passwordService = new PasswordServiceImpl();
        assertEquals(false, passwordService.validate("AbTp9!foA"));
    }

    @Test
    @Description("Caso de sucesso passando a senha 'AbTp9 fok")
    public void testValidatePasswordCase8() {
        passwordService = new PasswordServiceImpl();
        assertEquals(false, passwordService.validate("AbTp9 fok"));
    }

}
