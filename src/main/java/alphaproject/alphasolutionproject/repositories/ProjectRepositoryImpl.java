package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.ProjectExeption;
import java.sql.*;
import java.util.ArrayList;

public class ProjectRepositoryImpl implements ProjectRepository{



  @Override
  public Project createProject(Project project, User user) throws ProjectExeption {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "insert into Project(projectname, projectdescription, userID_FK) values (?,?,?)"; //Foreign Keys skal skrives ind
      PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, project.getProjectName());
      ps.setString(2,project.getProjectDescription());
      ps.setInt(3, user.getUserId());
      ps.execute();
      ResultSet rs = ps.getGeneratedKeys();
      rs.next();
      int id = rs.getInt(1);
      project.setProjectId(id);
      return project;
    } catch (SQLException e){
      throw new ProjectExeption(e.getMessage());
    }
  }




  public ArrayList<Project> loadProjects(int id){
    ArrayList<Project> projectList = new ArrayList<>();
    try{
      Connection connection = DBManager.getConnection();
      String SQL = "select * from heroku_8c82ce867ddf156.project where userID_FK = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL);
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next()){
        Project project = new Project();
        project.setProjectName(resultSet.getString("projectname"));
        project.setProjectDescription(resultSet.getString("projectdescription"));
        project.setProjectId(resultSet.getInt("projectid"));
        projectList.add(project);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return projectList;
  }
  public Project loadSingleProject(int id){
    Project project = new Project();
    try{

      Connection connection = DBManager.getConnection();
      String SQL = "select * from heroku_8c82ce867ddf156.project where projectid = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL);
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next()){
        project.setProjectId(resultSet.getInt("projectid"));
        project.setProjectName(resultSet.getString("projectname"));
        project.setProjectDescription(resultSet.getString("projectdescription"));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return project;
  }

  public void editProject(Project project, int id) throws ProjectExeption {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "UPDATE heroku_8c82ce867ddf156.project SET projectname = ?, projectdescription = ? WHERE (projectid = ?);";
      PreparedStatement ps = connection.prepareStatement(SQL);
      ps.setString(1, project.getProjectName());
      ps.setString(2, project.getProjectDescription());
      ps.setInt(3, id);
      ps.execute();
    } catch (SQLException e) {
      throw new ProjectExeption(e.getMessage());
    }
  }

  public void deleteProject(int id){
    try{
      Connection connection = DBManager.getConnection();
      String SQL = "delete from heroku_8c82ce867ddf156.project where projectid = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL);
      preparedStatement.setInt(1, id);
      preparedStatement.execute();

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }




}
