package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.User;

public interface UserRepository {
  User login(String email, String password) throws Exception;
  User createUser(User user) throws Exception;
}
