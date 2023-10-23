package br.com.apiWebQuest.dto;

import org.springframework.stereotype.Service;

import br.com.apiWebQuest.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String login;
    private String password;

    UserDTO(UserModel userModel){
        login = userModel.getLogin();
        password = userModel.getPassword();
    }
}
