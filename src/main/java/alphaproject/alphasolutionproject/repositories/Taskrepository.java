package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;

import java.sql.SQLException;

public interface TaskRepository {
  Task createTask(Task task, User user) throws SampleExeption;
  Task addTaskToProject(Task task) throws SQLException, SampleExeption;
  }

