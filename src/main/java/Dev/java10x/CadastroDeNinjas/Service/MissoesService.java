package Dev.java10x.CadastroDeNinjas.Service;

import Dev.java10x.CadastroDeNinjas.Model.MissaoModel;
import Dev.java10x.CadastroDeNinjas.Repository.MissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MissoesService {

    @Autowired
    private MissaoRepository missaoRepository;

    public MissaoModel econtraMissao(Long id){
        Optional<MissaoModel> missaoModel = missaoRepository.findById(id);
        return missaoModel.orElse(null);
    }

}
