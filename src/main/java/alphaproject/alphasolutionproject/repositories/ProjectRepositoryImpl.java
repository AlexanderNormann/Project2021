package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.ArrayList;

public class ProjectRepositoryImpl implements ProjectRepository{



  @Override
  public Project createProject(Project project, User user) throws SampleExeption {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "insert into Project(projectname, projectdescription, projecttimeestimate, userID_FK) values (?,?,?,?)"; //Foreign Keys skal skrives ind
      PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, project.getProjectName());
      ps.setString(2,project.getProjectDescription());
      ps.setString(3, project.getProjectTimeEstimate());
      ps.setInt(4, user.getUserId());
      ps.execute();
      ResultSet rs = ps.getGeneratedKeys();
      rs.next();
      int id = rs.getInt(1);
      project.setProjectId(id);
      return project;
    } catch (SQLException e){
      throw new SampleExeption(e.getMessage());
    }
  }


  //Foreign Keys skal sættes op til lists i SQL-databse
  @Override
  public Project addProjectToList(Project project, User user) throws SampleExeption{
    try{
      Connection connection = DBManager.getConnection();
      String SQL = "insert into project(projecktname, projectdescription, projecttimeestimate, userID_FK) values (?,?,?,?)";
      PreparedStatement ps = connection.prepareStatement(SQL);
      ps.setString(1, project.getProjectName() );
      ps.setString(2, project.getProjectDescription());
      ps.setString(3,project.getProjectTimeEstimate());
      ps.setInt(4, user.getUserId());
      //getprojecetid
      ps.execute();
      return null;
    } catch (SQLException e){
      throw new SampleExeption(e.getMessage());
    }
  }

  public ArrayList<Project> loadProjects(int id){
    ArrayList<Project> projectList = new ArrayList<>();
    try{
      Connection connection = DBManager.getConnection();
      String SQL = "select * from alphasolutions.project where userID_FK = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL);
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next()){
        Project project = new Project();
        project.setProjectName(resultSet.getString("projectname"));
        project.setProjectDescription(resultSet.getString("projectdescription"));
        project.setProjectTimeEstimate(resultSet.getString("projecttimeestimate"));
        project.setProjectId(resultSet.getInt("projectid"));
        projectList.add(project);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return projectList;
  }

  public ArrayList<Project> showProjects(int id){
    ArrayList<Project> listOfProjects = new ArrayList<>();
    try {
    Connection connection = DBManager.getConnection();
    String SQL = "select * from alphasolutions.project" + "where userid_FK = ?";
    PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1, id);
    ResultSet rs= ps.executeQuery();

    while (rs.next()){
    Project project = new Project();
    project.setProjectName(rs.getString("projectname"));
    project.setProjectDescription(rs.getString("projectdescription"));
    project.setProjectTimeEstimate(rs.getString("projecttimeestimate"));
    }
    } catch (SQLException e){
      e.printStackTrace();

    }
    return listOfProjects;
  }

  public void deleteProject(int id){
    try{
      Connection connection = DBManager.getConnection();
      String SQL = "delete from alphasolutions.project where projectid = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL);
      preparedStatement.setInt(1, id);
      preparedStatement.execute();

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }


}
