package Dev.java10x.CadastroDeNinjas.Service;

import Dev.java10x.CadastroDeNinjas.Dto.MissaoDto;
import Dev.java10x.CadastroDeNinjas.Dto.NinjaDto;
import Dev.java10x.CadastroDeNinjas.Mapper.MissaoMapper;
import Dev.java10x.CadastroDeNinjas.Model.MissaoModel;
import Dev.java10x.CadastroDeNinjas.Model.NinjaModel;
import Dev.java10x.CadastroDeNinjas.Repository.MissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {


    private final MissaoRepository missaoRepository;
    private final MissaoMapper missaoMapper;

    @Autowired
    MissaoService(MissaoMapper missaoMapper, MissaoRepository missaoRepository){
        this.missaoMapper = missaoMapper;
        this.missaoRepository = missaoRepository;
    }

    // Lista de todas as missões
    public List<MissaoDto> listarMissoes() {
        List<MissaoModel> missoes = missaoRepository.findAll();
        return missoes.stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList());
    }

    // Encontra uma missão pelo ID
    public MissaoDto encontraMissao(Long id) {
        return missaoRepository.findById(id)
                .map(missaoMapper::map)
                .orElse(null);
    }

    // No MissaoService
    public Optional<MissaoModel> encontraMissaoModel(Long id) {
        return missaoRepository.findById(id);
    }


    // Cria uma nova missão
    public MissaoDto criaMissao(MissaoDto missaoDto) {
        MissaoModel missaoModel = missaoMapper.map(missaoDto);
        MissaoModel missaoSalva = missaoRepository.save(missaoModel);
        return missaoMapper.map(missaoSalva);
    }

    // Deleta uma missão pelo ID
    public void deletaMissao(Long id) {
        missaoRepository.deleteById(id);
    }

    // Atualiza uma missão pelo ID
    public MissaoDto atualizaMissao(Long id, MissaoDto missaoDto) {
        Optional<MissaoModel> missaoExistente = missaoRepository.findById(id);
        if (missaoExistente.isPresent()) {
            MissaoModel missaoAtualizada = missaoMapper.map(missaoDto);
            missaoAtualizada.setId(id);
            MissaoModel missaoSalva = missaoRepository.save(missaoAtualizada);
            return missaoMapper.map(missaoSalva);
        }
        return null;
    }



}
