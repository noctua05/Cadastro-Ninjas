package Dev.java10x.CadastroDeNinjas.Service;

import Dev.java10x.CadastroDeNinjas.Dto.NinjaDto;
import Dev.java10x.CadastroDeNinjas.Mapper.NinjaMapper;
import Dev.java10x.CadastroDeNinjas.Model.NinjaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Dev.java10x.CadastroDeNinjas.Repository.NinjaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<NinjaDto> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDto encontraNinja(Long id){
        Optional<NinjaModel> ninjaID = ninjaRepository.findById(id);
        return ninjaID.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDto criaNinja(NinjaDto ninja) {
       NinjaModel ninjaModel = ninjaMapper.map(ninja);
       NinjaModel saved= ninjaRepository.save(ninjaModel);
       return ninjaMapper.map(saved);
    }

    public void deletaNinja(Long id){
        ninjaRepository.deleteById(id);
    }

    public NinjaDto atualizaNinja(Long id, NinjaDto ninjaDto) {

        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDto);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }
}
