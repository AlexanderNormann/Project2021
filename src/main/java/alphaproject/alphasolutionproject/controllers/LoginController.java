package alphaproject.alphasolutionproject.controllers;

import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private LoginService loginService;

    public LoginController(LoginService loginService){
       this.loginService = loginService;
    }


    //This redirect to the frontpage
    @GetMapping("/")
    public String index(@ModelAttribute("User") User user, HttpSession hs){
        hs.setAttribute("user", user);
        return "index"; }

    //This creates a user to database
    @PostMapping("/createUser")
    public String saveUser(@ModelAttribute("User") User user) throws Exception{
    loginService.createUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
    return "redirect:/";
    }

    //This redirect to "create user"
    @GetMapping("/goToCreateUser")
    public String createUser(@ModelAttribute("User")User user) throws Exception{
        return "create_account";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("User") User user, HttpSession hs) throws Exception {
        User currentUser = loginService.login(user.getEmail(), user.getPassword());
        hs.setAttribute("user", currentUser);
        return "frontpage"; }

    @GetMapping("/logout")
    public String logout(HttpSession hs){
    if (hs != null){
        hs.invalidate();
    }
    return "index";
    }





}
