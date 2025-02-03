package Dev.java10x.CadastroDeNinjas.Model;

import jakarta.persistence.*;

//JPA = java persistence API
@Entity
@Table(name =  "tb_cadastro_ninja")
public class NinjaModel {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    private String nome;
    private String idade;
}
