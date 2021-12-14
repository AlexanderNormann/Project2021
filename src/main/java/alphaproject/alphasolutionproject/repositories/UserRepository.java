package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.ProjectExeption;

public interface UserRepository {
  User login(String email, String password) throws Exception;
  User createUser(User user) throws Exception;
  User loadSingleUser(int id);
  void editUser(User user, int id) throws ProjectExeption;

}
