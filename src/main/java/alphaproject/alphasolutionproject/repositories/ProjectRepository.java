package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.ProjectExeption;

public interface ProjectRepository {
 // Project createProject();

  Project createProject(Project project, User user) throws ProjectExeption;
  //deleteProjct(); er det en service?
  //showProjectFromList(); er det en service?




}
