package alphaproject.alphasolutionproject.controllers;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.services.*;
import alphaproject.alphasolutionproject.repositories.ProjectRepositoryImpl;
import alphaproject.alphasolutionproject.repositories.TaskRepositoryImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class TaskController {
  private ProjectService projectService = new ProjectService(new ProjectRepositoryImpl());
  private TaskService taskService = new TaskService(new TaskRepositoryImpl());
  CalculatorService calculatorService = new CalculatorService();
  private Task task = new Task();


  @GetMapping("/goToCreateTask/{id}")
  public String createTask(Model model, @PathVariable("id") int id) {
    Task task = new Task();
    model.addAttribute("task", task);
    model.addAttribute("projectID", id);
    return "create_task";
  }

  @PostMapping("/createTask")
  public String saveTask(@ModelAttribute("task") Task task, @RequestParam("projectID") int projectID) throws ProjectExeption {
    taskService.createNewTask(task, projectID);
    return "redirect:/showTask";
  }

  @GetMapping("/showTask")
  public String showTask(Model model, HttpSession hs) {
    Project project = (Project) hs.getAttribute("currentProject");
    ArrayList<Task> tasks = calculatorService.calcTotalTaskTime(project);
    model.addAttribute("project", project);
    model.addAttribute("taskList", tasks);
    model.addAttribute("currentProject", projectService.loadSingleProject(project.getProjectId()));
    return "project_manager";
  }

  @GetMapping("/deleteTask/{id}")
  public String deleteTask(@PathVariable("id") int id) {
    taskService.deleteTask(id);
    return "redirect:/showTask";
  }

  @GetMapping("/goToSubtaskManager/{taskID}")
  public String goToProjectManager(@PathVariable("taskID") int taskID, HttpSession hs) {
    Task currentTask = new Task(taskID);
    hs.setAttribute("currentTask", currentTask);
    return "redirect:/showSubTask";
  }

  @PostMapping("/editTask")
  public String editTask(@ModelAttribute("editedTask") Task editedTask, @RequestParam("taskID") int taskID) throws ProjectExeption {

    taskService.editTask(editedTask, taskID);

    return "redirect:/showTask";
  }

  @GetMapping("/goToEditTask/{taskID}")
  public String goToEditTask(Model model, @PathVariable("taskID") int taskID) {
    Task task = taskService.loadSingleTask(taskID);
    model.addAttribute("taskToEdit", task);
    model.addAttribute("taskID", taskID);
    return "edit_task";
  }

}
