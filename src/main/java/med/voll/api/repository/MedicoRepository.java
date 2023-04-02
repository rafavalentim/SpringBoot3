package med.voll.api.repository;


import med.voll.api.medico.model.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.channels.FileChannel;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    // ATENÇÃO: Caso ocorra algum erro na migration, acessar o banco de dados da aplicação e executar o comando:
    // delete from flyway_schema_history where success = 0;
    //caso a migration tenha criado dados defeituosos no BD, será necessário recriar o banco de dados:
    //drop database vollmed_api;
    //create database vollmed_api;
}
