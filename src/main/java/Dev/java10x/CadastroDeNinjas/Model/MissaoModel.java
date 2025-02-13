package Dev.java10x.CadastroDeNinjas.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor

@Entity
@Table(name = "tb_missoes")
public class MissaoModel {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    private String nome;

    private String dificuldade;

    @OneToMany(mappedBy = "missoes" )
    @JsonIgnore
    @ToString.Exclude
    private List<NinjaModel> ninjas;

}
