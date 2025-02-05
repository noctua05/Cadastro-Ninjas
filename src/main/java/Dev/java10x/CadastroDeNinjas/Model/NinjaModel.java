package Dev.java10x.CadastroDeNinjas.Model;

import Dev.java10x.CadastroDeNinjas.CadastroDeNinjasApplication;
import jakarta.persistence.*;

//JPA = java persistence API
@Entity
@Table(name =  "tb_cadastro")
public class NinjaModel {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    private String nome;

    private String email;

    private String idade;

    @ManyToOne
    @JoinColumn(name = "id")
    private MissoesModel missoes;
    
}


