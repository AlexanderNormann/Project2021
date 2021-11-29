package alphaproject.alphasolutionproject.controllers;

import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private LoginService loginService;

    public LoginController(LoginService loginService){
       this.loginService = loginService;
    }



    @GetMapping("/")
    public String index(){ return "index"; }

    @PostMapping("/createUser")
    public String saveUser(@ModelAttribute("User") User user) throws Exception{
    loginService.createUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
    return "redirect:/";
    }

    @GetMapping("/goToCreateUser")
    public String createUser(@ModelAttribute("User")User user) throws Exception{
        return "create_account";
    }


}
