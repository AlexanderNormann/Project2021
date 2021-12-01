package alphaproject.alphasolutionproject.domain.services;

import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.repositories.UserRepository;

public class LoginService {
    private UserRepository userRepository;

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
}
