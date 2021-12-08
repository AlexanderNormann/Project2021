package alphaproject.alphasolutionproject.domain.services;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.SubTask;
import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.repositories.ProjectRepositoryImpl;
import alphaproject.alphasolutionproject.repositories.SubTaskRespositoryImpl;
import alphaproject.alphasolutionproject.repositories.TaskRepositoryImpl;


import java.util.ArrayList;

public class CalculatorService {
  //private CalculatorService calculatorService = new CalculatorService();
  private TaskService taskService = new TaskService(new TaskRepositoryImpl());
  private SubTaskService subTaskService = new SubTaskService(new SubTaskRespositoryImpl());
  private ProjectService projectService = new ProjectService(new ProjectRepositoryImpl());

  //public CalculatorService calculatorService = new CalculatorService();

  /*public CalculatorService(CalculatorRepositoryImpl calculatorRepository) {
    this.calculatorRepositoryImpl = calculatorRepository;
  }

   */

  public ArrayList<Project> calculateTotalTime(User user){

      ArrayList<Project> projectList = projectService.loadProjects(user.getUserId());

      for(Project p : projectList){
        p.setProjectTimeEstimate(totalSubtaskTime(p));

       }
      return projectList;
    }

    public int totalSubtaskTime(Project project) {
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


}
