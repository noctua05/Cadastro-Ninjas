package Dev.java10x.CadastroDeNinjas.Model;

import Dev.java10x.CadastroDeNinjas.Dto.NinjaDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
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


    public NinjaModel(NinjaDto ninjaDto, MissoesModel missao){
        this.nome = ninjaDto.nome();
        this.email = ninjaDto.email();
        this.idade = ninjaDto.idade();
        this.missoes = missao;
    }
}


