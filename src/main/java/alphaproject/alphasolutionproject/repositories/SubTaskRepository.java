package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.SubTask;

public interface SubTaskRepository {
  SubTask createSubTask();
  SubTask addSubTaskToList();
}
