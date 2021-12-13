package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.services.ProjectExeption;

public interface TaskRepository {
  Task createTask(Task task, int id) throws ProjectExeption;
}

