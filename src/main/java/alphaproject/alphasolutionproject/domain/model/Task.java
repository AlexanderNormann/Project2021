package alphaproject.alphasolutionproject.domain.model;

import java.util.ArrayList;

public class Task {
  private String taskName;
  private String taskDescription;
  private String taskTimeEstimate;
  private String taskListName;
  private String taskListDescription;
  private int taskListId;
  private int taskId;
  private ArrayList<SubTask> subTasks;


  public Task() {
  }

  public Task(int taskId){
    this.taskId = taskId;
  }

  public Task(String tastName, String taskDescription, String taskTimeEstimate) {
    this.taskName = tastName;
    this.taskDescription = taskDescription;
    this.taskTimeEstimate = taskTimeEstimate;
  }

  public ArrayList<SubTask> getSubTasks() {
    return subTasks;
  }

  public void setSubTasks(ArrayList<SubTask> subTasks) {
    this.subTasks = subTasks;
  }

  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public String getTaskDescription() {
    return taskDescription;
  }

  public void setTaskDescription(String taskDescription) {
    this.taskDescription = taskDescription;
  }

  public String getTaskTimeEstimate() {
    return taskTimeEstimate;
  }

  public void setTaskTimeEstimate(String taskTimeEstimate) {
    this.taskTimeEstimate = taskTimeEstimate;
  }

  public int getTaskId() {
    return taskId;
  }

  public String getTaskListName() {
    return taskListName;
  }

  public void setTaskListName(String taskListName) {
    this.taskListName = taskListName;
  }

  public String getTaskListDescription() {
    return taskListDescription;
  }

  public void setTaskListDescription(String taskListDescription) {
    this.taskListDescription = taskListDescription;
  }

  public int getTaskListId() {
    return taskListId;
  }

  public void setTaskListId(int taskListId) {
    this.taskListId = taskListId;
  }

  public void setTaskId(int taskId) {
    this.taskId = taskId;

  }
}
