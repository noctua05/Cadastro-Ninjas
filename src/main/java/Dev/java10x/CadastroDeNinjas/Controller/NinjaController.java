package Dev.java10x.CadastroDeNinjas.Controller;

import Dev.java10x.CadastroDeNinjas.Dto.NinjaDto;
import Dev.java10x.CadastroDeNinjas.Model.NinjaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Dev.java10x.CadastroDeNinjas.Service.NinjaService;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    // Adicionar ninja (CREATE)
    @PostMapping
    public NinjaModel criarNinja(@RequestBody NinjaDto ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/{id}")
    public NinjaModel mostrarNinjaPorID(@PathVariable Long id) {
        return ninjaService.encontraNinja(id);
    }

    // Alterar dados do ninja (UPDATE)
    @PutMapping("/{id}")
    public String alterarNinja(@PathVariable Long id) {
        return "Ninja com ID: " + id + " alterado";
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/{id}")
    public Void deletarNinjaPorID(@PathVariable Long id) {
        ninjaService.deletaNinja(id);
        return null;
    }


}
