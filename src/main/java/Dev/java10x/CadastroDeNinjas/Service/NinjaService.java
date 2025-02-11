package Dev.java10x.CadastroDeNinjas.Service;

import Dev.java10x.CadastroDeNinjas.Dto.NinjaDto;
import Dev.java10x.CadastroDeNinjas.Mapper.NinjaMapper;
import Dev.java10x.CadastroDeNinjas.Model.MissoesModel;
import Dev.java10x.CadastroDeNinjas.Model.NinjaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Dev.java10x.CadastroDeNinjas.Repository.NinjaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private final MissoesService missoesService;
    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    @Autowired
    public NinjaService(NinjaMapper ninjaMapper,MissoesService missaoService, NinjaRepository ninjaRepository) {
        this.missoesService = missaoService;
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //lista de todos os ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    public  NinjaModel  encontraNinja(Long id){

        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }

    public NinjaModel criarNinja(NinjaDto ninja) {
       NinjaModel ninjaModel = ninjaMapper.toModel(ninja);
        return ninjaRepository.save(ninjaModel);
    }

    public void deletaNinja(Long id){
        ninjaRepository.deleteById(id);
    }
}
