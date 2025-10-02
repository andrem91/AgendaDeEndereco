package br.com.andrem91.AgendaDeEnderecos.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_Consulta_cep_log")
@Data
public class ConsultaCepLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    @Column(columnDefinition = "TEXT")
    private String retornoJson;
    private LocalDateTime dataHoraConsulta;
}
