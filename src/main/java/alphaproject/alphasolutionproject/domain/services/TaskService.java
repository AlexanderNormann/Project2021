package alphaproject.alphasolutionproject.domain.services;

import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.repositories.TaskRepository;
import alphaproject.alphasolutionproject.repositories.TaskRepositoryImpl;

public class TaskService {

  private TaskRepository taskrepository;
  private TaskRepositoryImpl taskRepositoryImpl = new TaskRepositoryImpl();

  public TaskService(TaskRepository taskrepository){
    this.taskrepository = taskrepository;
  }

  public Task createNewTask(Task task, User user) throws SampleExeption{
    return taskRepositoryImpl.createTask(task, user);
  }
}
