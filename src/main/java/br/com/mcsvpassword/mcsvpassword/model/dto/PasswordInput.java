package br.com.mcsvpassword.mcsvpassword.model.dto;

public class PasswordInput {

    public String password;

    public PasswordInput(String password) {
        this.password = password;
    }

    public PasswordInput() { }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
