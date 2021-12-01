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


  public ArrayList<Project> showProjects(int id){
    ArrayList<Project> listOfProjects = new ArrayList<>();
    try {
    Connection connection = DBManager.getConnection();
    String SQL = "select * from alphasolution.project" + "where userid_FK = ?";
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


}
