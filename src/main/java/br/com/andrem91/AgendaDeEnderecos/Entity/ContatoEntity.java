package br.com.andrem91.AgendaDeEnderecos.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_contato")
@Data
public class ContatoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cep;
    private int numero;
    private String complemento;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
}
