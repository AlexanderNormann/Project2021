package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;
import org.xml.sax.SAXException;

import java.sql.*;

public class TaskRepositoryImpl implements TaskRepository {
  @Override
  public Task createTask(Task task, User user) throws SampleExeption {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "insert into Task(taskname, taskdescription, tasktimeestimate) values (?,?,?)";
      PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, task.getTaskName());
      ps.setString(2, task.getTaskDescription());
      ps.setString(3, task.getTaskTimeEstimate());
      ps.execute();
      ResultSet rs = ps.getGeneratedKeys();
      rs.next();
      int id = rs.getInt(1);
      task.setTaskId(id);
      return task;
    } catch (SQLException e) {
      throw new SampleExeption(e.getMessage());
    }
  }


  //Foreign Keys skal sættes op til lists i SQL-databse

  @Override
  public Task addTaskToProject(Task task) throws SQLException, SampleExeption {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "tasklist(tasklistname, tasklistdescription) values (?,?)";
      PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, task.getTaskListName());
      ps.setString(2, task.getTaskListDescription());
      //gettasklistid
      ps.execute();
      return null;

    } catch (SQLException e) {
      throw new SampleExeption(e.getMessage());
    }
  }
}
