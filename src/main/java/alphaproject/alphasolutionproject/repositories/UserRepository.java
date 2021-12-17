package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.domain.services.ProjectExeption;

public interface UserRepository {
  User login(String email, String password) throws ProjectExeption;

  User createUser(User user) throws ProjectExeption;

  User loadSingleUser(int id);

  void editUser(User user, int id) throws ProjectExeption;

}
