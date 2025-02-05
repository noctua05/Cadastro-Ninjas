package Dev.java10x.CadastroDeNinjas.Model;

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

    @OneToMany
    private List<NinjaModel> ninjas;

}
