package br.com.apiWebQuest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apiWebQuest.Services.PontuacaoService;
import br.com.apiWebQuest.Services.ProvaService;
import br.com.apiWebQuest.dto.PontuacaoDTO;
import br.com.apiWebQuest.dto.ProvaDTO;

//localhost:8080/list/ranking
@RestController
@RequestMapping("/list")
public class UserController {
     
    @Autowired
    PontuacaoService pontuacaoService;

    @Autowired
    ProvaService provaService;

    @GetMapping("/ranking")
    public List<PontuacaoDTO> Ranking() {
        return pontuacaoService.listRanking();
    }

    @PutMapping("/sendQuest")
    public ResponseEntity sendQuest(@RequestBody ProvaDTO provaDTO){
    provaService.atualizarPontuacao(provaDTO);
        return ResponseEntity.ok().build();
    }
}
