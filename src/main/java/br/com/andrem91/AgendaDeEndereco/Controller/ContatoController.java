package br.com.andrem91.AgendaDeEndereco.Controller;

import br.com.andrem91.AgendaDeEndereco.DTO.ContatoDTO;
import br.com.andrem91.AgendaDeEndereco.Entity.ContatoEntity;
import br.com.andrem91.AgendaDeEndereco.Service.ContatoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @PostMapping
    public ResponseEntity<ContatoEntity> criarContato(@Valid @RequestBody ContatoDTO dto) {
        ContatoEntity novoContatoEntity = contatoService.salvarContato(dto);
        return ResponseEntity.ok(novoContatoEntity);
    }

    @GetMapping
    public ResponseEntity<List<ContatoEntity>> listarContatos() {
        return ResponseEntity.ok(contatoService.listarContatos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoEntity> buscarContato(@PathVariable Long id) {
        return contatoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
