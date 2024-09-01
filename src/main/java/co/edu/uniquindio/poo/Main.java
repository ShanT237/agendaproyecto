package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import static co.edu.uniquindio.poo.Grupo.mostrarListaGrupo;
import static co.edu.uniquindio.poo.Reunion.mostrarListaReunion;
import static co.edu.uniquindio.poo.Contacto.crearContacto;

/**
 * Autores: Juan Pablo Suaréz, Oscar Mateo Moreno, Santiago Rodríguez Torres
 * Fecha: 31/08/2024
 * Licencia: GNU GPL V3
 *
 */
public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("\nVerificar que un grupo solo pueda tener 5 contactos");
        Grupo club = new Grupo("Club", Categoria.AMIGOS);
        Contacto c1 = new Contacto("Santiago", "Santi", "Carrera 5-86", "345612775", "shane@gmail.com");
        Contacto c2 = new Contacto("Maria", "Maru", "Calle 12 #45-67", "3123456789", "maria@gmail.com");
        Contacto c3 = new Contacto("Luis", "Luisito", "Avenida Siempre Viva 123", "3219876543", "luis@gmail.com");
        Contacto c4 = new Contacto("Ana", "ANita", "Carrera 7 #89-10", "3001234567", "gmail.com");
        Contacto c5 = new Contacto("Carlos", "Carlitos", "Calle 8 #50-40", "3102345678", "carlosgmail.com");
        Contacto c6 = new Contacto("Elena", "Elenita", "Avenida Principal 90", "3508765432", "elena@gmail.com");

        club.agregarContacto(c1);
        club.agregarContacto(c2);
        club.agregarContacto(c3);
        club.agregarContacto(c4);
        club.agregarContacto(c5);
        club.agregarContacto(c6);

        Contacto contacto1 = crearContacto("\nCrear contacto:");

        // Creación de un grupo
        Grupo grupo = new Grupo("Parranda", Categoria.FIESTA);
        grupo.agregarContacto(contacto1);

        // Creación de un segundo grupo para verificar que un contacto pueda pertenecer
        // a varios grupos
        Grupo grupo2 = new Grupo("Terapia", Categoria.OFICINA);

        // Pruebas: Contacto repetido
        grupo2.agregarContacto(contacto1);
        grupo2.agregarContacto(contacto1);

        // Metodo necesario para visualizar el comportamiento
        mostrarListaGrupo(grupo);
        mostrarListaGrupo(grupo2);

        // Prueba: crear más contactos
        Contacto contacto2 = new Contacto("Mateo", "mate", "Avenida Principal 90", "3508765432", "elena@mail.com");

        // Prueba: modificar un contacto
        grupo.modificarContacto(contacto2);

        // Se prueba el metodo eliminar contacto en el grupo secundario
        grupo2.eliminarContacto(grupo2.getNombre());

        // Para visualizar el comportamiento de las listas
        mostrarListaGrupo(grupo);
        mostrarListaGrupo(grupo2);
        
        System.out.println("Prueba clase Reunión:");
        // Creación de un tercer contacto
        Contacto contacto7 = crearContacto("Crear contacto Asistente:");

        // Creación de los grupos reunion
        Reunion reunion1 = new Reunion("Reunión clases de golf", LocalDate.of(2024, 1, 27), LocalTime.of(1, 34));

        // los contactos pueden pertecer a multiples grupos
        reunion1.agregarContactoAsistente(contacto7);
        reunion1.agregarContactoAsistente(contacto1);
        reunion1.agregarContactoAsistente(contacto2);

        // Segundo grupo reunion
        Reunion reunion2 = new Reunion("Reunión de lectura", LocalDate.of(2024, 6, 28), LocalTime.of(4, 7));
        // Se agrega objetos repetidos
        reunion2.agregarContactoAsistente(contacto1);
        reunion2.agregarContactoAsistente(contacto1);
        reunion2.agregarContactoAsistente(contacto2);

        // Comportamiento de las listas
        mostrarListaReunion(reunion1);
        mostrarListaReunion(reunion2);

    
        Contacto contacto8 = new Contacto("Carlos", "Caliche", "Calle 8 #50-40", "3102345678", "carlos@gmail.com");
        reunion2.modificarContactoAsistente(contacto8);
        reunion1.eliminarContactoAsistente(reunion1.getDescripcion());

        //Visualizar las listas
        mostrarListaReunion(reunion1);
        mostrarListaReunion(reunion2);

        scanner.close();

    }

}
