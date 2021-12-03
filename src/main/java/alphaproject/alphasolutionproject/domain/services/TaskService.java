package alphaproject.alphasolutionproject.domain.services;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.repositories.TaskRepository;
import alphaproject.alphasolutionproject.repositories.TaskRepositoryImpl;

import java.util.ArrayList;

public class TaskService {

  private TaskRepository taskrepository;
  private TaskRepositoryImpl taskRepositoryImpl = new TaskRepositoryImpl();

  public TaskService(TaskRepository taskrepository){
    this.taskrepository = taskrepository;
  }

  public Task createNewTask(Task task, int id) throws SampleExeption{
    return taskRepositoryImpl.createTask(task, id);
  }

  public void deleteTask(int id){
    taskRepositoryImpl.deleteTask(id);
  }

  public ArrayList<Task> loadProjectTasks(int id){
    return taskRepositoryImpl.loadTasks(id);
  }
}
