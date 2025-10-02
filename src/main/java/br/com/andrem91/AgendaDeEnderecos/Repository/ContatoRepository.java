package br.com.andrem91.AgendaDeEnderecos.Repository;

import br.com.andrem91.AgendaDeEnderecos.Entity.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<ContatoEntity, Long> {
}
