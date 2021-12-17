package alphaproject.alphasolutionproject.domain.model;
import java.util.ArrayList;

//Lavet af alle
public class Task {
  private String taskName;
  private String taskDescription;
  private int taskTimeEstimate;
  private int taskId;
  private ArrayList<SubTask> subTasks;

  public Task() {
  }

  public Task(int taskId) {
    this.taskId = taskId;
  }

  public Task(String tastName, String taskDescription, int taskTimeEstimate) {
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

  public int getTaskTimeEstimate() {
    return taskTimeEstimate;
  }

  public void setTaskTimeEstimate(int taskTimeEstimate) {
    this.taskTimeEstimate = taskTimeEstimate;
  }

  public int getTaskId() {
    return taskId;
  }

  public void setTaskId(int taskId) {
    this.taskId = taskId;

  }


}
