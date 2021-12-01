package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.SubTask;
import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;

import java.sql.*;

public class SubTaskRespositoryImpl implements SubTaskRepository{

  @Override
  public SubTask createSubTask(SubTask subTask, User user) throws SampleExeption {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "insert into Subtask(subtaskname, subtaskdescription, subtasktimeestimate) values (?,?,?)";
      PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, subTask.getSubTaskName());
      ps.setString(2, subTask.getSubTaskDescription());
      ps.setString(3, subTask.getSubTaskTimeEstimate());
      ps.execute();
      ResultSet rs = ps.getGeneratedKeys();
      rs.next();
      int id = rs.getInt(1);
      subTask.getSubTaskId(id);
      return subTask;
    } catch (SQLException e) {
      throw new SampleExeption(e.getMessage());
    }
  }

  //Foreign Keys skal sættes op til lists i SQL-databse

  @Override
  public SubTask addSubTaskToList(SubTask subTask) throws SQLException, SampleExeption {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "subtask(subtaskname, subtaskdescription) values (?,?)";
      PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, subTask.getSubTaskName());
      ps.setString(2, subTask.getSubTaskDescription());
      //gettasklistid
      ps.execute();
      return null;

    } catch (SQLException e) {
      throw new SampleExeption(e.getMessage());
    }
  }
}
