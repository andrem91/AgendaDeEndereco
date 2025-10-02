package br.com.andrem91.AgendaDeEnderecos.Controller;

import br.com.andrem91.AgendaDeEnderecos.DTO.ContatoDTO;
import br.com.andrem91.AgendaDeEnderecos.Entity.ContatoEntity;
import br.com.andrem91.AgendaDeEnderecos.Service.ContatoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
        ContatoEntity novoContato = contatoService.salvarContato(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoContato);
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
