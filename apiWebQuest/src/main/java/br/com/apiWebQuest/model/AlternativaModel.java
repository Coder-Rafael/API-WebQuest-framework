package br.com.apiWebQuest.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity(name = "alternativa")
@Data
public class AlternativaModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID idAlternativa;

    @ManyToOne
    @JoinColumn(name = "questaoRelacional", referencedColumnName = "idQuestao")
    private QuestaoModel questaoRelacional;
    
    private String alternativaPergunta;
    private boolean taCerto;
}
