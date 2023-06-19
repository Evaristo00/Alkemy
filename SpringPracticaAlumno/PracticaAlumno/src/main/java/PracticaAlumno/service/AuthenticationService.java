package PracticaAlumno.service;

import PracticaAlumno.dto.JwtAuthenticationResponse;
import PracticaAlumno.dto.SingInRequestDTO;
import PracticaAlumno.dto.SingUpRequestDTO;
import PracticaAlumno.entity.Alumno;
import PracticaAlumno.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AlumnoRepository alumnoRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    public JwtAuthenticationResponse singUp(SingUpRequestDTO singUpRequestDTO){
        Alumno alumno = Alumno.builder()
                .mail(singUpRequestDTO.mail())
                .edad(singUpRequestDTO.edad())
                .dni(singUpRequestDTO.dni())
                .adeudaMaterias(singUpRequestDTO.adeudaMaterias())
                .nombre(singUpRequestDTO.nombre())
                .apellido(singUpRequestDTO.apellido())
                .pagoMatricula(singUpRequestDTO.pagoMatricula())
                .password(passwordEncoder.encode(singUpRequestDTO.password()))
                .build();
        alumnoRepository.save(alumno);

        String jwt = jwtService.generateToken(alumno);

        return  JwtAuthenticationResponse.builder().token(jwt).build();
    }

    public JwtAuthenticationResponse singIn(SingInRequestDTO request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.mail(),request.password()));
        Alumno alumno = alumnoRepository.findByMail(request.mail())
                .orElseThrow( () -> new IllegalArgumentException("Invalid mail or password"));

        String jwt = jwtService.generateToken(alumno);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }


}
