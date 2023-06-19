package PracticaAlumno.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class JwtAuthenticationResponse {
    private String token;
}
