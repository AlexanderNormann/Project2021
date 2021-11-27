package alphaproject.alphasolutionproject.domain.model;

public class SubTask {

  private String subTaskName;
  private String subTaskDescription;
  private String subTaskTimeEstimate;
  private String subTaskListName;
  private String subTaskListDescription;
  private int subTaskListId;
  private int subTaskId;


  public SubTask() {
  }

  public SubTask(String subTaskName, String subTaskDescription, String subTaskTimeEstimate) {
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

  public String getSubTaskTimeEstimate() {
    return subTaskTimeEstimate;
  }

  public void setSubTaskTimeEstimate(String subTaskTimeEstimate) {
    this.subTaskTimeEstimate = subTaskTimeEstimate;
  }

  public int getSubTaskId(int id) {
    return subTaskId;
  }

  public String getSubTaskListName() {
    return subTaskListName;
  }

  public void setSubTaskListName(String subTaskListName) {
    this.subTaskListName = subTaskListName;
  }

  public String getSubTaskListDescription() {
    return subTaskListDescription;
  }

  public void setSubTaskListDescription(String subTaskListDescription) {
    this.subTaskListDescription = subTaskListDescription;
  }

  public int getSubTaskListId() {
    return subTaskListId;
  }

  public void setSubTaskListId(int subTaskListId) {
    this.subTaskListId = subTaskListId;
  }

  public void setSubTaskId(int subTaskId) {
    this.subTaskId = subTaskId;

  }
}
