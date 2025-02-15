package Dev.java10x.CadastroDeNinjas.Controller;


import Dev.java10x.CadastroDeNinjas.Dto.MissaoDto;
import Dev.java10x.CadastroDeNinjas.Service.MissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/missao")
public class MissaoController {


    @Autowired
    private MissaoService missaoService;
    private MissaoDto missaoDto;

    @GetMapping("/{id}")
    public MissaoDto mostrarMissaoPorID (@PathVariable Long id){
        return missaoService.econtraMissao(id);
    }


}
