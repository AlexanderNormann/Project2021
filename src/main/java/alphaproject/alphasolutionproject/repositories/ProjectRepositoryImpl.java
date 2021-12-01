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
  public Project addProjetToList(Project project) throws SampleExeption{
    try{
      Connection connection = DBManager.getConnection();
      String SQL = "insert into projectlist(projecktlistname, projectlistdescription) values (?,?)";
      PreparedStatement ps = connection.prepareStatement(SQL);
      ps.setString(1, project.getProjectListName() );
      ps.setString(2, project.getProjectListDescription());
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

}
