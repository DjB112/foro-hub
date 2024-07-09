package ForoHub.Challenge.domain.topico;

import ForoHub.Challenge.domain.usuarios.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="topicos")
@Entity(name="Topico")
@Getter //Cuando compile lombok genera automaticamente los getter
@NoArgsConstructor // lombok genera un construcctor sin atributos
@AllArgsConstructor // lombok genera un construcctor con todos los atributos
@EqualsAndHashCode(of ="id") // para que siempre que se trate del mismo id se entienda que es el mismo registro
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private Long id_autor;
    private String curso;
    private Boolean status;
    private LocalDateTime fecha;

    public Topico(DatosRegistroTopico parametro) {
        this.titulo = parametro.titulo();
        this.mensaje = parametro.mensaje();
        this.id_autor = parametro.id_autor();
        //this.id_autor = JWTeno
        this.curso = parametro.curso();
        this.status =true;
        this.fecha= LocalDateTime.now();
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo()!= null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje()!=null){
            this.mensaje =datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.curso()!=null){
            this.curso =datosActualizarTopico.curso();
        }
    }

    public void desactivarTopico() {
        this.status = false;
    }
}