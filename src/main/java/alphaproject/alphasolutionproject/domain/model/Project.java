package alphaproject.alphasolutionproject.domain.model;

public class Project {

  private String projectName;
  private String projectDescription;
  private String projectTimeEstimate;
  private String projectListName;
  private String projectListDescription;
  private int projectListId;
  private int projectId;

  public Project() {
  }

  public Project(int id){
    this.projectId = id;
  }

  public Project(String projectName, String projectDescription, String projectTimeEstimate) {
    this.projectName = projectName;
    this.projectDescription = projectDescription;
    this.projectTimeEstimate = projectTimeEstimate;
  }



  public String getProjectName() {
    return projectName;
  }
  public String getProjectName(Project project) {
    return project.getProjectName();
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getProjectDescription() {
    return projectDescription;
  }

  public void setProjectDescription(String projectDescription) {
    this.projectDescription = projectDescription;
  }

  public String getProjectTimeEstimate() {
    return projectTimeEstimate;
  }

  public void setProjectTimeEstimate(String projectTimeEstimate) {
    this.projectTimeEstimate = projectTimeEstimate;
  }

  public int getProjectId() {
    return projectId;
  }

  public void setProjectId(int projectId) {
    this.projectId = projectId;
  }

  public String getProjectListName() {
    return projectListName;
  }

  public void setProjectListName(String projectListName) {
    this.projectListName = projectListName;
  }

  public String getProjectListDescription() {
    return projectListDescription;
  }

  public void setProjectListDescription(String projectListDescription) {
    this.projectListDescription = projectListDescription;
  }

  public int getProjectListId() {
    return projectListId;
  }

  public void setProjectListId(int projectListId) {
    this.projectListId = projectListId;
  }
}
