package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;
import org.xml.sax.SAXException;

import java.sql.*;

public class TaskRepositoryImpl implements TaskRepository {
  @Override
  public Task createTask(Task task, int id) throws SampleExeption {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "insert into Task(taskname, taskdescription, tasktimeestimate, projectID_FK) values (?,?,?,?)";
      PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, task.getTaskName());
      ps.setString(2, task.getTaskDescription());
      ps.setString(3, task.getTaskTimeEstimate());
      ps.setInt(4, id);
      ps.execute();
      ResultSet rs = ps.getGeneratedKeys();
      rs.next();
      int taskid = rs.getInt(1);
      task.setTaskId(taskid);
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
      String SQL = "insert into task(taskname, taskdescription, projectID_FK) values (?,?,?)";
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
