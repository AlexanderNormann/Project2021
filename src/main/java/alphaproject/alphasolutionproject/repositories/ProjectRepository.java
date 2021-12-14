package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.ProjectExeption;

import java.util.ArrayList;

public interface ProjectRepository {

  Project createProject(Project project, User user) throws ProjectExeption;

  Project loadSingleProject(int id);

  ArrayList<Project> loadProjects(int id);

  void deleteProject(int id);

  void editProject(Project project, int id) throws ProjectExeption;


}
