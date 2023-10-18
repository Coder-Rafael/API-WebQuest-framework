package br.com.apiWebQuest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apiWebQuest.Services.QuestaoService;
import br.com.apiWebQuest.model.QuestaoModel;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {

    @Autowired
    QuestaoService service;
    
    @PostMapping("/salvar")
    public void salvar(@RequestBody QuestaoModel questao){
        System.out.println("cehgo8 nop conrtorler");
        service.salvarQuestao(questao);   
    }
}
