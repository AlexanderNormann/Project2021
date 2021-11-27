package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;

import java.sql.SQLException;

public interface Taskrepository {
  Task createTask(Task task) throws SampleExeption;
  Task addTaskToProject(Task task) throws SQLException, SampleExeption;


}
