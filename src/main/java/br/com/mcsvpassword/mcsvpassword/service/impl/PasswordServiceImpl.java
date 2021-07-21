package br.com.mcsvpassword.mcsvpassword.service.impl;

import br.com.mcsvpassword.mcsvpassword.service.PasswordService;
import org.apache.el.stream.Stream;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PasswordServiceImpl implements PasswordService {

    public boolean validate(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()-+])[A-Za-z\\d!@#$%^&*()-+]{9,}$");
        Pattern verifyLetter = Pattern.compile("(.)(?=\\S*\\1)");

        Matcher matcher = pattern.matcher(password);
        Matcher matcherVerifyLetter = verifyLetter.matcher(password);

        return matcher.find() && !matcherVerifyLetter.find();
    }

}
