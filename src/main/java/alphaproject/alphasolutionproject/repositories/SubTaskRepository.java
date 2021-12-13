package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.SubTask;
import alphaproject.alphasolutionproject.domain.services.ProjectExeption;

public interface SubTaskRepository {
  SubTask createSubTask(SubTask subTask, int id) throws ProjectExeption;
  //ArrayList<SubTask> loadSubTasksByTaskID(int id);

}
