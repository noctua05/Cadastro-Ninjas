package Dev.java10x.CadastroDeNinjas.Mapper;

import Dev.java10x.CadastroDeNinjas.Dto.MissaoDto;
import Dev.java10x.CadastroDeNinjas.Model.MissaoModel;
import org.springframework.stereotype.Component;

@Component
public class MissaoMapper {

    public MissaoModel map(MissaoDto missaoDto){
        MissaoModel missaoModel = new MissaoModel();

        //missaoModel.setId(missaoDto.id());
        missaoModel.setNome(missaoDto.nome());
        missaoModel.setDificuldade(missaoDto.dificuldade());
        return missaoModel;
    }

    public MissaoDto map(MissaoModel missaoModel){
      return new MissaoDto(
              missaoModel.getId(),
              missaoModel.getNome(),
              missaoModel.getDificuldade()
      );
    }
}
