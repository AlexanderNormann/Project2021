package alphaproject.alphasolutionproject.controllers;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;
import alphaproject.alphasolutionproject.domain.services.TaskService;
import alphaproject.alphasolutionproject.repositories.TaskRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class TaskController {
  private TaskService taskService = new TaskService(new TaskRepositoryImpl());

  @GetMapping("/goToCreateTask")
  public String createTask(Model model){
  Task task = new Task();
  model.addAttribute("task", task);
  return "create_task";
  }

  @PostMapping("/saveTask")
  public String saveTask(@ModelAttribute("task")Task task, Project project, HttpSession hs) throws SampleExeption {
    User user = (User)hs.getAttribute("user");
    taskService.createNewTask(task, user, project);
    return "redirect:/showProjects";
  }

}
