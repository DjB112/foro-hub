package ForoHub.Challenge.domain.topico;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosRegistroTopico(

        @NotBlank(message = "{titulo.obligatorio}")  //la dependencia validate valida que nombre no sea nulo ni blanco
        String titulo,

        @NotBlank(message = "{mensaje.obligatorio}")  //validacion
        String mensaje,


        @NotNull(message = "{idAutor.obligatorio}")
        @JsonAlias("idAutor")
        Long id_autor,

        @NotBlank(message = "{curso.obligatorio}")
        String curso
) {
}
