package Dev.java10x.CadastroDeNinjas.Service;

import Dev.java10x.CadastroDeNinjas.Dto.MissaoDto;
import Dev.java10x.CadastroDeNinjas.Mapper.MissaoMapper;
import Dev.java10x.CadastroDeNinjas.Model.MissaoModel;
import Dev.java10x.CadastroDeNinjas.Repository.MissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MissaoService {


    private final MissaoRepository missaoRepository;
    private final MissaoMapper missaoMapper;

    @Autowired
    MissaoService(MissaoMapper missaoMapper, MissaoRepository missaoRepository){
        this.missaoMapper = missaoMapper;
        this.missaoRepository = missaoRepository;
    }

    public MissaoDto econtraMissao(Long id){
        Optional<MissaoModel> missaoID = missaoRepository.findById(id);
        return missaoID.map(missaoMapper::map).orElse(null);
    }

}
