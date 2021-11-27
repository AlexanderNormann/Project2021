package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;

public interface ProjectRepository {
 // Project createProject();

  Project createProject(Project project, User user) throws SampleExeption;

  //Project addProjetToList(Project project, User user) throws SampleExeption;

  //Foreign Keys skal sættes op til lists i SQL-databse
  Project addProjetToList(Project project) throws SampleExeption;
  //deleteProjct(); er det en service?
  //showProjectFromList(); er det en service?




}
