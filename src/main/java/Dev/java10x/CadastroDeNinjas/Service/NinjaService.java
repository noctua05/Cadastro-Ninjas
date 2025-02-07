package Dev.java10x.CadastroDeNinjas.Service;

import Dev.java10x.CadastroDeNinjas.Model.NinjaModel;
import org.springframework.stereotype.Service;
import Dev.java10x.CadastroDeNinjas.Repository.NinjaRepository;

import java.util.List;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository = ninjaRepository;
    }

    //lista de todos os ninjas
    public List<NinjaModel> listarNinjas(){

        return ninjaRepository.findAll();


    }

}
