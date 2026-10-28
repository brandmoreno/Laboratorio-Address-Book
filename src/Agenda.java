import java.util.*;

public class Agenda {

    Map<String, Contacto> contactos = new TreeMap<>();
    Set<String> grupos = new TreeSet<>();
    Map<String, Set<String>> contactosPorGrupo = new TreeMap<>();
    List<Contacto> historial = new ArrayList<>();

    // contactos

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

        for (String nombreGrupo : grupos) {
            contactosPorGrupo.get(nombreGrupo).remove(nombre);
        }
        System.out.println("El contacto se eliminó correctamente");
        return true;
    }

    public void listarContactos() {
        for (Contacto c : contactos.values()) {
            System.out.println(c);
        }
    }

    public void listarHistorial() {
        for (Contacto c : historial)
            System.out.println(c);
    }


    //grupos

    public void agregarGrupo(String nombreGrupo) {
        if (grupos.contains(nombreGrupo)) {
            System.out.println("El nombre del grupo ya existe " + nombreGrupo);
            return;
        }
        grupos.add(nombreGrupo);
        contactosPorGrupo.put(nombreGrupo, new TreeSet<>());
        System.out.println("Grupo" + nombreGrupo + "ha sido creado");
    }

    public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo) {
        if (!contactos.containsKey(nombreContacto)) {
            System.out.println("Error: el contacto" + nombreContacto + "no existe");
            return;
        }
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("Error: el grupo " + nombreGrupo + "no existe");
            return;
        }

        contactosPorGrupo.get(nombreGrupo).add(nombreContacto);
        System.out.println("El contacto ha sido agregado al grupo: " + nombreGrupo);
    }

    public void listarGrupos() {
        if (grupos.isEmpty()) {
            System.out.println("No hay grupos creados");
            return;
        }
        for (String grupo : grupos) {
            System.out.println(grupo);
        }

    }

    public void mostrarContactosPorGrupo(String nombreGrupo) {

        if (!grupos.contains(nombreGrupo)) {
            System.out.println("Error: el grupo " + nombreGrupo + "no existe");
            return;
        }

        Set<String> nombres = contactosPorGrupo.get(nombreGrupo);
        if (nombres.isEmpty()) {
            System.out.println("el grupo" + nombreGrupo + "no tiene contactos");
            return;
        }
        System.out.println("Contactos en: " + nombreGrupo);
        for (String nombre : nombres) {
            System.out.println(contactos.get(nombre));
        }
    }
}
