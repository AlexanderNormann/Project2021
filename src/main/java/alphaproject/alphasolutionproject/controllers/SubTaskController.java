package alphaproject.alphasolutionproject.controllers;

import alphaproject.alphasolutionproject.domain.model.SubTask;
import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.services.ProjectExeption;
import alphaproject.alphasolutionproject.domain.services.SubTaskService;
import alphaproject.alphasolutionproject.domain.services.TaskService;
import alphaproject.alphasolutionproject.repositories.SubTaskRespositoryImpl;
import alphaproject.alphasolutionproject.repositories.TaskRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class SubTaskController {
  private SubTaskService subTaskService = new SubTaskService(new SubTaskRespositoryImpl());
  private TaskService taskService = new TaskService(new TaskRepositoryImpl());

  //lavet af Jonathan
  @GetMapping("/goToCreateSubTask/{id}")
  public String createSubtask(Model model, @PathVariable("id") int id) {
    SubTask subTask = new SubTask();
    model.addAttribute("subTask", subTask);
    model.addAttribute("taskID", id);
    return "create_subtask";
  }
  //lavet af Alexander
  @PostMapping("/createSubTask")
  public String saveSubTask(@ModelAttribute("subTask") SubTask subTask, @RequestParam("taskID") int taskID) throws ProjectExeption {
    subTaskService.createNewSubTask(subTask, taskID);
    return "redirect:/showSubTask";
  }

  //lavet af Nicklas
  @GetMapping("/showSubTask")
  public String showSubTask(Model model, HttpSession hs) {
    Task task = (Task) hs.getAttribute("currentTask");
    ArrayList<SubTask> subTasks = subTaskService.loadSubTasksByTaskID(task.getTaskId());
    model.addAttribute("subtaskList", subTasks);
    model.addAttribute("task", task);
    model.addAttribute("currentTask", taskService.loadSingleTask(task.getTaskId()));
    return "subtask_manager";
  }
  //lavet af Jonathan
  @GetMapping("/deleteSubTask/{id}")
  public String deleteTask(@PathVariable("id") int id) {
    subTaskService.deleteSubTask(id);
    return "redirect:/showSubTask";
  }

  //lavet af Alexander
  @GetMapping("/goToEditSubtask/{subtaskID}")
  public String goToEditSubtask(Model model, @PathVariable("subtaskID") int subtaskID) {
    SubTask subTask = subTaskService.loadSingleSubtask(subtaskID);
    model.addAttribute("subtaskToEdit", subTask);
    model.addAttribute("subtaskID", subtaskID);
    return "edit_subtask";
  }
  //lavet af Alexander
  @PostMapping("/editSubtask")
  public String editSubtask(@ModelAttribute("editedSubtask") SubTask editedSubtask, @RequestParam("subtaskID") int subtaskID) throws ProjectExeption {
    subTaskService.editSubtask(editedSubtask, subtaskID);
    return "redirect:/showSubTask";
  }


}
