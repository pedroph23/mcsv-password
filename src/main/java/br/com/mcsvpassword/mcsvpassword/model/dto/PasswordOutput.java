package br.com.mcsvpassword.mcsvpassword.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordOutput {

    public boolean valid;

    public PasswordOutput(boolean valid) {
        this.valid = valid;
    }
}
