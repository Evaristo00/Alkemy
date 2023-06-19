package PracticaAlumno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


//lo mismo que tener en properties:
//spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class PracticaAlumnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaAlumnoApplication.class, args);
	}

}
