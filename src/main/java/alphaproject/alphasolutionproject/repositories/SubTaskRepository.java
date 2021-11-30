package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.SubTask;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;

import java.sql.SQLException;

public interface SubTaskRepository {
  SubTask createSubTask(SubTask subTask, User user) throws SampleExeption;
  SubTask addSubTaskToList(SubTask subTask) throws SQLException, SampleExeption;
}
