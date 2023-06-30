package Pojo;

public class Empleado extends Persona {
    private int numEmpeado;
    private String tipo;
    private String descanso;


    public Empleado(String nombre, String apellidoP, String apellidoM, int edad, String direccion, int telefono, int numEmpeado, String tipo, String descanso) {
        super(nombre, apellidoP, apellidoM, edad, direccion, telefono);
        this.numEmpeado = numEmpeado;
        this.tipo = tipo;
        this.descanso = descanso;
    }

    @Override
    public String toString() {
        return "- " + getNombre() +" " + getApellidoP() +" "+ getApellidoM()+ " - Edad: " + getEdad() +
                " - Direccion: " + getDireccion() + " - Telefono: " + getTelefono()+ " - Cargo: " + tipo ;

    }
}