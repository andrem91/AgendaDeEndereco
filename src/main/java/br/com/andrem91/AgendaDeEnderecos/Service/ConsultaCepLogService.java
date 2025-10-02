package br.com.andrem91.AgendaDeEnderecos.Service;

import br.com.andrem91.AgendaDeEnderecos.Entity.ConsultaCepLogEntity;
import br.com.andrem91.AgendaDeEnderecos.Repository.ConsultaCepLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaCepLogService {

    private final ConsultaCepLogRepository consultaCEPLogRepository;

    public ConsultaCepLogService(ConsultaCepLogRepository consultaCEPLogRepository) {
        this.consultaCEPLogRepository = consultaCEPLogRepository;
    }

    public List<ConsultaCepLogEntity> listarLogs() {
        return consultaCEPLogRepository.findAll();
    }
}
