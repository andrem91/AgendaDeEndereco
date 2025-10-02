package br.com.andrem91.AgendaDeEndereco.Exception;

public class CepNotFoundException extends RuntimeException {
    public CepNotFoundException(String cep) {
        super("CEP não encontrado: " + cep);
    }
}
