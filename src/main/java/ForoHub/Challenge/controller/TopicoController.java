package ForoHub.Challenge.controller;

import ForoHub.Challenge.domain.repository.TopicoRepository;
import ForoHub.Challenge.domain.topico.*;
import ForoHub.Challenge.domain.usuarios.Usuario;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key") //para que respete el token OpenAPI
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    //Altas de topicos
    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico parametro,
                                                                UriComponentsBuilder uriComponentsBuilder){
        var topico = new Topico(parametro);
        topicoRepository.save(topico);
        //System.out.println(parametro);
        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosRespuestaTopico(topico));
    }

    //Mostrar el listado de topicos con paginacion
    @GetMapping
    public ResponseEntity<Page<DatosListarTopicos>> listadoTopicos(@PageableDefault(size=10) Pageable paginacion){
        //Responde un 200 ok
        return ResponseEntity.ok(topicoRepository.findByStatusTrue(paginacion).map(DatosListarTopicos::new));
    }

    //Actualizar Datos de un topico
    @PutMapping
    @Transactional // para que termine de aplicar el update a la base de datos cuando se termine de ejecutar el void
    public  ResponseEntity<DatosRespuestaTopico> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico;
        if (topicoRepository.existsById(datosActualizarTopico.id())){
            topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
            topico.actualizarDatos(datosActualizarTopico);
            return ResponseEntity.ok(new DatosRespuestaTopico(topico));
        }else{
            throw new ValidationException("No existe el id del topico que desea actualizar");
        }
    }

    // Con esto se realiza un delete logico es decir cambia el estado de un campo en false para que deje de visualizarce y queda el registro en la base de datos
    // para esto se agrego a la tabla un campo activo que va a estar false cuando se le de eliminar al registro
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        if (topicoRepository.existsById(id)) {
            Topico topico = topicoRepository.getReferenceById(id);
            topico.desactivarTopico();
            return ResponseEntity.noContent().build(); //tira 404 o 203
        }else{
            throw new ValidationException("No existe el id del topico que desea eliminar logicamente");
        }
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity eliminarDeleteTopico(@PathVariable Long id) {

        if (topicoRepository.existsById(id)){
            Topico topico = topicoRepository.getReferenceById(id);
            topicoRepository.delete(topico);
            return ResponseEntity.noContent().build(); //tira 404 o 203
        }else {
            throw new ValidationException("No existe el id del topico que desea eliminar fisicamente");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> mostrarTopico(@PathVariable Long id) {
        if (topicoRepository.existsById(id)) {
            Topico topico = topicoRepository.getReferenceById(id);
            return ResponseEntity.ok(new DatosRespuestaTopico(topico));
        }else{
            throw new ValidationException("No existe el id del topico buscado");
        }

    }

}
