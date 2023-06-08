public class Alumno {
    private String nombre;

    private String apellido;

    private Integer edad;

    private Boolean adeudaMaterias;

    private Boolean pagoMatricula;

    public Alumno(String nombre, String apellido, Integer edad, Boolean adeudaMaterias, Boolean pagoMatricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.adeudaMaterias = adeudaMaterias;
        this.pagoMatricula = pagoMatricula;
    }

    public Alumno() {

    }

    @Override
    public String toString() {
        return this.nombre + ", " + this.apellido + "\t - " + this.edad + "años.";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Boolean getAdeudaMaterias() {
        return adeudaMaterias;
    }

    public void setAdeudaMaterias(Boolean adeudaMaterias) {
        this.adeudaMaterias = adeudaMaterias;
    }

    public Boolean getPagoMatricula() {
        return pagoMatricula;
    }

    public void setPagoMatricula(Boolean pagoMatricula) {
        this.pagoMatricula = pagoMatricula;
    }


}
