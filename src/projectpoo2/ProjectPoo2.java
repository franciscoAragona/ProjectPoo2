/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectpoo2;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Fran
 */
public class ProjectPoo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        TiendaOnline tiendaOnline = new TiendaOnline();
        tiendaOnline.getStock().getObjCProductos().cargarTableroProductos(tiendaOnline);
        Scanner mainScanner = new Scanner(System.in);
        int mainOp;

        do {
            System.out.println("\n--- Menú Principal de la Tienda Online ---");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Productos");
            System.out.println("3. Modificar clientes");
            System.out.println("0. Salir de la Aplicación");
            System.out.print("Seleccione una opción: ");

            try {
                mainOp = mainScanner.nextInt();
                mainScanner.nextLine();  
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                mainScanner.next();  
                mainOp = -1;  
            }


            switch (mainOp) {
                case 1:
                    
                    tiendaOnline.ingresarCliente();
                    break;
                case 2:
                    tiendaOnline.productoMenu(tiendaOnline); 
                    break;
                case 3:

                    tiendaOnline.modificarClientes();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación. ¡Hasta luego!");
                    break;
                default:
                    if (mainOp != -1) { 
                        System.out.println("Opción inválida. Por favor, intente de nuevo.");
                    }
                    break;
            }
        } while (mainOp != 0);
        
    }
        
        
    }

    

