package PracticaAlumno.controller;

import PracticaAlumno.dto.JwtAuthenticationResponse;
import PracticaAlumno.dto.SingInRequestDTO;
import PracticaAlumno.dto.SingUpRequestDTO;
import PracticaAlumno.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SingUpRequestDTO request) {
        return ResponseEntity.ok(authenticationService.singUp(request));
    }

    @PostMapping("signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SingInRequestDTO request) {
        return ResponseEntity.ok(authenticationService.singIn(request));
    }
}