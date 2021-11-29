package alphaproject.alphasolutionproject.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ComponentScan()
public class LoginController {

    @GetMapping("/")
    public String index(){ return "index"; }

    @GetMapping("/create_account")
    public String goToCreateUser(){ return "create_account"; }
}
