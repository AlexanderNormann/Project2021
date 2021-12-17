package alphaproject.alphasolutionproject.domain.services;

import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.repositories.TaskRepository;
import alphaproject.alphasolutionproject.repositories.TaskRepositoryImpl;

import java.util.ArrayList;

public class TaskService {

  private TaskRepository taskrepository;
  private TaskRepositoryImpl taskRepositoryImpl = new TaskRepositoryImpl();


  public TaskService(TaskRepository taskrepository) {
    this.taskrepository = taskrepository;
  }

  public TaskService() {
  }


  public Task createNewTask(Task task, int id) throws ProjectExeption {
    return taskRepositoryImpl.createTask(task, id);
  }

  public void editTask(Task task, int id) throws ProjectExeption {
    taskRepositoryImpl.editTask(task, id);
  }

  public void deleteTask(int id) {
    taskRepositoryImpl.deleteTask(id);
  }

  public ArrayList<Task> loadProjectTasks(int id) {
    return taskRepositoryImpl.loadTasks(id);
  }

  public Task loadSingleTask(int id) {
    return taskRepositoryImpl.loadSingleTask(id);
  }


}
