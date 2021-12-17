package alphaproject.alphasolutionproject.controllers;

import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.LoginService;
import alphaproject.alphasolutionproject.domain.services.ProjectExeption;
import alphaproject.alphasolutionproject.repositories.UserRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
  private LoginService loginService = new LoginService(new UserRepositoryImpl());

  //lavet af alle
  @GetMapping("/")
  public String index(@ModelAttribute("User") User user, HttpSession hs) {
    hs.setAttribute("user", user);
    return "index";
  }

  //lavet af Jonathan
  @PostMapping("/createUser")
  public String saveUser(@ModelAttribute("User") User user) throws ProjectExeption{
    loginService.createUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getAuthority());
    return "redirect:/";
  }
  //lavet af Alexander
  @GetMapping("/goToCreateUser")
  public String createUser(@ModelAttribute("User") User user) {
    return "create_account";
  }

  //lavet af Nicklas
  @PostMapping("/login")
  public String login(@ModelAttribute("User") User user, HttpSession hs) throws ProjectExeption {
    User currentUser = loginService.login(user.getEmail(), user.getPassword());
    hs.setAttribute("user", currentUser);
    return "redirect:/showProjects";
  }

  //lavet af Nicklas
  @GetMapping("/logout")
  public String logout(HttpSession hs) {
    if (hs != null) {
      hs.invalidate();
    }
    return "redirect:/";
  }


}
