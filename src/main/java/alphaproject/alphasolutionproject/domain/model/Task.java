package alphaproject.alphasolutionproject.domain.model;

public class Task {
  private String taskName;
  private String taskDescription;
  private String taskTimeEstimate;
  private String taskListName;
  private String taskListDescription;
  private int taskListId;
  private int taskId;


  public Task() {
  }

  public Task(String tastName, String taskDescription, String taskTimeEstimate) {
    this.taskName = tastName;
    this.taskDescription = taskDescription;
    this.taskTimeEstimate = taskTimeEstimate;
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
