package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * Autores: Juan Pablo Suaréz, Oscar Mateo Moreno, Santiago Rodríguez Torres
 * Fecha: 31/08/2024
 * Licencia: GNU GPL V3
 *
 */
public class Grupo {
    private String nombre;
    private Enum<Categoria> categoria;
    private LinkedList<Contacto> contactos;

    // Metodos Principales
    // Constructor
    public Grupo(String nombre, Enum<Categoria> categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
        contactos = new LinkedList<>();
    }

    // Metodo para agregar un contacto a una lista
    public void agregarContacto(Contacto contacto) {
        if (verificarContacto(contacto)) {
            System.out.println("\nEl contacto ya existe");
        } else {
            if (contactos.size() < 5) {
                System.out.println("\nContacto añadido exitosamente");
                contactos.add(contacto);
            } else {
                System.out.println("\nLa lista solo puede contener más de 5 contactos");
            }
        }

    }

    // Se usa for each para iterar la lista y se compara el nombre y telefono para
    public boolean verificarContacto(Contacto contacto) {
        boolean centinela = false;
        for (Contacto i : contactos) {
            if (i.getNombre().equals(contacto.getNombre()) && i.getTelefono().equals(contacto.getTelefono())) {

                centinela = true;
                break;

            }

        }
        return centinela;

    }

    // Para modficar un contacto de la lista el metodo require de nombre y telefono.
    public void modificarContacto(Contacto contacto) {
        Contacto contactoActual;
        for (int i = 0; i < contactos.size(); i++) {
            contactoActual = contactos.get(i);

            if (contactoActual.getNombre().equals(contacto.getNombre()) &&
                    contactoActual.getTelefono().equals(contacto.getTelefono())) {

                contactos.set(i, contacto);
                System.out.println("\nContacto modificado exitosamente.");
                return;
            }

        }
        System.out.println(
                "\nNo se pudo modificar el contacto, verique que la información conicida con un contacto existente");

    }

    // El usuario ingresa la posicion que quiere eliminar en la lista
    public void eliminarContacto(String nombre) {
        System.out.println("\nIngrese la posición del contacto que quiere eliminar en el grupo " + nombre);
        Scanner scanner = new Scanner(System.in);
        int posicion = scanner.nextInt();

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(Enum<Categoria> categoria) {
        this.categoria = categoria;
    }

    public void setContactos(LinkedList<Contacto> contactos) {
        this.contactos = contactos;
    }

    public String getNombre() {
        return nombre;
    }

    public Enum<Categoria> getCategoria() {
        return categoria;
    }

    public LinkedList<Contacto> getContactos() {
        return contactos;
    }

    @Override
    public String toString() {
        return "-Grupo: " + nombre + ", categoria " + categoria + ".";
    }

}