package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;
import org.xml.sax.SAXException;

import java.sql.*;
import java.util.ArrayList;

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

  public ArrayList<Task> loadTasks(int id){
    ArrayList<Task> taskList = new ArrayList<>();
    try{
      Connection connection = DBManager.getConnection();
      String SQL = "select * from alphasolution.task where projectID_FK = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL);
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next()){
        Task task = new Task();
        task.setTaskName(resultSet.getString("taskname"));
        task.setTaskDescription(resultSet.getString("taskdescription"));
        task.setTaskTimeEstimate(resultSet.getString("tasktimeestimate"));
        task.setTaskId(resultSet.getInt("taskid"));
        taskList.add(task);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return taskList;
  }

  public void deleteTask(int id) {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "delete from alphasolution.task where taskid = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL);
      preparedStatement.setInt(1, id);
      preparedStatement.execute();

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }


    //Foreign Keys skal sættes op til lists i SQL-databse

/*
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

 */

}
