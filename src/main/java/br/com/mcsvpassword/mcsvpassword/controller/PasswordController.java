package br.com.mcsvpassword.mcsvpassword.controller;

import br.com.mcsvpassword.mcsvpassword.model.dto.PasswordInput;
import br.com.mcsvpassword.mcsvpassword.model.dto.PasswordOutput;
import br.com.mcsvpassword.mcsvpassword.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpServerErrorException;

@Controller
@RequestMapping("v1/password")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @PostMapping("/validate")
    public ResponseEntity validate(@RequestBody PasswordInput password) {
            boolean result = passwordService.validate(password.getPassword());
            return ResponseEntity.ok(new PasswordOutput(result));
    }
}
