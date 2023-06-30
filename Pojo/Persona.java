package Pojo;

public class Persona {
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private int edad;
    private String direccion;
    private int telefono;
    private Carrito carrito;

    public Persona(String nombre, String apellidoP, String apellidoM, int edad, String direccion, int telefono) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.carrito = new Carrito();  // Se crea una instancia de Carrito al crear la Persona
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public int getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    @Override
    public String toString() {
        return "- " + nombre + " " + apellidoP + " " + apellidoM + " - Edad: " + edad +
                " - Direccion: " + direccion + " - Telefono=" + telefono;
    }

}


