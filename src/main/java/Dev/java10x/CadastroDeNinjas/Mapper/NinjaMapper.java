package Dev.java10x.CadastroDeNinjas.Mapper;

import Dev.java10x.CadastroDeNinjas.Dto.NinjaDto;
import Dev.java10x.CadastroDeNinjas.Model.MissoesModel;
import Dev.java10x.CadastroDeNinjas.Model.NinjaModel;
import Dev.java10x.CadastroDeNinjas.Service.MissoesService;
import org.springframework.stereotype.Service;

@Service
public class NinjaMapper {

    private final MissoesService missoesService;

    public NinjaMapper(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    public NinjaModel map(NinjaDto dto) {
        MissoesModel missoesModel = missoesService.econtraMissao(dto.missao());

        NinjaModel ninjaModel = new NinjaModel();

        //ninjaModel.setId(dto.id());
        ninjaModel.setNome(dto.nome());
        ninjaModel.setEmail(dto.email());
        ninjaModel.setIdade(dto.idade());
        ninjaModel.setRank(dto.rank());
        ninjaModel.setMissoes(missoesModel);

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
