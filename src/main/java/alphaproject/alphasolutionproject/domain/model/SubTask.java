package alphaproject.alphasolutionproject.domain.model;

import alphaproject.alphasolutionproject.domain.services.SubTaskService;
import alphaproject.alphasolutionproject.domain.services.TaskService;
import alphaproject.alphasolutionproject.repositories.SubTaskRespositoryImpl;
import alphaproject.alphasolutionproject.repositories.TaskRepositoryImpl;

import java.util.ArrayList;

public class SubTask {

  private String subTaskName;
  private String subTaskDescription;
  private int subTaskTimeEstimate;
  private int subTaskId;
  private TaskService taskService = new TaskService(new TaskRepositoryImpl());
  private SubTaskService subTaskService = new SubTaskService(new SubTaskRespositoryImpl());

  @Override
  public String toString() {
    return "Name: " + subTaskName + "\n " +
        "Description: " + subTaskDescription + " " +
        "Time estimate: " + subTaskTimeEstimate + "";
  }

  public SubTask() {
  }

  public SubTask(String subTaskName, String subTaskDescription, int subTaskTimeEstimate) {
    this.subTaskName = subTaskName;
    this.subTaskDescription = subTaskDescription;
    this.subTaskTimeEstimate = subTaskTimeEstimate;
  }

  public String getSubTaskName() {
    return subTaskName;
  }

  public void setSubTaskName(String subTaskName) {
    this.subTaskName = subTaskName;
  }

  public String getSubTaskDescription() {
    return subTaskDescription;
  }

  public void setSubTaskDescription(String subTaskDescription) {
    this.subTaskDescription = subTaskDescription;
  }

  public int getSubTaskTimeEstimate() {
    return subTaskTimeEstimate;
  }

  public void setSubTaskTimeEstimate(int subTaskTimeEstimate) {
    this.subTaskTimeEstimate = subTaskTimeEstimate;
  }

  public int getSubTaskId(int id) {
    return subTaskId;
  }

  public void setSubTaskId(int subTaskId) {
    this.subTaskId = subTaskId;

  }

  public int getSubTaskId() {
    return subTaskId;
  }


}
