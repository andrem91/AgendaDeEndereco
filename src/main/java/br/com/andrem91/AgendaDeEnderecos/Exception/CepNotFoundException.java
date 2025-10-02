package br.com.andrem91.AgendaDeEnderecos.Exception;

public class CepNotFoundException extends RuntimeException {
    public CepNotFoundException(String cep) {
        super("CEP não encontrado: " + cep);
    }
}
