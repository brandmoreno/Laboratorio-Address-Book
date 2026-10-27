import java.util.*;

public class Agenda {

    Map<String, Contacto> contactos = new TreeMap<>();
    Set<String> grupos = new TreeSet<>();
    Map<String, Set<String>> contactosPorGrupo = new TreeMap<>();
    List<Contacto> historial = new ArrayList<>();


    public void agregarContacto(Contacto c) {
        if (contactos.containsKey(c.getNombre())) {
            System.out.println("Error: ya hay un contacto con el nombre" + c.getNombre());
            return;
        }
        contactos.put(c.getNombre(), c);
        historial.add(c);
        System.out.println("Contacto agregado: " + c.getNombre());
    }

    public Contacto buscarContacto(String nombre) {
        return contactos.get(nombre);
    }

    public boolean eliminarContacto(String nombre) {
        Contacto c = contactos.remove(nombre);
        if (c == null) {
            return false;
        }
        historial.remove(c);

        for(String nombreGrupo : grupos){
            contactosPorGrupo.get(nombreGrupo).remove(nombre);
        }
        System.out.println("El contacto se eliminó correctamente");
        return true;
        }
    public void listarContactos(){
       for (Contacto c : contactos.values()){
           System.out.println(c);
       }
       }
    public void listarHistorial(){
           for (Contacto c : historial)
            System.out.println(c);
        }
    }

