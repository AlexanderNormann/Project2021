package alphaproject.alphasolutionproject.controllers;
import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.*;
import alphaproject.alphasolutionproject.repositories.ProjectRepositoryImpl;
import alphaproject.alphasolutionproject.repositories.UserRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class ProjectController {
  private ProjectService projectService = new ProjectService(new ProjectRepositoryImpl());
  private LoginService loginService = new LoginService((new UserRepositoryImpl()));
  private CalculatorService calculatorService = new CalculatorService();

  //lavet af Alexander
  @GetMapping("/goToCreateProject")
  public String createProject(Model model){
    Project project = new Project();
    model.addAttribute("project", project);
    return "create_project";
  }
  //lavet af Jonathan
  @PostMapping("/saveProject")
  public String saveProject(@ModelAttribute("project") Project project, HttpSession hs) throws ProjectExeption {
    User user = (User)hs.getAttribute("user");
    projectService.createNewProject(project, user);
    return "redirect:/showProjects";
  }

  //lavet af Alexander
  @GetMapping("/goToEditUser")
  public String editProfile(Model model, HttpSession hs){
    User user = (User)hs.getAttribute("user");
    model.addAttribute("currentuser", loginService.loadSingleUser(user.getUserId()));
    return "edit_user";
  }
  //lavet af Nicklas
  @PostMapping("/editUser")
  public String editProfile(@ModelAttribute ("editedUser") User editedUser, HttpSession hs ) throws ProjectExeption {
    User user = (User)hs.getAttribute("user");
    loginService.editUser(editedUser, user.getUserId());
    return "redirect:/showProjects";
  }
  //lavet af Jonathan
  @GetMapping("/goToFrontPage")
  public String goToFrontPage(){
    return "redirect:/showProjects";
  }

  //lavet af Nicklas
  @GetMapping("/showProjects")
  public String showProjects(Model model, HttpSession hs){
    User user = (User)hs.getAttribute("user");
    model.addAttribute("projectlist", calculatorService.calcTotalProjectTimeAndCost(user));
    model.addAttribute("currentUser", loginService.loadSingleUser(user.getUserId()));

    return "frontpage";
  }

  //lavet af Nicklas
  @GetMapping("/deleteProject/{id}")
  public String deleteProject(@PathVariable("id") int id){
    projectService.deleteProject(id);
    return "redirect:/showProjects";
  }

  //lavet af Jonathan
  @GetMapping("/goToProjectManager/{projectID}")
  public String goToProjectManager(@PathVariable("projectID") int projectID, HttpSession hs){
    Project currentProject = new Project(projectID);
    hs.setAttribute("currentProject", currentProject);
    return "redirect:/showTask";
  }
  //lavet af Nicklas
  @GetMapping("/goToEditProject/{projectID}")
  public String goToEditProject(Model model, @PathVariable("projectID") int projectID){
    Project project = projectService.loadSingleProject(projectID);
    model.addAttribute("projectToEdit", project);
    model.addAttribute("projectID", projectID);
    return "edit_project";
  }
  //lavet af Alexander
  @PostMapping("/editProject")
  public String editProject(@ModelAttribute("editedProject") Project editedProject, @RequestParam("projectID") int projectID) throws ProjectExeption {
    projectService.editProject(editedProject, projectID);
    return"redirect:/showProjects";
  }

}
