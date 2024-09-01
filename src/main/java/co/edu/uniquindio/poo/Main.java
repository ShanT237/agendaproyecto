package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import static co.edu.uniquindio.poo.Grupo.mostrarListaGrupo;
import static co.edu.uniquindio.poo.Reunion.mostrarListaReunion;
import static co.edu.uniquindio.poo.Contacto.crearContacto;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nVerificar que un grupo solo pueda tener 5 contactos");
        Grupo club = new Grupo("Club", Categoria.AMIGOS);
        Contacto c1 = new Contacto("Santiago", "LL", "33", "22", "33434");
        Contacto c2 = new Contacto("Maria", "MJ", "Calle 12 #45-67", "3123456789", "maria@gmail.com");
        Contacto c3 = new Contacto("Luis", "LS", "Avenida Siempre Viva 123", "3219876543", "luis@hotmail.com");
        Contacto c4 = new Contacto("Ana", "AN", "Carrera 7 #89-10", "3001234567", "ana@yahoo.com");
        Contacto c5 = new Contacto("Carlos", "CL", "Calle 8 #50-40", "3102345678", "carlos@outlook.com");
        Contacto c6 = new Contacto("Elena", "EL", "Avenida Principal 90", "3508765432", "elena@mail.com");

        club.agregarContacto(c1);
        club.agregarContacto(c2);
        club.agregarContacto(c3);
        club.agregarContacto(c4);
        club.agregarContacto(c5);
        club.agregarContacto(c6);

        Contacto contacto1 = crearContacto("\nCrear contacto:");

        // Comportamiento de la clase Grupo
        // Creación de un grupo
        Grupo grupo = new Grupo("Parranda", Categoria.FIESTA);
        grupo.agregarContacto(contacto1);

        // Creación de un segundo grupo para verificar que un contacto pueda pertenecer
        // a varios grupos
        Grupo grupo2 = new Grupo("Terapia", Categoria.OFICINA);

        // Agregar uncontacto repetido para verificar que el metodo verificar contacto
        // funcione correctamente. En este caso, Numero y Telefono se repiten por ende
        // no se agrega a la segunda lista
        grupo2.agregarContacto(contacto1);
        grupo2.agregarContacto(contacto1);

        // Motrar listas para verificar el comportamiento
        mostrarListaGrupo(grupo);
        mostrarListaGrupo(grupo2);

        // Se crea más contactos
        Contacto contacto2 = new Contacto("Elena", "EL", "Avenida Principal 90", "3508765432", "elena@mail.com");
        // Se pone aprueba el metodo modificar contacto en el primer grupo
        grupo.modificarContacto(contacto2);

        // Se prueba el metodo eliminar contacto en el grupo secundario
        grupo2.eliminarContacto(grupo2.getNombre());

        // Para visualizar el comportamiento de las listas
        mostrarListaGrupo(grupo);
        mostrarListaGrupo(grupo2);

        // Comportamiento de la clase Reunion
        // Creación de un tercer contacto
        Contacto contacto7 = crearContacto("Crear contacto Asistente:");

        // Creación de los grupos reunion
        Reunion reunion1 = new Reunion("Golfito.com: Para golf", LocalDate.of(2021, 1, 27), LocalTime.of(1, 34));
        // Se agregan el nuevo contacto y los anteriores para verificar que los
        // contactos pueden pertecer a multiples grupos
        reunion1.agregarContactoAsistente(contacto7);
        reunion1.agregarContactoAsistente(contacto1);
        reunion1.agregarContactoAsistente(contacto2);
        // Segundo grupo reunion
        Reunion reunion2 = new Reunion("Té: Para tomar té", LocalDate.of(2024, 6, 28), LocalTime.of(4, 7));
        // Se agrega objetos repetidos
        reunion2.agregarContactoAsistente(contacto1);
        reunion2.agregarContactoAsistente(contacto1);
        reunion2.agregarContactoAsistente(contacto2);

        // Comportamiento de las listas
        mostrarListaReunion(reunion1);
        mostrarListaReunion(reunion2);

        // Cuato objeto para probar el metodo modifcar lista asistentes
        Contacto contacto8 = new Contacto("Carlos", "CL", "Calle 8 #50-40", "3102345678", "carlos@outlook.com");
        reunion2.modificarContactoAsistente(contacto8);
        // Metodo para eliminar un contacto por posición
        reunion1.eliminarContactoAsistente(reunion1.getDescripcion());

        // Comportamiento de las listas
        mostrarListaReunion(reunion1);
        mostrarListaReunion(reunion2);

        scanner.close();

    }

}
