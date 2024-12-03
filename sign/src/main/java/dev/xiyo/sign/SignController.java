package dev.xiyo.sign;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SignController {

    @GetMapping("/sign-up")
    public String signUp() {
        return "sign-up";
    }

    @GetMapping("/sign-in")
    public String signIn() {
        return "sign-in";
    }

    @GetMapping("/sign-out")
    public String signOut() {
        return "sign-out";
    }

    @PostMapping("/sign-up")
    @ResponseBody
    public String signUp(String username, String password) {
        return "Sign up: " + username + " " + password;
    }

    @PostMapping("/sign-in")
    @ResponseBody
    public String signIn(String username, String password) {
        return "Sign in: " + username + " " + password;
    }

    @PostMapping("/sign-out")
    @ResponseBody
    public String signOut(String username) {
        return "Sign out: " + username;
    }
}
