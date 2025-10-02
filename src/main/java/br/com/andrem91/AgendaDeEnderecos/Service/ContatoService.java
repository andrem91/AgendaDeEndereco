package br.com.andrem91.AgendaDeEnderecos.Service;

import br.com.andrem91.AgendaDeEnderecos.API.CepApi;
import br.com.andrem91.AgendaDeEnderecos.DTO.ContatoDTO;
import br.com.andrem91.AgendaDeEnderecos.Entity.ConsultaCepLogEntity;
import br.com.andrem91.AgendaDeEnderecos.Entity.ContatoEntity;
import br.com.andrem91.AgendaDeEnderecos.Repository.ConsultaCepLogRepository;
import br.com.andrem91.AgendaDeEnderecos.Repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final ConsultaCepLogRepository consultaCEPLogRepository;
    private final CepApi cepApi;

    public ContatoService(ContatoRepository contatoRepository,
                          ConsultaCepLogRepository consultaCEPLogRepository,
                          CepApi cepApi) {
        this.contatoRepository = contatoRepository;
        this.consultaCEPLogRepository = consultaCEPLogRepository;
        this.cepApi = cepApi;
    }

    public ContatoEntity salvarContato(ContatoDTO dto) {

        Map<String, Object> dadosCep = cepApi.buscarEnderecoPorCep(dto.getCep());

        ContatoEntity contatoEntity = new ContatoEntity();
        contatoEntity.setNome(dto.getNome());
        contatoEntity.setEmail(dto.getEmail());
        contatoEntity.setTelefone(dto.getTelefone());
        contatoEntity.setCep(dto.getCep());
        contatoEntity.setNumero((dto.getNumero()));
        contatoEntity.setComplemento((dto.getComplemento()));
        contatoEntity.setLogradouro((String) dadosCep.get("logradouro"));
        contatoEntity.setBairro((String) dadosCep.get("bairro"));
        contatoEntity.setCidade((String) dadosCep.get("cidade"));
        contatoEntity.setEstado((String) dadosCep.get("estado"));

        ContatoEntity contatoEntitySalvo = contatoRepository.save(contatoEntity);

        ConsultaCepLogEntity log = new ConsultaCepLogEntity();
        log.setCep(contatoEntity.getCep());
        log.setRetornoJson(dadosCep.toString());
        log.setDataHoraConsulta(LocalDateTime.now());
        consultaCEPLogRepository.save(log);

        return contatoEntitySalvo;
    }

    public List<ContatoEntity> listarContatos() {
        return contatoRepository.findAll();
    }

    public Optional<ContatoEntity> buscarPorId(Long id) {
        return contatoRepository.findById(id);
    }
}
