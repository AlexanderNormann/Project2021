package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.SubTask;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;

import java.sql.*;

public class SubTaskRespositoryImpl implements SubTaskRepository{

  @Override
  public SubTask createSubTask(SubTask subTask, int id) throws SampleExeption {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "insert into Subtask(subtaskname, subtaskdescription, subtasktimeestimate, taskID_FK) values (?,?,?,?)";
      PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, subTask.getSubTaskName());
      ps.setString(2, subTask.getSubTaskDescription());
      ps.setString(3, subTask.getSubTaskTimeEstimate());
      ps.setInt(4, id);
      ps.execute();
      ResultSet rs = ps.getGeneratedKeys();
      rs.next();
      int subTaskid = rs.getInt(1);
      subTask.getSubTaskId(subTaskid);
      return subTask;
    } catch (SQLException e) {
      throw new SampleExeption(e.getMessage());
    }
  }
}
