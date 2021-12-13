package alphaproject.alphasolutionproject.domain.services;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.repositories.ProjectRepository;
import alphaproject.alphasolutionproject.repositories.ProjectRepositoryImpl;
import alphaproject.alphasolutionproject.repositories.TaskRepositoryImpl;

import java.util.ArrayList;

public class ProjectService {
  private ProjectRepository projectRepository;
  private ProjectRepositoryImpl projectRepositoryImpl = new ProjectRepositoryImpl();

  //CalculatorService calculatorService = new CalculatorService();

  public ProjectService(ProjectRepository projectRepository){
    this.projectRepository = projectRepository;
  }
  public Project createNewProject(Project project, User user) throws ProjectExeption {
    return projectRepositoryImpl.createProject(project, user);
  }

  public void deleteProject(int id){
    projectRepositoryImpl.deleteProject(id);
  }

  public void editProject(Project project, int id) throws ProjectExeption {
    projectRepositoryImpl.editProject(project, id);
  }

  public ArrayList<Project> loadProjects(int id){
    return projectRepositoryImpl.loadProjects(id);
  }
  public Project loadSingleProject(int id){
    return projectRepositoryImpl.loadSingleProject(id);
  }

}
