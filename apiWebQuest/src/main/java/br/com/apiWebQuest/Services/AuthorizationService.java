package br.com.apiWebQuest.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.apiWebQuest.dto.UserDTO;
import br.com.apiWebQuest.model.UserModel;
import br.com.apiWebQuest.repository.IUserRepository;

@Service
public class AuthorizationService implements UserDetailsService{

    @Autowired
    IUserRepository repository;

    public UserModel save(UserDTO userDTO){
        // Converter UserDTO para UserModel
        UserModel userModel = new UserModel();
        userModel.setLogin(userDTO.getLogin());
        userModel.setPassword(userDTO.getPassword());
        
        userModel = repository.save(userModel);
        return userModel;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }
    
}
