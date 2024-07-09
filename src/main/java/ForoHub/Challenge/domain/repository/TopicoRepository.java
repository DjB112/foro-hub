package ForoHub.Challenge.domain.repository;

import ForoHub.Challenge.domain.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Page<Topico> findByStatusTrue(Pageable paginacion);
}
