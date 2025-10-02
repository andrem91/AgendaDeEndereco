package br.com.andrem91.AgendaDeEnderecos.API;

import br.com.andrem91.AgendaDeEnderecos.Exception.CepNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class CepApi {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String URL = "http://localhost:3001/consultacep/{cep}";

    public Map<String, Object> buscarEnderecoPorCep(String cep) {
        try {
            return restTemplate.getForObject(URL, Map.class, cep);
        } catch (HttpClientErrorException.NotFound e) {
            throw new CepNotFoundException(cep);
        }
    }
}
