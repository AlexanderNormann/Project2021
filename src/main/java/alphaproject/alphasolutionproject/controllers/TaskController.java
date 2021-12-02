package alphaproject.alphasolutionproject.controllers;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.ProjectService;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;
import alphaproject.alphasolutionproject.domain.services.TaskService;
import alphaproject.alphasolutionproject.repositories.ProjectRepositoryImpl;
import alphaproject.alphasolutionproject.repositories.TaskRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class TaskController {
  private ProjectService projectService = new ProjectService(new ProjectRepositoryImpl());
  private TaskService taskService = new TaskService(new TaskRepositoryImpl());

    @GetMapping("/goToCreateTask/{id}")
  public String createTask(Model model, @PathVariable("id") int id, HttpSession hs){
  Task task = new Task();
  Project project = (Project) hs.getAttribute("currentProject");
  model.addAttribute("project", project);
  model.addAttribute("task", task);
  model.addAttribute("projectID", id);
  return "create_task";
  }

  @PostMapping("/createTask")
  public String saveTask(@ModelAttribute("task")Task task, @RequestParam("projectID") int projectID) throws SampleExeption {
    taskService.createNewTask(task, projectID);
    return "redirect:/showTask";
  }

  @GetMapping("/showTask")
  public String showTask(Model model, HttpSession hs){
      //projectService.loadSingleProject(projectID);
      Project project = (Project) hs.getAttribute("currentProject");
      model.addAttribute("project", project);
      model.addAttribute("taskList", taskService.loadProjectTasks(project.getProjectId()));
      return "project_manager";
  }



}
