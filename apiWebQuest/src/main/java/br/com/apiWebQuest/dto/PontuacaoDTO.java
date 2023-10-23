package br.com.apiWebQuest.dto;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PontuacaoDTO {

    private String login;
    private Double pontuacao;
    
}
