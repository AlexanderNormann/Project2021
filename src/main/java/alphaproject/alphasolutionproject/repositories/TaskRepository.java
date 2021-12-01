package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;

import java.sql.SQLException;

public interface TaskRepository {
  Task createTask(Task task, int id) throws SampleExeption;
  Task addTaskToProject(Task task, Project project) throws SQLException, SampleExeption;
}

