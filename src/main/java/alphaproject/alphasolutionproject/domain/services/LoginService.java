package alphaproject.alphasolutionproject.domain.services;

import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.repositories.UserRepository;
import alphaproject.alphasolutionproject.repositories.UserRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private UserRepository userRepository;

    public LoginService(UserRepositoryImpl userRepository){
        this.userRepository = userRepository;
    }

public User login(String email, String password) throws Exception {
return userRepository.login(email, password);
}

public User createUser(String firstname, String lastname, String email, String password) throws Exception {
User user = new User(firstname, lastname, email, password);
return userRepository.createUser(user);
}
}
