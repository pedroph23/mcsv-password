package br.com.mcsvpassword.mcsvpassword.controller;

import br.com.mcsvpassword.mcsvpassword.model.dto.PasswordInput;
import br.com.mcsvpassword.mcsvpassword.model.dto.PasswordOutput;
import br.com.mcsvpassword.mcsvpassword.service.PasswordService;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/password")
@Api(tags = "Senhas")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @ApiResponse(code = 200, message = "OK", response = PasswordOutput.class)
    @ApiOperation("Realiza a validação de senha")
    @PostMapping("/validate")
    public ResponseEntity<PasswordOutput> validate(
            @ApiParam(value = "password", example = "4100003")
            @RequestBody PasswordInput password
    ) {
            boolean result = passwordService.validate(password.getPassword());
            return ResponseEntity.ok(new PasswordOutput(result));
    }
}
