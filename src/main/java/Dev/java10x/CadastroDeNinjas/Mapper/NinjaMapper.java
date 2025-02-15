package Dev.java10x.CadastroDeNinjas.Mapper;

import Dev.java10x.CadastroDeNinjas.Dto.NinjaDto;
import Dev.java10x.CadastroDeNinjas.Model.MissaoModel;
import Dev.java10x.CadastroDeNinjas.Model.NinjaModel;
import Dev.java10x.CadastroDeNinjas.Service.MissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NinjaMapper {

    private final MissaoService missaoService;
    private final MissaoMapper missaoMapper;

    @Autowired
    public NinjaMapper(MissaoMapper missaoMapper, MissaoService missaoService){
        this.missaoMapper = missaoMapper;
        this.missaoService = missaoService;
    }

    public NinjaModel map(NinjaDto dto) {
        MissaoModel missaoModel = missaoMapper.map(missaoService.econtraMissao(dto.missao()));
        NinjaModel ninjaModel = new NinjaModel();

        //ninjaModel.setId(dto.id());
        ninjaModel.setNome(dto.nome());
        ninjaModel.setEmail(dto.email());
        ninjaModel.setIdade(dto.idade());
        ninjaModel.setRank(dto.rank());
        ninjaModel.setMissoes(missaoModel);

        return ninjaModel;
    }

    public NinjaDto map(NinjaModel ninjaModel) {
        return new NinjaDto(
                ninjaModel.getId(),
                ninjaModel.getNome(),
                ninjaModel.getEmail(),
                ninjaModel.getIdade(),
                ninjaModel.getRank(),
                ninjaModel.getMissoes() != null ? ninjaModel.getMissoes().getId() : null
        );
    }

}
