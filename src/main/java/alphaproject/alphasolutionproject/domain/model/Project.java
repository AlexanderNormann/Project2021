package alphaproject.alphasolutionproject.domain.model;

public class Project {

  private String projectName;
  private String projectDescription;
  private int projectTimeEstimate;
  private int projectId;

  public Project() {
  }

  public Project(int id) {
    this.projectId = id;
  }

  public Project(String projectName, String projectDescription, int projectTimeEstimate) {
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

  public int getProjectTimeEstimate() {
    return projectTimeEstimate;
  }

  public void setProjectTimeEstimate(int projectTimeEstimate) {
    this.projectTimeEstimate = projectTimeEstimate;
  }

  public int getProjectId() {
    return projectId;
  }

  public void setProjectId(int projectId) {
    this.projectId = projectId;
  }

}
