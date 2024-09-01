package co.edu.uniquindio.poo;

import java.util.Scanner;
/**
 * Autores: Juan Pablo Suaréz, Oscar Mateo Moreno, Santiago Rodríguez Torres
 * Fecha: 31/08/2024
 * Licencia: GNU GPL V3
 *
 */
public class Contacto {
    private String nombre;
    private String alias;
    private String direccion;
    private String telefono;
    private String email;

    // Metodos principales
    // Metodo Constructor
    public Contacto(String nombre, String alias, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.alias = alias;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    // Metodo para que el usario pueda ingresar valores
    public static Contacto crearContacto(String texto) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el alias ");
        String alias = scanner.nextLine();
        System.out.print("Ingrese la dirección ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese el telefono ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese el email ");
        String email = scanner.nextLine();

        Contacto contacto = new Contacto(nombre, alias, direccion, telefono, email);
        return contacto;

    }

    // Metodos get, set, toString
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getAlias() {
        return alias;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public void setAlias(String alias) {
        this.alias = alias;

    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;

    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;

    }

    @Override
    public String toString() {
        return "Contacto: nombre " + nombre + ", alias " + alias + ", direccion " + direccion + ", telefono " + telefono
                + ", email " + email + ".";
    }

}