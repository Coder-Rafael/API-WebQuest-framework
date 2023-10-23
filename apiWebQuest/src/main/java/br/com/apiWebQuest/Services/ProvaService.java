package br.com.apiWebQuest.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.apiWebQuest.dto.ProvaDTO;
import br.com.apiWebQuest.model.UserModel;
import br.com.apiWebQuest.repository.IUserRepository;
import br.com.apiWebQuest.security.TokenService;
import lombok.Data;

@Service
@Data
public class ProvaService {
    
    @Autowired
    IUserRepository repository;
    
    @Autowired
    TokenService tokenService;
    
    public void atualizarPontuacao(ProvaDTO provaDTO) {
        // Validar o token
        String token = provaDTO.getToken();
        String login = tokenService.validateToken(token);
        System.out.println("AQUI:"+token);
        System.out.println("AQUI:"+login);

        if (login != null) {
            // Recuperar o usuário pelo login
            UserDetails userDetails = repository.findByLogin(login);
            
            if (userDetails != null) {
                UserModel user = (UserModel) userDetails;
                // Atualizar a pontuação do usuário
                user.setPontuacao(provaDTO.getPontuacao());
                // Salvar o usuário atualizado no banco de dados
                repository.save(user);
            }
        }
    }
}