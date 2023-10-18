package br.com.apiWebQuest.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apiWebQuest.model.QuestaoModel;

public interface QuestaoRepository extends JpaRepository<QuestaoModel, UUID>{
    
}
