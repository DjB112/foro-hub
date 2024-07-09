package ForoHub.Challenge.infra.security;

import ForoHub.Challenge.domain.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //obtener el token del header
        var authHeader = request.getHeader("Authorization");
        if (authHeader!=null){
            var token = authHeader.replace("Bearer ", "");
            System.out.println(token);
            var subject = tokenService.getSubject(token);
            if (subject != null){
                //Se busca el usuario y se realiza la autenticacion del sujeto
                var usuario = usuarioRepository.findByLogin(subject);
                var usuarioAutenticado  = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities()); //Si el usuario es valido forzamos el inicio de sesion
                SecurityContextHolder.getContext().setAuthentication(usuarioAutenticado);
            }
            System.out.println(tokenService.getSubject(token));
        }
        filterChain.doFilter(request, response);
    }
}
