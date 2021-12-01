package alphaproject.alphasolutionproject.controllers;


import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.LoginService;
import alphaproject.alphasolutionproject.domain.services.ProjectService;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;
import alphaproject.alphasolutionproject.domain.services.TaskService;
import alphaproject.alphasolutionproject.repositories.ProjectRepositoryImpl;
import alphaproject.alphasolutionproject.repositories.TaskRepositoryImpl;
import alphaproject.alphasolutionproject.repositories.UserRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ProjectController {
  private ProjectService projectService = new ProjectService(new ProjectRepositoryImpl());
  private TaskService taskService = new TaskService(new TaskRepositoryImpl());

  @GetMapping("/goToCreateProject")
  public String createProject(Model model){
    Project project = new Project();
    model.addAttribute("project", project);
    return "create_project";
  }

  @PostMapping("/saveProject")
  public String saveProject(@ModelAttribute("project") Project project, HttpSession hs) throws SampleExeption {
    User user = (User)hs.getAttribute("user");
    projectService.createNewProject(project, user);
    return "redirect:/showProjects";
  }

  @GetMapping("/goToFrontPage")
  public String goToFrontPage(){
    return "redirect:/showProjects";
  }


  @GetMapping("/showProjects")
  public String showProjects(Model model, HttpSession hs){
    User user = (User)hs.getAttribute("user");
    model.addAttribute("projectlist", projectService.loadProjects(user.getUserId()));
    return "frontpage";
  }

  @GetMapping("/deleteProject/{id}")
  public String deleteProject(@PathVariable("id") int id){
    projectService.deleteProject(id);
    return "redirect:/showProjects";
  }

  @GetMapping("/goToProjectManager/{projectID}")
  public String goToProjectManager(@PathVariable("projectID") int projectID, Model model){
    projectService.loadSingleProject(projectID);
    System.out.println("test");
    System.out.println(projectService.loadSingleProject(projectID).getProjectId());
    model.addAttribute("project", projectService.loadSingleProject(projectID));
    return "project_manager";
  }

/*@GetMapping("/manageProject/{id}")
  public String manageProject(Task task, @PathVariable("id") int id) throws SampleExeption {
  taskService.createNewTask(task, id);
   return "project_manager";
}

 */





}
