package br.com.apiWebQuest.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apiWebQuest.model.QuestaoModel;
import br.com.apiWebQuest.repository.QuestaoRepository;

@Service
public class QuestaoService {
    
    @Autowired
    QuestaoRepository repository;

   
}
