package br.com.apiWebQuest.Services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apiWebQuest.dto.PontuacaoDTO;
import br.com.apiWebQuest.model.UserModel;
import br.com.apiWebQuest.repository.IUserRepository;
import lombok.Data;

@Service
@Data
public class PontuacaoService {
 
    @Autowired
    IUserRepository repository;

    public List<UserModel> ranking(){
        return repository.findAll();
    }

    public List<PontuacaoDTO> listRanking() {
        List<UserModel> ranking = repository.findAll();
    
        if (ranking != null) {
            List<PontuacaoDTO> rankingDTO = ranking.stream()
                .map(user -> new PontuacaoDTO(user.getLogin(), user.getPontuacao()))
                .collect(Collectors.toList());
            return rankingDTO;
        } else {
            return Collections.emptyList();
        }
    }
}
