package alphaproject.alphasolutionproject.domain.services;

import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.repositories.UserRepository;

import java.util.ArrayList;

public class LoginService {
    private UserRepository userRepository;
    private UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();

    public LoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

public User login(String email, String password) throws Exception {
return userRepository.login(email, password);
}

public User createUser(String firstname, String lastname, String email, String password, boolean authority) throws Exception {
User user = new User(firstname, lastname, email, password, authority);
return userRepository.createUser(user);
}
/*
public ArrayList<User> displayFirstname(int id){
return userRepositoryImpl.displayFirstname(id);
}
 */

}
