package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.ProjectExeption;

import java.sql.*;


public class UserRepositoryImpl implements UserRepository {

 //lavet af Jonathan
  @Override
  public User login(String email, String password) throws ProjectExeption {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "select userid from user " + "where email = ? and password = ?";
      PreparedStatement ps = connection.prepareStatement(SQL);
      ps.setString(1, email);
      ps.setString(2, password);
      ResultSet resultSet = ps.executeQuery();
      if (resultSet.next()) {
        int id = resultSet.getInt("userid");
        User user = new User(email, password, id);
        user.setUserId(id);
        return user;
      } else {
        throw new ProjectExeption("kunne ikke ikke login");
      }

    } catch (SQLException e) {
      throw new ProjectExeption(e.getMessage());
    }

  }
  //lavet af Alexander
  @Override
  public User createUser(User user) throws ProjectExeption {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "insert into User (firstname, lastname, email, password, role) values (?, ?, ?, ?, ?) ";
      PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, user.getFirstName());
      ps.setString(2, user.getLastName());
      ps.setString(3, user.getEmail());
      ps.setString(4, user.getPassword());
      ps.setString(5, String.valueOf(user.getAuthority()));
      ps.executeUpdate();
      ResultSet rs = ps.getGeneratedKeys();
      rs.next();
      int id = rs.getInt(1);
      user.setUserId(id);
      return user;
    } catch (SQLException e) {
      throw new ProjectExeption(e.getMessage());
    }
  }

  //lavet af Nicklas
  public User loadSingleUser(int id) {
    User user = new User();
    try {

      Connection connection = DBManager.getConnection();
      String SQL = "select * from heroku_8c82ce867ddf156.user where userid = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL);
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        user.setUserId(resultSet.getInt("userid"));
        user.setFirstName(resultSet.getString("firstname"));
        user.setLastName(resultSet.getString("lastname"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("email"));
        user.setAuthority(resultSet.getBoolean("role"));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return user;
  }

  //lavet af Nicklas
  public void editUser(User user, int id) throws ProjectExeption {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "UPDATE heroku_8c82ce867ddf156.user SET firstname = ?, lastname = ?, email = ?, password = ? WHERE (userid = ?);";
      PreparedStatement ps = connection.prepareStatement(SQL);
      ps.setString(1, user.getFirstName());
      ps.setString(2, user.getLastName());
      ps.setString(3, user.getEmail());
      ps.setString(4, user.getPassword());
      ps.setInt(5, id);
      ps.execute();
    } catch (SQLException e) {
      throw new ProjectExeption(e.getMessage());
    }
  }
}

