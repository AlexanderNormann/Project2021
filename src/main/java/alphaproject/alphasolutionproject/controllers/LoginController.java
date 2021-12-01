package alphaproject.alphasolutionproject.controllers;

import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.LoginService;
import alphaproject.alphasolutionproject.repositories.UserRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private LoginService loginService = new LoginService(new UserRepositoryImpl());


    //This redirect to the frontpage
    @GetMapping("/")
    public String index(@ModelAttribute("User") User user, HttpSession hs){
        hs.setAttribute("user", user);
        return "index"; }

    //This creates a user to database
    @PostMapping("/createUser")
    public String saveUser(@ModelAttribute("User") User user) throws Exception{
    loginService.createUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getAuthority());
    return "redirect:/";
    }

    //This redirect to "create user"
    @GetMapping("/goToCreateUser")
    public String createUser(@ModelAttribute("User")User user) throws Exception{
        return "create_account";
    }

    //This login to the site and direct it to frontpage
    @PostMapping("/login")
    public String login(@ModelAttribute("User") User user, HttpSession hs) throws Exception {
        User currentUser = loginService.login(user.getEmail(), user.getPassword());
        hs.setAttribute("user", currentUser);
        return "frontpage"; }

    //This terminates the session and logs out
    @GetMapping("/logout")
    public String logout(HttpSession hs){
    if (hs != null){
        hs.invalidate();
    }
    return "redirect:/";
    }

/*
    @GetMapping("/showFirstname")
    public String showFirstname(Model model, HttpSession hs){
        User user = (User) hs.getAttribute("user");
        model.addAttribute("firstname", loginService.displayFirstname(user.getUserId()));
        return "frontpage";
    }

 */







}
