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
    public static void main(String[] args) throws SQLException  {
        // TODO code application logic here
        TiendaOnline tiendaOnline = new TiendaOnline();
        tiendaOnline.getStock().stockMenu(tiendaOnline);
        Scanner mainScanner = new Scanner(System.in);
        int mainOp = -1;

        do {
            mainOp = -1;
            System.out.println("\n--- Menú Principal de la Tienda Online ---");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Productos");
            System.out.println("3. Modificar clientes");
            System.out.println("4. Eliminar clientes");
            System.out.println("0. Salir de la Aplicación");
            System.out.print("Seleccione una opción: ");

            try {
                mainOp = mainScanner.nextInt();
                mainScanner.nextLine();
                if(mainOp<0 || mainOp>4){
                    throw new ValorFueraDeRangoException("Ingrese un valor entero entre 0 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Dato incorrecto, ingrese un numero");
                mainScanner.nextLine();
            }catch(ValorFueraDeRangoException v){
                System.out.println(v.getMessage());
            }

            switch (mainOp) {
                case 1:
                    
                    tiendaOnline.ingresarCliente();
                    break;
                case 2:
                    tiendaOnline.productoMenu(tiendaOnline); 
                    break;
                case 3:
                    if(tiendaOnline.getClientes().isEmpty()){
                        System.out.println("No hay clientes");
                    }else{
                        tiendaOnline.modificarClientes();
                    }
                    break;
                case 4:
                    if(tiendaOnline.getClientes().isEmpty()){
                        System.out.println("No hay clientes");
                    }else{
                        tiendaOnline.eliminarClientes();
                    }
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación. ¡Hasta luego!");
                    break;
            }
        } while (mainOp != 0);
        
    }
        
        
    }

    

