package alphaproject.alphasolutionproject.controllers;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.SubTask;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;
import alphaproject.alphasolutionproject.domain.services.SubTaskService;
import alphaproject.alphasolutionproject.repositories.SubTaskRespositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class SubTaskController {
  private SubTaskService subTaskService = new SubTaskService(new SubTaskRespositoryImpl());

  @GetMapping("/goToCreateSubTask/{id}")
  public String createTask(Model model, @PathVariable("id") int id){
    SubTask subTask = new SubTask();
    model.addAttribute("subTask", subTask);
    model.addAttribute("taskID", id);
    return "create_subtask";
  }

  @PostMapping("/createSubTask")
  public String saveSubTask(@ModelAttribute("subTask") SubTask subTask, @RequestParam("taskID") int taskID) throws SampleExeption {
    subTaskService.createNewSubTask(subTask, taskID);
    return "redirect:/showTask";
  }

  @GetMapping("/showSubTask")
  public String showSubTask(Model model, HttpSession hs){
    Project project = (Project) hs.getAttribute("currentProject");
    model.addAttribute("project", project);
    //model.addAttribute("taskList", taskService.loadProjectTasks(project.getProjectId()));
    return "project_manager";
  }


}
