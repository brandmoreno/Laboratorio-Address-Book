public class Contacto {
    private String nombre;
    private String telefono;
    private String email;

    // constructor
    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    //getters
    public String getNombre(){
        return nombre;
    }
    public String getTelefono(){
        return telefono;
    }
    public String getEmail(){
        return email;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //Se agrega toString
    @Override
    public String toString(){
        System.out.println();
        return "Nombre: "+ nombre + "| Teléfono: "+ telefono + "| Email: "+ email;
    }
}









