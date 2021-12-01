package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

public class UserRepositoryImpl implements UserRepository {

  @Override
  public User login(String email, String password) throws Exception {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "select userid from user " + "where email = ? and password = ?";
      PreparedStatement ps = connection.prepareStatement(SQL);
      ps.setString(1, email);
      ps.setString(2, password);
      ResultSet resultSet = ps.executeQuery();
      if (resultSet.next()) {
        int id = resultSet.getInt("userid");
        User user = new User(email, password);
        user.setUserId(id);
        return user;
      } else {
        throw new Exception("kunne ikke ikke login");
      }

    } catch (SQLException e) {
      throw new SampleExeption(e.getMessage());
    }

  }

  @Override
  public User createUser(User user) throws Exception {
    try{
      System.out.println(user.getAuthority());
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
    } catch (SQLException e){
      throw new Exception(e.getMessage());
    }
  }

  /*
  public ArrayList<User> displayFirstname(int id){
    ArrayList<User> listOfUser = new ArrayList<>();
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "select * from alphasolution.user + where userID_FK = ?";
      PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      ps.setInt(1, id);
      ResultSet rs= ps.executeQuery();

      while (rs.next()){
        User user= new User();
        user.setFirstName(rs.getString("Firstname"));
        user.setLastName(rs.getString("Lastname"));
        user.setEmail(rs.getString("Email"));
      }
    } catch (SQLException e){
      e.printStackTrace();

    }
    return listOfUser;
  } */

}

