package ForoHub.Challenge.domain.topico;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        Long idAutor,
        String curso,
        LocalDateTime fechaDeCreacion
) {
    public DatosRespuestaTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getId_autor(), topico.getCurso(), topico.getFecha());
    }
}
