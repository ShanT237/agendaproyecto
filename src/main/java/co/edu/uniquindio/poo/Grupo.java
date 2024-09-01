package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

public class Grupo {
    private String nombre;
    private Enum<Categoria> categoria;
    private LinkedList<Contacto> contactos;

    // Metodos Principales
    // Constructor
    public Grupo(String nombre, Enum<Categoria> categoria) {
        // set para verificar que el usuario introduzca los datos correspodientes
        setNombre(nombre);
        this.categoria = categoria;
        contactos = new LinkedList<>();
    }

    // Metodo para agregar un contacto a una lista
    public void agregarContacto(Contacto contacto) {
        //Se usa el metodo verificar para que no se agregue un contacto repetido
        if (verificarContacto(contacto)) {
            System.out.println("\nEl contacto ya existe");
        } else {
            //Condicional para que la lista no exceda más de 5 contactos
            if (contactos.size() < 5) {
                System.out.println("\nContacto añadido exitosamente");
                contactos.add(contacto);

            } else {
                System.out.println("\nLa lista solo puede contener más de 5 contactos");
            }
        }

    }

    // Se usa for each para iterar la lista y se compara el nombre y telefono para
    // asi verificar que el contacto no se repita
    public boolean verificarContacto(Contacto contacto) {
        boolean value = false;
        for (Contacto i : contactos) {
            if (i.getNombre().equals(contacto.getNombre()) && i.getTelefono().equals(contacto.getTelefono())) {

                value = true;
                break;

            }

        }
        return value;

    }

    // Para modficar un contacto de la lista el metodo require de nombre y telefono, el metodo recibe el objeto contacto y lo compara con los elementos existentes en la lista. Nombre y Telefono debe ser igual a alguno de los elementos de la lista para que se pueda modifcar
    public void modificarContacto(Contacto contacto) {
        Contacto contactoActual;
        for (int i = 0; i < contactos.size(); i++) {
            contactoActual = contactos.get(i);

            if (contactoActual.getNombre().equals(contacto.getNombre()) &&
                    contactoActual.getTelefono().equals(contacto.getTelefono())) {

                // Aqui el contacto se modifica en su posición correspondiente
                contactos.set(i, contacto);
            System.out.println("\nContacto modificado exitosamente.");
                return;
            }

        }
        System.out.println(
                "\nNo se pudo modificar el contacto, verique que la información conicida con un contacto existente");

    }
    //El usuario ingresa la posicion que quiere eliminar en la lista
    public void eliminarContacto(String nombre) {
        System.out.println("\nIngrese la posición del contacto que quiere eliminar en el grupo " + nombre);
        Scanner scanner = new Scanner(System.in);
        int posicion = scanner.nextInt(); 
        
        //Condicional que verifique que el numero no sea menor o mayor al tamño de la lista
        if (posicion >= 0 && posicion < contactos.size()) {
            contactos.remove(posicion);
            System.out.println("Contacto eliminado exitosamente.");
        } else {
            System.out.println("Posición fuera de los límites. No se eliminó ningún contacto.");
        }

    }

    // Metodo para motrar la lista de contactos de grupo
    public static void mostrarListaGrupo(Grupo grupo) {
        System.out.println("\n" + grupo);
        for (Contacto i : grupo.getContactos()) {
            System.out.println(i);

        }
    }

    // Metodos set, get y toString
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        assert nombre != null && !nombre.isBlank() : "El nombre no puede ser nulo o vacio";
        this.nombre = nombre;

    }

    public Enum<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(Enum<Categoria> categoria) {
        this.categoria = categoria;
    }

    public Collection<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(LinkedList<Contacto> contactos) {
        this.contactos = contactos;

    }

    @Override
    public String toString() {
        return "-Grupo: " + nombre + ", categoria " + categoria + ".";
    }

}