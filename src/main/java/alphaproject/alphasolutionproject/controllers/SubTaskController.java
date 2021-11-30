package alphaproject.alphasolutionproject.controllers;

import alphaproject.alphasolutionproject.domain.model.SubTask;
import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;
import alphaproject.alphasolutionproject.domain.services.SubTaskService;
import alphaproject.alphasolutionproject.domain.services.TaskService;
import alphaproject.alphasolutionproject.repositories.SubTaskRespositoryImpl;
import alphaproject.alphasolutionproject.repositories.TaskRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class SubTaskController {
  private SubTaskService subTaskService = new SubTaskService(new SubTaskRespositoryImpl());

  @GetMapping("/goToCreateSubTask")
  public String createTask(Model model){
    SubTask subTask = new SubTask();
    model.addAttribute("subTask", subTask);
    return "create_subtask";
  }

  @PostMapping("/saveSubTask")
  public String saveTask(@ModelAttribute("subTask") SubTask subTask, HttpSession hs) throws SampleExeption {
    User user = (User)hs.getAttribute("user");
    subTaskService.createNewSubTask(subTask, user);
    return "frontpage";
  }


}
