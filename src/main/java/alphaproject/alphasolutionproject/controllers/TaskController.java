package alphaproject.alphasolutionproject.controllers;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;
import alphaproject.alphasolutionproject.domain.services.TaskService;
import alphaproject.alphasolutionproject.repositories.TaskRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class TaskController {
  private TaskService taskService = new TaskService(new TaskRepositoryImpl());

    @GetMapping("/goToCreateTask/{id}")
  public String createTask(Model model, @PathVariable("id") int id){
  Task task = new Task();
  model.addAttribute("task", task);
  model.addAttribute("projectID", id);
  return "create_task";
  }

  @PostMapping("/createTask/{id}")
  public String saveTask(@ModelAttribute("task")Task task, @RequestParam("projectID") int projectID) throws SampleExeption {
   // User user = (User)hs.getAttribute("user");
    taskService.createNewTask(task, projectID);
    return "redirect:/showProjects";
  }



}
