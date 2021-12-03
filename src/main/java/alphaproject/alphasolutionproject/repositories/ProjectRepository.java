package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;

public interface ProjectRepository {
 // Project createProject();

  Project createProject(Project project, User user) throws SampleExeption;
  //deleteProjct(); er det en service?
  //showProjectFromList(); er det en service?




}
