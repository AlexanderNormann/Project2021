package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.SubTask;
import alphaproject.alphasolutionproject.domain.services.ProjectExeption;

import java.sql.*;
import java.util.ArrayList;

public class SubTaskRespositoryImpl implements SubTaskRepository{

  @Override
  public SubTask createSubTask(SubTask subTask, int id) throws ProjectExeption {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "insert into Subtask(subtaskname, subtaskdescription, subtasktimeestimate, taskID_FK) values (?,?,?,?)";
      PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, subTask.getSubTaskName());
      ps.setString(2, subTask.getSubTaskDescription());
      ps.setInt(3, subTask.getSubTaskTimeEstimate());
      ps.setInt(4, id);
      ps.execute();
      ResultSet rs = ps.getGeneratedKeys();
      rs.next();
      int subTaskid = rs.getInt(1);
      subTask.getSubTaskId(subTaskid);
      return subTask;
    } catch (SQLException e) {
      throw new ProjectExeption(e.getMessage());
    }
  }

  public ArrayList<SubTask> loadSubTasksByTaskID(int id){
    ArrayList<SubTask> subTaskList = new ArrayList<>();
    try{
      Connection connection = DBManager.getConnection();
      String SQL = "select * from alphasolution.subtask where taskID_FK = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL);
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next()){
        SubTask subTask = new SubTask();
        subTask.setSubTaskName(resultSet.getString("subtaskname"));
        subTask.setSubTaskDescription(resultSet.getString("subtaskdescription"));
        subTask.setSubTaskTimeEstimate(resultSet.getInt("subtasktimeestimate"));
        subTask.setSubTaskId(resultSet.getInt("subtaskid"));
        subTaskList.add(subTask);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return subTaskList;
  }

  public SubTask loadSingleSubtask(int id){
    SubTask subTask = new SubTask();
    try{

      Connection connection = DBManager.getConnection();
      String SQL = "select * from alphasolution.subtask where subtaskid = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL);
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next()){
        subTask.setSubTaskId(resultSet.getInt("subtaskid"));
        subTask.setSubTaskName(resultSet.getString("subtaskname"));
        subTask.setSubTaskDescription(resultSet.getString("subtaskdescription"));
        subTask.setSubTaskTimeEstimate(resultSet.getInt("subtasktimeestimate"));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return subTask;
  }

  public void editSubtask(SubTask subTask, int id) throws ProjectExeption {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "UPDATE alphasolution.subtask SET subtaskname = ?, subtaskdescription = ?, subtasktimeestimate = ? WHERE (subtaskid = ?);";
      PreparedStatement ps = connection.prepareStatement(SQL);
      ps.setString(1, subTask.getSubTaskName());
      ps.setString(2, subTask.getSubTaskDescription());
      ps.setInt(3, subTask.getSubTaskTimeEstimate());
      ps.setInt(4, id);
      ps.execute();
    } catch (SQLException e) {
      throw new ProjectExeption(e.getMessage());
    }
  }

  public void deleteSubTask(int id) {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "delete from alphasolution.subtask where subtaskid = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL);
      preparedStatement.setInt(1, id);
      preparedStatement.execute();

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }




}
