package br.com.apiWebQuest.dto;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvaDTO {
    
    private String token;
    private Double pontuacao;
}
