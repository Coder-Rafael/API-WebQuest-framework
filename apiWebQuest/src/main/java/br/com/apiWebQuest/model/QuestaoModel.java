package br.com.apiWebQuest.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity(name = "questao")
@Data
public class QuestaoModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "idQuestao")
    private UUID idQuestao;
    @Column(name = "pergunta")
    private String pergunta;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AlternativaModel> alternativas;
}
