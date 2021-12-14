package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.services.ProjectExeption;

import java.util.ArrayList;

public interface TaskRepository {
  Task createTask(Task task, int id) throws ProjectExeption;
  ArrayList<Task> loadTasks(int id);
  Task loadSingleTask(int id);
  void editTask(Task task, int id) throws ProjectExeption;
  void deleteTask(int id);


}

