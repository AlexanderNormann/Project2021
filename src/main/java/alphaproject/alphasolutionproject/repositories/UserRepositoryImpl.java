package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository

public class UserRepositoryImpl implements UserRepository {

  @Override
  public User login(String email, String password) throws Exception {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "select userid from users " + "where email = ? and password = ?";
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
      e.printStackTrace();
    }


    return null; //skal ikke være der?
  }

  @Override
  public User createUser(User user) throws Exception {
    try{
      Connection connection = DBManager.getConnection();
      String SQL = "insert into User (firstname, lastname, email, password) values (?, ?, ?, ?) ";
      PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, user.getFirstName());
      ps.setString(2, user.getLastName());
      ps.setString(3, user.getEmail());
      ps.setString(4, user.getPassword());
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
}

