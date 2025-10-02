package br.com.andrem91.AgendaDeEnderecos.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ContatoDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    @Email(message = "E-mail inválido")
    private String email;
    private String telefone;
    @NotBlank(message = "O CEP é obrigatório")
    @Pattern(regexp = "^\\d{5}-?\\d{3}$", message = "CEP deve estar no formato 00000-000")
    private String cep;
    private int numero;
    private String complemento;
}
