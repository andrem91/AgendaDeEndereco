package br.com.andrem91.AgendaDeEndereco.Service;

import br.com.andrem91.AgendaDeEndereco.Entity.ConsultaCepLogEntity;
import br.com.andrem91.AgendaDeEndereco.Repository.ConsultaCepLogRepository;
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
