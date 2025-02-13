package Dev.java10x.CadastroDeNinjas.Controller;

import Dev.java10x.CadastroDeNinjas.Dto.NinjaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDto ninja) {
        NinjaDto ninjaCriado = ninjaService.criaNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado!\nnome:"+ninjaCriado.nome()+" ID:"+ninjaCriado.id());
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDto>> listarNinjas() {
        List<NinjaDto> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/{id}")
    public ResponseEntity<?> mostrarNinjaPorID(@PathVariable Long id) {
        NinjaDto ninjaID = ninjaService.encontraNinja(id);
        if(ninjaID != null){
            return ResponseEntity.ok( ninjaID );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id " +id+" não existe");
        }
    }

    // Alterar dados do ninja (UPDATE)
    @PutMapping("/{id}")
    public ResponseEntity<?> alterarNinja(@PathVariable Long id, @RequestBody NinjaDto ninja) {
        NinjaDto ninjaAlterado = ninjaService.atualizaNinja(id, ninja);
        if(ninja != null){
            return ResponseEntity.ok(ninjaAlterado);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id " +id+" não existe");
        }
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarNinjaPorID(@PathVariable Long id) {
        if( ninjaService.encontraNinja(id) != null) {

            ninjaService.deletaNinja(id);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe nenhum ninja com esse ID");

        }
    }


}
