package Dev.java10x.CadastroDeNinjas.Controller;


import Dev.java10x.CadastroDeNinjas.Model.MissoesModel;
import Dev.java10x.CadastroDeNinjas.Service.MissoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/missoes")
public class MissoesController {


    @Autowired
    private MissoesService missoesService;

    @GetMapping("/{id}")
    public MissoesModel mostrarMissaoPorID (@PathVariable Long id){
        return missoesService.econtraMissao(id);
    }


}
