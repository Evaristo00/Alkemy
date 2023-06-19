package PracticaAlumno.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "Alumno")
public class Alumno implements UserDetails {

    @Id
    //@Size(min = 8, max = 8)
    private Integer dni;

    @Email
    @NotNull
    @Column(nullable = false)
    private String mail;
    @NotNull
    @JsonIgnore
    private String password;
    @Transient
    private Role role= Role.ALUMNO;

    @NotNull
    @Column(nullable = false)
    private String nombre;
    @NotNull
    @Column(nullable = false)
    private String apellido;
    @NotNull
    @Column(nullable = false)
    private Integer edad;
    @NotNull
    @Column(nullable = false)
    private Boolean adeudaMaterias;
    @NotNull
    @Column(nullable = false)
    private Boolean pagoMatricula;

    @ManyToMany(mappedBy = "listAlumnos")
    private List<Curso> cursos;

    public Alumno(Integer dni, String nombre, String apellido, Integer edad, Boolean adeudaMaterias, Boolean pagoMatricula) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.adeudaMaterias = adeudaMaterias;
        this.pagoMatricula = pagoMatricula;
    }

    @Override
    public String toString() {
        return this.nombre + ", " + this.apellido + "\t - " + this.edad + "años.";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
