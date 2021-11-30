package alphaproject.alphasolutionproject.domain.services;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.repositories.ProjectRepository;
import alphaproject.alphasolutionproject.repositories.ProjectRepositoryImpl;

import java.util.ArrayList;

public class ProjectService {
  private ProjectRepository projectRepository;
  private ProjectRepositoryImpl projectRepositoryImpl = new ProjectRepositoryImpl();

  public ProjectService(ProjectRepository projectRepository){
    this.projectRepository = projectRepository;
  }

  public Project createNewProject(Project project, User user) throws SampleExeption {
    return projectRepositoryImpl.createProject(project, user);
  }

  public Project addProjectToList(Project project, User user) throws SampleExeption {
    return null;
  }

  public ArrayList<Project> showProjects(int id){
  return projectRepositoryImpl.showProjects(id);
  }


  public Project addProject(Project project, User user){
    return null;
  }

  /*public Project saveProject(Project project, User user){
    return projectReposi
  }

   */
}
