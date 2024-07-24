package trainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class trainerCRUD {
    private List<trainer> trainers; 
    private Scanner sc;

    public trainerCRUD(){
        trainers = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void addTrainer(){
        System.out.print("Ingresa identificación: ");
        int identificacion = sc.nextInt();
        System.out.print("Ingresa nombres: ");
        String nombres = sc.nextLine();
        System.out.print("Ingresa apellidos: ");
        String apellidos = sc.nextLine();
        System.out.print("Ingresa Número de celular: ");
        String celular = sc.nextLine();
        System.out.print("Ingresa el salon del Trainer: ");
        String salon = sc.nextLine();

        trainer trainer = new trainer(identificacion, nombres, apellidos, celular, salon);
        trainers.add(trainer);
        System.out.println("Trainer agregado exitosamente.");
    }

    public void viewTrainer() {
        if (trainers.isEmpty()){
            System.out.println("No hay Trainers registrados.");
        } else {
            for (trainer trainer : trainers){
                System.out.println(trainer);
            }
        }
    }

    public void updateTrainer() {
        System.out.print("Ingrese identificación del trainer a actualizar: ");
        int identificacion = sc.nextInt();
        trainer trainer = findTrainerBy(identificacion);

        if (trainer == null) {
            System.out.println("Trainer no encontrado: ");
        } else {
            System.out.print("Ingrese nuevos nombres (actual: " + trainer.getNombres() + "): )");
            String nombres = sc.nextLine();
            System.out.print("Ingrese nuevos apellidos (actual " + trainer.getApellidos() + "): )");
            String apellidos = sc.nextLine();
            System.out.print("Ingrse nuevo numero de celular (actual " + trainer.getCelular() + "): )");
            String celular = sc.nextLine();
            System.out.print("Ingrese nuevo salon del trainer (actual " + trainer.getSalon() + "): )");
            String salon = sc.nextLine();

            trainer.setNombres(nombres);
            trainer.setApellidos(apellidos);
            trainer.setCelular(celular);
            trainer.setSalon(salon);

            System.out.println("Trainer actualizado exitosamente");
        }
    }

    public void deleteTrainer() {
        System.out.print("Ingrese identificación del trainer a eliminar");
        int identificacion = sc.nextInt();
        trainer trainer = findTrainerBy(identificacion);

        if (trainer == null) {
            System.out.println("Trainer no encontrado");
        } else {
            System.out.println("El trainer que deseas eliminar es: " + trainer + " (s/n)");
            String opcion = sc.nextLine();
            if (opcion.equalsIgnoreCase("s")) {
                trainers.remove(trainer);
                System.out.println("Trainer eliminado exitosamente");
            } else {
                System.out.println("Eliminacion cancelada :)");
            }
        }
    }

    private trainer findTrainerBy(int identificacion) {
        for (trainer trainer : trainers) {
            if (trainer.getIdentificacion() == identificacion) {
                return trainer;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        trainerCRUD trainersCrud = new trainerCRUD();
        Scanner scanner = new Scanner(System.in);
        int option;
        
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar Trainer");
            System.out.println("2. Ver Trainer");
            System.out.println("3. Actualizar Trainer");
            System.out.println("4. Eliminar Trainer");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch(option) {
                case 1:
                    trainersCrud.addTrainer();
                    break;
                case 2:
                    trainersCrud.viewTrainer();
                    break;
                case 3:
                    trainersCrud.updateTrainer();
                    break;
                case 4:
                    trainersCrud.deleteTrainer();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion inválida. Intente de nuevo.");
            }
        }while (option != 5);
    }
}
