package Dev.java10x.CadastroDeNinjas.Model;

import Dev.java10x.CadastroDeNinjas.Dto.NinjaDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//JPA = java persistence API
@Entity
@Table(name =  "tb_ninjas")
public class NinjaModel {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true ,name = "email")
    private String email;

    @Column(name = "idade")
    private String idade;

    @Column(name = "rank")
    private String rank;

    @ManyToOne
    @JoinColumn(name = "missoes")
    private MissaoModel missoes;


    public NinjaModel(NinjaDto ninjaDto, MissaoModel missao){
        this.nome = ninjaDto.nome();
        this.email = ninjaDto.email();
        this.idade = ninjaDto.idade();
        this.missoes = missao;
    }
}


