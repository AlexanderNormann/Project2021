package alphaproject.alphasolutionproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String index(){ return "index"; }

    @GetMapping("/create_account")
    public String goToCreateUser(){ return "create_account"; }
}
