package Dev.java10x.CadastroDeNinjas.Repository;

import Dev.java10x.CadastroDeNinjas.Model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel,Long> {
}
