package Dev.java10x.CadastroDeNinjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    // Adicionar ninja (CREATE)
    @PostMapping("/ninjas")
    public String criarNinja() {
        return "Ninja criado";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/ninjas")
    public String mostrarTodosOsNinjas() {
        return "Ninjas retornados";
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/ninjas/{id}")
    public String mostrarNinjaPorID(@PathVariable Long id) {
        return "Ninja encontrado com ID: " + id;
    }

    // Alterar dados do ninja (UPDATE)
    @PutMapping("/ninjas/{id}")
    public String alterarNinja(@PathVariable Long id) {
        return "Ninja com ID: " + id + " alterado";
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/ninjas/{id}")
    public String deletarNinja(@PathVariable Long id) {
        return "Ninja com ID: " + id + " deletado";
    }


}
