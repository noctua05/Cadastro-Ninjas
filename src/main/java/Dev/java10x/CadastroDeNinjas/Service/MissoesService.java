package Dev.java10x.CadastroDeNinjas.Service;

import Dev.java10x.CadastroDeNinjas.Model.MissoesModel;
import Dev.java10x.CadastroDeNinjas.Repository.MissoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MissoesService {

    @Autowired
    private MissoesRepository missoesRepository;

    public MissoesModel econtraMissao(Long id){
        Optional<MissoesModel> missaoModel = missoesRepository.findById(id);
        return missaoModel.orElse(null);
    }

}
