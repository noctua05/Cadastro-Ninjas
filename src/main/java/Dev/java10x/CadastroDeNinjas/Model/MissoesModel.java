package Dev.java10x.CadastroDeNinjas.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    private String nome;

    private String dificuldade;

    @OneToMany(mappedBy = "missoes" )
    @JsonIgnore
    private List<NinjaModel> ninjas;

}
