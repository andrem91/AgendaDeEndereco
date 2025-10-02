package br.com.andrem91.AgendaDeEndereco.Repository;

import br.com.andrem91.AgendaDeEndereco.Entity.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<ContatoEntity, Long> {
}
