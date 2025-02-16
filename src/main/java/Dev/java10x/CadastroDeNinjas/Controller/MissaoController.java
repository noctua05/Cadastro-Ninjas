package Dev.java10x.CadastroDeNinjas.Controller;


import Dev.java10x.CadastroDeNinjas.Dto.MissaoDto;
import Dev.java10x.CadastroDeNinjas.Service.MissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    @Autowired
    private MissaoService missaoService;

    // Adicionar missão (CREATE)
    @PostMapping
    public ResponseEntity<String> criarMissao(@RequestBody MissaoDto missao) {
        MissaoDto missaoCriada = missaoService.criaMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada!\nnome:" + missaoCriada.nome() + ", ID:" + missaoCriada.id());
    }

    // Mostrar todas as missões (READ)
    @GetMapping
    public ResponseEntity<List<MissaoDto>> listarMissoes() {
        List<MissaoDto> missoes = missaoService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    // Mostrar missão por ID (READ)
    @GetMapping("/{id}")
    public ResponseEntity<?> mostrarMissaoPorID(@PathVariable Long id) {
        MissaoDto missaoID = missaoService.encontraMissao(id);
        if (missaoID != null) {
            return ResponseEntity.ok(missaoID);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o id " + id + " não existe");
        }
    }

    // Alterar dados da missão (UPDATE)
    @PutMapping("/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissaoDto missao) {
        MissaoDto missaoAlterada = missaoService.atualizaMissao(id, missao);
        if (missaoAlterada != null) {
            return ResponseEntity.ok(missaoAlterada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o id " + id + " não existe");
        }
    }

    // Deletar missão (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarMissaoPorID(@PathVariable Long id) {
        if (missaoService.encontraMissao(id) != null) {
            missaoService.deletaMissao(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o id " + id + " não existe na base de dados");
        }
    }
}
