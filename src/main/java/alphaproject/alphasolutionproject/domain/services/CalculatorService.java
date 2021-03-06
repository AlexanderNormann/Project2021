package alphaproject.alphasolutionproject.domain.services;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.SubTask;
import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.model.User;

import java.util.ArrayList;

public class CalculatorService {
  private ProjectService projectService = new ProjectService();
  private SubTaskService subTaskService = new SubTaskService();
  private TaskService taskService = new TaskService();

  //lavet af Nicklas
  public ArrayList<Project> calcTotalProjectTimeAndCost(User user) {

    ArrayList<Project> projectList = projectService.loadProjects(user.getUserId());

    for (Project p : projectList) {
      p.setProjectTimeEstimate(totalSubtaskTimeForProject(p));
      p.setProjectTotalPrice(p.getProjectHourlyRate() * totalSubtaskTimeForProject(p));
    }
    return projectList;
  }
  //lavet af Nicklas
  public int totalSubtaskTimeForProject(Project project) {
    ArrayList<Task> tempTaskList = taskService.loadProjectTasks(project.getProjectId());
    int totalProjectTime = 0;

    for (Task t : tempTaskList) {
      ArrayList<SubTask> tempSubtaskList = subTaskService.loadSubTasksByTaskID(t.getTaskId());
      for (SubTask st : tempSubtaskList) {
        totalProjectTime += st.getSubTaskTimeEstimate();
      }
    }
    return totalProjectTime;
  }
  //lavet af Nicklas
  public ArrayList<Task> calcTotalTaskTime(Project project) {

    ArrayList<Task> taskList = taskService.loadProjectTasks(project.getProjectId());

    for (Task t : taskList) {
      t.setTaskTimeEstimate(totalSubtaskTimeForTask(t));
    }
    return taskList;
  }
  //Lavet af Nicklas
  public int totalSubtaskTimeForTask(Task task) {
    ArrayList<SubTask> tempSubtaskList = subTaskService.loadSubTasksByTaskID(task.getTaskId());
    int totalTaskTime = 0;

    for (SubTask stList : tempSubtaskList) {
      totalTaskTime += stList.getSubTaskTimeEstimate();

    }
    return totalTaskTime;
  }
}
