/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package camper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author camper
 */
public class CamperCRUD {
    private List<Camper> campers;
    private Scanner scanner;

    public CamperCRUD() {
        campers = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addCamper() {
        System.out.print("Ingrese identificación: ");
        String identificacion = scanner.nextLine();
        System.out.print("Ingrese nombres: ");
        String nombres = scanner.nextLine();
        System.out.print("Ingrese apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Ingrese dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese acudiente: ");
        String acudiente = scanner.nextLine();
        System.out.print("Ingrese teléfono celular: ");
        String telefonoCelular = scanner.nextLine();
        System.out.print("Ingrese teléfono fijo: ");
        String telefonoFijo = scanner.nextLine();
        System.out.print("Ingrese estado(Aprobado, Reprobado): ");
        String estado = scanner.nextLine();
        System.out.print("Ingrese riesgo(Bajo, Alto): ");
        String riesgo = scanner.nextLine();

        Camper camper = new Camper(identificacion, nombres, apellidos, direccion, acudiente, telefonoCelular, telefonoFijo, estado, riesgo);
        campers.add(camper);
        System.out.println("Camper agregado exitosamente.");
    }

    public void viewCampers() {
        if (campers.isEmpty()) {
            System.out.println("No hay campers registrados.");
        } else {
            for (Camper camper : campers) {
                System.out.println(camper);
            }
        }
    }

    public void updateCamper() {
        System.out.print("Ingrese identificación del camper a actualizar: ");
        String identificacion = scanner.nextLine();
        Camper camper = findCamperById(identificacion);

        if (camper == null) {
            System.out.println("Camper no encontrado.");
        } else {
            System.out.print("Ingrese nuevos nombres (actual: " + camper.getNombres() + "): ");
            String nombres = scanner.nextLine();
            System.out.print("Ingrese nuevos apellidos (actual: " + camper.getApellidos() + "): ");
            String apellidos = scanner.nextLine();
            System.out.print("Ingrese nueva dirección (actual: " + camper.getDireccion() + "): ");
            String direccion = scanner.nextLine();
            System.out.print("Ingrese nuevo acudiente (actual: " + camper.getAcudiente() + "): ");
            String acudiente = scanner.nextLine();
            System.out.print("Ingrese nuevo teléfono celular (actual: " + camper.getTelefonoCelular() + "): ");
            String telefonoCelular = scanner.nextLine();
            System.out.print("Ingrese nuevo teléfono fijo (actual: " + camper.getTelefonoFijo() + "): ");
            String telefonoFijo = scanner.nextLine();
            System.out.print("Ingrese nuevo estado (actual: " + camper.getEstado() + "): ");
            String estado = scanner.nextLine();
            System.out.print("Ingrese nuevo riesgo (actual: " + camper.getRiesgo() + "): ");
            String riesgo = scanner.nextLine();

            camper.setNombres(nombres);
            camper.setApellidos(apellidos);
            camper.setDireccion(direccion);
            camper.setAcudiente(acudiente);
            camper.setTelefonoCelular(telefonoCelular);
            camper.setTelefonoFijo(telefonoFijo);
            camper.setEstado(estado);
            camper.setRiesgo(riesgo);

            System.out.println("Camper actualizado exitosamente.");
        }
    }

    public void deleteCamper() {
        System.out.print("Ingrese identificación del camper a eliminar: ");
        String identificacion = scanner.nextLine();
        Camper camper = findCamperById(identificacion);

        if (camper == null) {
            System.out.println("Camper no encontrado.");
        } else {
            campers.remove(camper);
            System.out.println("Camper eliminado exitosamente.");
        }
    }

    private Camper findCamperById(String identificacion) {
        for (Camper camper : campers) {
            if (camper.getIdentificacion().equals(identificacion)) {
                return camper;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CamperCRUD camperCRUD = new CamperCRUD();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar Camper");
            System.out.println("2. Ver Campers");
            System.out.println("3. Actualizar Camper");
            System.out.println("4. Eliminar Camper");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (option) {
                case 1:
                    camperCRUD.addCamper();
                    break;
                case 2:
                    camperCRUD.viewCampers();
                    break;
                case 3:
                    camperCRUD.updateCamper();
                    break;
                case 4:
                    camperCRUD.deleteCamper();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (option != 5);
    }
}
