package Dev.java10x.CadastroDeNinjas.Model;

import Dev.java10x.CadastroDeNinjas.CadastroDeNinjasApplication;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//JPA = java persistence API
@Entity
@Table(name =  "tb_ninjas")
public class NinjaModel {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String idade;

    @ManyToOne
    @JoinColumn(name = "missoes")
    private MissoesModel missoes;

}


