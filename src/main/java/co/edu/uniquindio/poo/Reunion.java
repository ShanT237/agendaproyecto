package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

public class Reunion {
    private String descripcion;
    private LocalDate fecha;
    private LocalTime hora;
    private LinkedList<Contacto> contactos;

    // Metodos principales
    // Constructor
    public Reunion(String descripcion, LocalDate fecha, LocalTime hora) {
        // set para verificar que el usuario introduzca los datos correspodientes
        setDescripcion(descripcion);
        ;
        setFecha(fecha);
        setHora(hora);
        contactos = new LinkedList<>();
    }

    // Metodo para motrar la lista de contactos de reunion
    public static void mostrarListaReunion(Reunion reunion) {
        System.out.println("\n" + reunion);
        for (Contacto i : reunion.getContactos()) {
            System.out.println(i);

        }
    }
    
    //Metodo agregar Contacto Asistente
    //Se usa el metodo verificar para previnir de añadir contactos repetidos en la lista
    public void agregarContactoAsistente(Contacto contacto) {
        if (verificarContactoAsistente(contacto)) {
            System.out.println("El contacto ya existe");
        } else {
            contactos.add(contacto);
        }

    }
    
    //Verifica que el nombre y telefono del contacto ingresado no se repita en la lista
    //Se usa for each para iterar y se compara numero y telefono
    //Se retorno un valor booleano que se usa en el metodo agregar contacto asitente
    public boolean verificarContactoAsistente(Contacto contacto) {
        boolean value = false;
        for (Contacto i : contactos) {
            if (i.getNombre().equals(contacto.getNombre()) && i.getTelefono().equals(contacto.getTelefono())) {

                value = true;
                break;

            }

        }
        return value;

    }

    //Metodo para modifcar un contacto asistente, el numero y telefono del contacto ingresado deben ser iguales a uno exitente en la lista contactos
    public void modificarContactoAsistente(Contacto contacto) {
        Contacto contactoActual;
        //Iterar la lista
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
    
    //Metodo para eliminar un contacto dado una posicion ingresada
    public void eliminarContactoAsistente(String texto) {
        System.out.println("\nIngrese la posición del contacto asistente que quiere eliminar " + texto );
        Scanner scanner = new Scanner(System.in);
        int posicion = scanner.nextInt();
        
        //Este condición verifica que el numero ingrsado no sea menor o mayor al tamaño de la lista
        if (posicion >= 0 && posicion < contactos.size()) {
            contactos.remove(posicion);
            System.out.println("Contacto Asistente eliminado exitosamente.");
        } else {
            System.out.println("Posición fuera de los límites. No se eliminó ningún contacto.");
        }

    }

    // Metodos get, set, toString
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        assert descripcion != null && !descripcion.isBlank() : "La descripción no puede ser nula o vacio";
        this.descripcion = descripcion;

    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        assert fecha != null : "La fecha no puede ser nula";
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        assert hora != null : "La hora no puede ser nula";
        this.hora = hora;
    }

    public Collection<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(LinkedList<Contacto> contactos) {
        this.contactos = contactos;

    }
     
    //ToString
    @Override
    public String toString() {
        return "-Reunion: " + descripcion + ", fecha " + fecha + ", hora " + hora + ".";
    }

}