package CEA_Indiv;

import CEA_Indiv.Application.UsesCAses.*;
import CEA_Indiv.Domain.Entitis.Aplicacion;
import CEA_Indiv.Domain.Repositorie.AplicacionRepositori;
import CEA_Indiv.Infrastructure.Persistente.AplicacionRepositoriImp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AplicacionRepositori repositorio = new AplicacionRepositoriImp();

        CrearApli crearApli = new CrearApli(repositorio);
        ActualiazarApli actualizarApli = new ActualiazarApli(repositorio);
        EliminarApli eliminarApli = new EliminarApli(repositorio);
        BuscarApli buscarApli = new BuscarApli(repositorio);
        ListarAplicacion listarAplicacion = new ListarAplicacion(repositorio);
        
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    crearNuevaAplicacion(scanner, crearApli);
                    break;
                case 2:
                    listarTodasLasAplicaciones(listarAplicacion);
                    break;
                case 3:
                    buscarAplicacionPorId(scanner, buscarApli);
                    break;
                case 4:
                    actualizarAplicacion(scanner, actualizarApli, buscarApli);
                    break;
                case 5:
                    eliminarAplicacion(scanner, eliminarApli);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nOpción inválida. Intente nuevamente.");
            }
            
        } while (opcion != 0);
        
        scanner.close();
    }
    
    private static void mostrarMenu() {

        System.out.println(" GESTIÓN DE APLICACIONES   ");
        System.out.println("1. Crear nueva aplicación");
        System.out.println("2. Listar todas las aplicaciones");
        System.out.println("3. Buscar aplicación por ID");
        System.out.println("4. Actualizar aplicación");
        System.out.println("5. Eliminar aplicación");
        System.out.println("0. Salir");
        System.out.print("\nSeleccione una opción: ");
    }
    
    private static void crearNuevaAplicacion(Scanner scanner, CrearApli crearApli) {
        System.out.println("\n=== CREAR NUEVA APLICACIÓN ===");
        
        Aplicacion aplicacion = new Aplicacion();
        
        System.out.print("Nombre: ");
        aplicacion.setNombre(scanner.nextLine());
        
        System.out.print("Proveedor: ");
        aplicacion.setProveedor(scanner.nextLine());
        
        System.out.print("Categoría: ");
        aplicacion.setCategoria(scanner.nextLine());
        
        System.out.print("Lenguaje Principal: ");
        aplicacion.setLenguajePrincipal(scanner.nextLine());
        
        System.out.print("Lenguaje Secundario: ");
        aplicacion.setLenguajeSecundario(scanner.nextLine());
        
        System.out.print("¿Usa Base de Datos? : ");
        aplicacion.setUsaBd(scanner.nextLine());
        
        System.out.print("¿Requiere Conexión a Red? : ");
        aplicacion.setRequiereConexionRed(scanner.nextLine());
        
        System.out.print("Número de Bits (32/64): ");
        aplicacion.setNumBits(scanner.nextInt());
        scanner.nextLine(); // Limpiar buffer
        
        System.out.print("Sistema Operativo: ");
        aplicacion.setSistemaOperativo(scanner.nextLine());
        
        System.out.print("Requisitos de Hardware: ");
        aplicacion.setRequisitosHardware(scanner.nextLine());
        
        System.out.print("Licencia: ");
        aplicacion.setLicencia(scanner.nextLine());
        
        System.out.print("Precio: ");
        aplicacion.setPrecio(scanner.nextDouble());
        scanner.nextLine(); // Limpiar buffer
        
        System.out.print("Descripción: ");
        aplicacion.setDescripcion(scanner.nextLine());
        
        System.out.print("Página Web: ");
        aplicacion.setWeb(scanner.nextLine());
        
        System.out.print("Correo: ");
        aplicacion.setCorreo(scanner.nextLine());
        
        System.out.print("Tamaño del Instalador (MB): ");
        aplicacion.setTamanoInstalador(scanner.nextDouble());
        scanner.nextLine(); // Limpiar buffer
        
        boolean resultado = crearApli.ejecutar(aplicacion);
        
        if (resultado) {
            System.out.println("\n✓ Aplicación creada exitosamente!");
        } else {
            System.out.println("\n✗ Error al crear la aplicación.");
        }
    }
    
    private static void listarTodasLasAplicaciones(ListarAplicacion listarAplicacion) {
        System.out.println("\n=== LISTADO DE APLICACIONES ===");
        
        Aplicacion[] aplicaciones = listarAplicacion.listarAplicaciones();
        
        if (aplicaciones.length == 0) {
            System.out.println("No hay aplicaciones registradas.");
        } else {
            for (Aplicacion app : aplicaciones) {
                mostrarAplicacion(app);
                System.out.println("─────────────────────────────────────────");
            }
            System.out.println("Total de aplicaciones: " + aplicaciones.length);
        }
    }
    
    private static void buscarAplicacionPorId(Scanner scanner, BuscarApli buscarApli) {
        System.out.println("\n=== BUSCAR APLICACIÓN ===");
        System.out.print("Ingrese el ID de la aplicación: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        Aplicacion aplicacion = buscarApli.ejecutar(id);
        
        if (aplicacion != null) {
            System.out.println("\n✓ Aplicación encontrada:");
            mostrarAplicacion(aplicacion);
        } else {
            System.out.println("\n✗ No se encontró ninguna aplicación con el ID: " + id);
        }
    }
    
    private static void actualizarAplicacion(Scanner scanner, ActualiazarApli actualizarApli, BuscarApli buscarApli) {
        System.out.println("\n=== ACTUALIZAR APLICACIÓN ===");
        System.out.print("Ingrese el ID de la aplicación a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        Aplicacion aplicacionExistente = buscarApli.ejecutar(id);
        
        if (aplicacionExistente == null) {
            System.out.println("\n✗ No se encontró ninguna aplicación con el ID: " + id);
            return;
        }
        
        System.out.println("\n=== Datos actuales de la aplicación ===");
        mostrarAplicacion(aplicacionExistente);
        System.out.println("\n=== Ingrese los nuevos datos ===");
        
        System.out.print("Nombre: ");
        aplicacionExistente.setNombre(scanner.nextLine());
        
        System.out.print("Proveedor: ");
        aplicacionExistente.setProveedor(scanner.nextLine());
        
        System.out.print("Categoría: ");
        aplicacionExistente.setCategoria(scanner.nextLine());
        
        System.out.print("Lenguaje Principal: ");
        aplicacionExistente.setLenguajePrincipal(scanner.nextLine());
        
        System.out.print("Lenguaje Secundario: ");
        aplicacionExistente.setLenguajeSecundario(scanner.nextLine());
        
        System.out.print("¿Usa Base de Datos?  ");
        aplicacionExistente.setUsaBd(scanner.nextLine());
        
        System.out.print("¿Requiere Conexión a Red?  ");
        aplicacionExistente.setRequiereConexionRed(scanner.nextLine());
        
        System.out.print("Número de Bits (32/64): ");
        aplicacionExistente.setNumBits(scanner.nextInt());
        scanner.nextLine(); // Limpiar buffer
        
        System.out.print("Sistema Operativo: ");
        aplicacionExistente.setSistemaOperativo(scanner.nextLine());
        
        System.out.print("Requisitos de Hardware: ");
        aplicacionExistente.setRequisitosHardware(scanner.nextLine());
        
        System.out.print("Licencia: ");
        aplicacionExistente.setLicencia(scanner.nextLine());
        
        System.out.print("Precio: ");
        aplicacionExistente.setPrecio(scanner.nextDouble());
        scanner.nextLine(); // Limpiar buffer
        
        System.out.print("Descripción: ");
        aplicacionExistente.setDescripcion(scanner.nextLine());
        
        System.out.print("Página Web: ");
        aplicacionExistente.setWeb(scanner.nextLine());
        
        System.out.print("Correo: ");
        aplicacionExistente.setCorreo(scanner.nextLine());
        
        System.out.print("Tamaño del Instalador (MB): ");
        aplicacionExistente.setTamanoInstalador(scanner.nextDouble());
        scanner.nextLine(); // Limpiar buffer
        
        boolean resultado = actualizarApli.ejecutar(aplicacionExistente);
        
        if (resultado) {
            System.out.println("\n✓ Aplicación actualizada exitosamente!");
        } else {
            System.out.println("\n✗ Error al actualizar la aplicación.");
        }
    }

    private static void eliminarAplicacion(Scanner scanner, EliminarApli eliminarApli) {
        System.out.println("\n=== ELIMINAR APLICACIÓN ===");
        System.out.print("Ingrese el ID de la aplicación a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        boolean resultado = eliminarApli.ejecutar(id);

        if (resultado) {
            System.out.println("\n✓ Aplicación eliminada exitosamente!");
        } else {
            System.out.println("\n✗ Error al eliminar la aplicación.");
        }
    }
    
    private static void mostrarAplicacion(Aplicacion app) {
        System.out.println("\nID: " + app.getId());
        System.out.println("Nombre: " + app.getNombre());
        System.out.println("Proveedor: " + app.getProveedor());
        System.out.println("Categoría: " + app.getCategoria());
        System.out.println("Lenguaje Principal: " + app.getLenguajePrincipal());
        System.out.println("Lenguaje Secundario: " + app.getLenguajeSecundario());
        System.out.println("Usa BD: " + (app.isUsaBd()));
        System.out.println("Requiere Red: " + (app.isRequiereConexionRed()));
        System.out.println("Bits: " + app.getNumBits());
        System.out.println("Sistema Operativo: " + app.getSistemaOperativo());
        System.out.println("Requisitos Hardware: " + app.getRequisitosHardware());
        System.out.println("Licencia: " + app.getLicencia());
        System.out.println("Precio: $" + app.getPrecio());
        System.out.println("Descripción: " + app.getDescripcion());
        System.out.println("Web: " + app.getWeb());
        System.out.println("Correo: " + app.getCorreo());
        System.out.println("Tamaño Instalador: " + app.getTamanoInstalador() + " MB");
    }
}