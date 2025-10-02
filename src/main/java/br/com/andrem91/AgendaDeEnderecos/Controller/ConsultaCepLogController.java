package br.com.andrem91.AgendaDeEnderecos.Controller;

import br.com.andrem91.AgendaDeEnderecos.Entity.ConsultaCepLogEntity;
import br.com.andrem91.AgendaDeEnderecos.Service.ConsultaCepLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class ConsultaCepLogController {
    private final ConsultaCepLogService consultaCEPLogService;

    public ConsultaCepLogController(ConsultaCepLogService consultaCEPLogService) {
        this.consultaCEPLogService = consultaCEPLogService;
    }

    @GetMapping
    public ResponseEntity<List<ConsultaCepLogEntity>> listarLogs() {
        return ResponseEntity.ok(consultaCEPLogService.listarLogs());
    }
}
