package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;
import org.xml.sax.SAXException;

import java.sql.*;

public class TaskRepositoryImpl implements TaskRepository {
  @Override
  public Task createTask(Task task, User user, Project project) throws SampleExeption {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "insert into Task(taskname, taskdescription, tasktimeestimate, projectID_FK) values (?,?,?,?)";
      PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, task.getTaskName());
      ps.setString(2, task.getTaskDescription());
      ps.setString(3, task.getTaskTimeEstimate());
      ps.setInt(4, project.getProjectId());
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
  public Task addTaskToProject(Task task, Project project) throws SQLException, SampleExeption {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "insert into task(tastname, taskdescription, projectID_FK) values (?,?,?)";
      PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, task.getTaskName());
      ps.setString(2, task.getTaskDescription());
      ps.setInt(3, project.getProjectId());
      //gettasklistid
      ps.execute();
      return null;

    } catch (SQLException e) {
      throw new SampleExeption(e.getMessage());
    }
  }
}
