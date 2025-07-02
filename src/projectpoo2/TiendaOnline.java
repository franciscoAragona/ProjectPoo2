/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpoo2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Fran
 */
public class TiendaOnline {
    private Stock stock = new Stock();
    private CClientes objCClientes = new CClientes();
    private ArrayList<Cliente> clientes = objCClientes.cargarTableroClientes();
    
    
    public TiendaOnline() {
    }

    public TiendaOnline(Stock stock, ArrayList<Cliente> clientes) {
        this.stock = stock;
        this.clientes = clientes;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public CClientes getObjCClientes() {
        return objCClientes;
    }

    public void setObjCClientes(CClientes objCClientes) {
        this.objCClientes = objCClientes;
    }
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public Cliente ingresarCliente(){
        Cliente cliente = new Cliente();
        Scanner sc = new Scanner(System.in); 
        System.out.println("--- Guardar Nuevo Cliente ---"); 
        String cellInput = "";
        boolean cellValido = false;
        while (!cellValido) {
            System.out.print("Ingrese el número de celular del cliente (solo números): ");
            cellInput = sc.nextLine();
            try { 
                Integer.parseInt(cellInput);
                cellValido = true;  
            } catch (NumberFormatException e) {
                System.out.println("¡Error! Entrada inválida para el celular. Por favor, ingrese solo números.");
            }
        }
        cliente.setCell(cellInput); 
        String nameInput = "";
        boolean nameValido = false;
        while (!nameValido) {
            System.out.print("Ingrese el nombre del cliente: ");
            nameInput = sc.nextLine();
            if (nameInput.trim().isEmpty()) { // .trim() elimina espacios en blanco al inicio y al final
                System.out.println("¡Error! El nombre no puede estar vacío. Por favor, ingrese un nombre.");
            } else {
                nameValido = true;
            }
        }
        cliente.setName(nameInput);
        int id =this.getObjCClientes().insertarTableroClientes(cellInput, nameInput);
        cliente.setId(id);
        this.getClientes().add(cliente);
        clienteMenu(this, cliente);
        return cliente;
    }
    
    public void mostrarClientes(){
      for(Cliente c : this.getClientes()){
        System.out.println("--- Detalles del Cliente ---");
        System.out.print("ID: " + c.getId());
        System.out.print("|Nombre: " + c.getName());
        System.out.print("|Celular: " + c.getCell());
        System.out.println();
      }
    }//*
    
    public void modificarClientes(){
        mostrarClientes();
        Scanner sc = new Scanner(System.in);
        boolean idValido = false;
        int id = 0;
        while(!idValido){
            System.out.print("Ingrese el id del cliente a modificar: ");
            try {
                id = sc.nextInt();
                sc.nextLine();
                idValido = true;
            } catch (Exception e) {
                System.out.println("¡Error! Entrada inválida para id");
                sc.nextLine();
            }
        }
        
        String name = "";
        String cell = "";
        for(Cliente c : this.getClientes()){
            if(c.getId() == id){
                boolean cellValido = false;
                while (!cellValido) {
                    System.out.print("Ingrese el nuevo número de celular del cliente (solo números): ");
                    cell = sc.nextLine();
                    try { 
                        Integer.parseInt(cell);
                        cellValido = true;  
                    } catch (NumberFormatException e) {
                        System.out.println("¡Error! Entrada inválida para el celular. Por favor, ingrese solo números.");
                    }
                }
                c.setCell(cell);  
                boolean nameValido = false;
                while (!nameValido) {
                    System.out.print("Ingrese el nuevo nombre del cliente: ");
                    name = sc.nextLine();
                    if (name.trim().isEmpty()) { // .trim() elimina espacios en blanco al inicio y al final
                        System.out.println("¡Error! El nombre no puede estar vacío. Por favor, ingrese un nombre.");
                    } else {
                        nameValido = true;
                    }
                }
                c.setName(name);
                clienteMenu(this, c);
            }
        }
        if(name != ""){
            this.getObjCClientes().modificarTableroClientes(id, cell, name);
            mostrarClientes();
        }
    }// **|*
    
    public void eliminarClientes(){
        mostrarClientes();
        Scanner sc = new Scanner(System.in);
        boolean idValido = false;
        int id = 0;
        while(!idValido){
            System.out.print("Ingrese el id del cliente a eliminiar: ");
            try {
                id = sc.nextInt();
                sc.nextLine();
                idValido = true;
                this.getObjCClientes().eleiminarTableroClientes(id);
                for (int i = this.getClientes().size() - 1; i >= 0; i--) {
                    Cliente cliente = this.getClientes().get(i); // Obtenemos el cliente en la posición actual
                    if (cliente.getId() == id) {
                        this.getClientes().remove(i); // Eliminamos el cliente por su índice
                   }
                }
                mostrarClientes();
            } catch (Exception e) {
                System.out.println("¡Error! Entrada inválida para id");
                sc.nextLine();
            }
        }
    }//**|*
    
    public static void clienteMenu(TiendaOnline t, Cliente cliente) {
        Scanner scanner = new Scanner(System.in);
        int op = -1;

        do {
            
            boolean opvalid = false;
            while(!opvalid){
                System.out.println("\n--- Menú de Cliente ---");
                System.out.println("1. Ver Carrito");//*
                System.out.println("2. Agregar Producto al Carrito");//**
                System.out.println("3. Eliminar Producto del Carrito");//**
                System.out.println("4. Vaciar Carrito");//*
                System.out.println("5. Realizar Compra");//*
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                try {
                    op = scanner.nextInt();
                    opvalid = true;
                    if(op<0 || op>5){
                        throw new ValorFueraDeRangoException("Ingrese un valor entero entre 0 y 5");
                    }
                    scanner.nextLine();
                } catch(InputMismatchException e) {
                    System.out.println("Dato incorrecto, ingrese un numero");
                    scanner.nextLine();
                }catch(ValorFueraDeRangoException v){
                    System.out.println(v.getMessage());
                }
            }

            switch (op) {
                case 1:
                    System.out.println("\n--- Productos en el Carrito ---");
                    if (cliente.getCarrito().getS().isEmpty()) {
                        System.out.println("El carrito está vacío.");
                    } else {
                        cliente.verCarrito();
                        System.out.println("Total del carrito: $" + cliente.getCarrito().getTotal());
                    }
                    break;
                case 2:
                    if(t.getStock().getS().isEmpty()){
                        System.out.println("No hay productos en stock");
                    }else{ 
                        t.mostrarProductos();
                        System.out.print("Ingrese el ID del producto a agregar: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Entrada inválida. Por favor, ingrese un número para el ID.");
                            scanner.next();
                            System.out.print("Ingrese el ID del producto a agregar: ");
                        }
                        int productIdToAdd = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingrese la cantidad a agregar: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Entrada inválida. Por favor, ingrese un número para la cantidad.");
                            scanner.next();
                            System.out.print("Ingrese la cantidad a agregar: ");
                        }
                        int quantityToAdd = scanner.nextInt();
                        scanner.nextLine(); 
                        Producto productToAdd = null;
                        for (Producto p : t.getStock().getS()) {
                            if (p.getId() == productIdToAdd) {
                                productToAdd = p;
                                break;
                            }
                        }

                        if (productToAdd != null) {
                            cliente.agregarAlCarrito(t, productToAdd, quantityToAdd);
                        } else {
                            System.out.println("Producto no encontrado en el stock.");
                        }
                    }
                    break;
                case 3:
                    if(cliente.getCarrito().getS().isEmpty()){
                        System.out.println("no hay productos en el carrito");
                    }else{
                        
                    
                        cliente.verCarrito();
                        System.out.print("Ingrese el ID del producto a eliminar del carrito: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Entrada inválida. Por favor, ingrese un número para el ID.");
                            scanner.next();
                            System.out.print("Ingrese el ID del producto a eliminar del carrito: ");
                        }
                        int productIdToRemove = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingrese la cantidad a eliminar: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Entrada inválida. Por favor, ingrese un número para la cantidad.");
                            scanner.next();
                            System.out.print("Ingrese la cantidad a eliminar: ");
                        }
                        int quantityToRemove = scanner.nextInt();
                        scanner.nextLine(); 
                        Producto productToRemove = null;
                        for (Producto p : cliente.getCarrito().getS()) {
                            if (p.getId() == productIdToRemove) {
                                productToRemove = p;
                                break;
                            }
                        }

                        if (productToRemove != null) {
                            cliente.eliminarDelCarrito(t, productToRemove, quantityToRemove);
                        } else {
                            System.out.println("Producto no encontrado en el carrito.");
                        }
                    }
                    break;
                case 4:
                    if (cliente.getCarrito().getS().isEmpty()) {
                        System.out.println("El carrito está vacío.");
                    } else {
                        System.out.print("¿Está seguro que desea vaciar el carrito? (s/n): ");
                        String confirmVaciar = scanner.nextLine();
                        if (confirmVaciar.equalsIgnoreCase("s")) {
                            cliente.vaciarCarrito(t);
                            System.out.println("Carrito vaciado.");
                        } else if (confirmVaciar.equalsIgnoreCase("n")){
                            System.out.println("Operación cancelada.");
                        }
                        break;
                    }
                case 5:
                    if (cliente.getCarrito().getS().isEmpty()) {
                        System.out.println("No puede realizar una compra, el carrito está vacío.");
                    } else {
                        System.out.println("\n--- Realizando Compra ---");
                        cliente.realizarCompra();
                        System.out.println("Compra realizada con éxito. Carrito vaciado automáticamente.");
                        op = 0;
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del menú de cliente.");
                    break;
            }
        } while (op != 0);
        
    }//**|*
    
    public void mostrarProductos(){
      for(Producto p : this.getStock().getS()){
          p.mostrarDetalles();
      }
    }//*
    
    public void modificarProductos(){
        mostrarProductos();
        CProductos objCProductos = new CProductos(); // Assuming CProductos exists for product database operations
        Scanner sc = new Scanner(System.in);
        boolean idValido = false;
        int id = 0;
        while(!idValido){
            System.out.print("Ingrese el id del producto a modificar: ");
            try {
                id = sc.nextInt();
                sc.nextLine();
                idValido = true;
            } catch (Exception e) {
                System.out.println("¡Error! Entrada inválida para id");
            }
        }
        
        String name = "";
        double costo = 0.0;
        int cantidad = 0;

        for(Producto p : this.getStock().getS()){
            if(p.getId() == id){
                // Modify Name
                boolean nameValido = false;
                while (!nameValido) {
                    System.out.print("Ingrese el nuevo nombre del producto: ");
                    name = sc.nextLine();
                    if (name.trim().isEmpty()) {
                        System.out.println("¡Error! El nombre no puede estar vacío. Por favor, ingrese un nombre.");
                    } else {
                        nameValido = true;
                    }
                }
                p.setName(name);

                // Modify Cost
                boolean costoValido = false;
                while(!costoValido){
                    System.out.print("Ingrese el nuevo costo del producto: ");
                    try {
                        costo = sc.nextDouble();
                        sc.nextLine(); // Consume newline
                        costoValido = true;
                    } catch (Exception e) {
                        System.out.println("¡Error! Entrada inválida para el costo. Por favor, ingrese un número decimal.");
                        sc.nextLine(); // Consume the invalid input
                    }
                }
                p.setCosto(costo);

                // Modify Cantidad
                boolean cantidadValida = false;
                while(!cantidadValida){
                    System.out.print("Ingrese la nueva cantidad de productos: ");
                    try {
                        cantidad = sc.nextInt();
                        sc.nextLine(); 
                        cantidadValida = true;
                    } catch (Exception e) {
                        System.out.println("¡Error! Entrada inválida para la cantidad. Por favor, ingrese un número entero.");
                        sc.nextLine(); 
                    }
                }
                p.setCantidad(cantidad);
                objCProductos.modificarTableroProductos(id, cantidad, name,p.getTipoProd(), costo); 
            }
        }
        if(name != ""){ 
            mostrarProductos();
        }
    }//**|*
    
    public void modificarProductos(int id, String newName, String newTipoProd, double newCosto, int newCantidad) {
        CProductos objCProductos = new CProductos(); 
        boolean found = false;
        for (Producto p : this.getStock().getS()) {
            if (p.getId() == id) {
                p.setName(newName);
                p.setTipoProd(newTipoProd);
                p.setCosto(newCosto);
                p.setCantidad(newCantidad); 
                objCProductos.modificarTableroProductos(id, newCantidad, newName,newTipoProd, newCosto); 
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No se encontró ningún producto con el ID: " + id);
        }
        mostrarProductos();
    }//**|*
    
    public void eliminarProductos(){
        mostrarProductos();
        CProductos objCProductos = new CProductos(); 
        Scanner sc = new Scanner(System.in);
        boolean idValido = false;
        int id = 0;
        while(!idValido){
            System.out.print("Ingrese el id del producto a eliminiar: ");
            try {
                id = sc.nextInt();
                sc.nextLine();
                idValido = true;
                objCProductos.eliminarTableroProductos(id);
                for (int i = this.getStock().getS().size() - 1; i >= 0; i--) {
                    Producto prod = this.getStock().getS().get(i); // Obtenemos el producto en la posición actual
                    if (prod.getId() == id) {
                        this.getStock().getS().remove(i); // Eliminamos el producto por su índice
                   }
                }
            } catch (Exception e) {
                System.out.println("¡Error! Entrada inválida para id");
            }
        }
    }//**|*
   
    public void productoMenu(TiendaOnline t) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n--- Menú de Gestión de Productos ---");
            System.out.println("1. Mostrar todos los productos");
            System.out.println("2. Agregar nuevo producto al Stock");
            System.out.println("3. Modificar un producto existente");
            System.out.println("4. Eliminar un producto");
            System.out.println("5. Actualizar la cantidad de un producto en Stock");
            System.out.println("0. Salir del menú de productos");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next();  
                System.out.print("Seleccione una opción: ");
            }
            op = scanner.nextInt();
            scanner.nextLine();  

            switch (op) {
                case 1:
                    System.out.println("\n--- Listado de Productos ---");
                    if (t.getStock().getS().isEmpty()) {
                        System.out.println("No hay productos en el stock.");
                    } else {
                        t.mostrarProductos();
                    }
                    break;
                case 2:
                    System.out.println("\n--- Agregar Nuevo Producto al Stock ---");
                    t.getStock().createStock(t);  
                    System.out.println("Producto agregado exitosamente.");
                    break;
                case 3:
                    System.out.println("\n--- Modificar Producto Existente ---");
                    if (t.getStock().getS().isEmpty()) {
                        System.out.println("No hay productos para modificar en el stock.");
                    } else {
                        t.modificarProductos();
                    }
                    break;
                case 4:
                    System.out.println("\n--- Eliminar Producto ---");
                    if (t.getStock().getS().isEmpty()) {
                        System.out.println("No hay productos para eliminar en el stock.");
                    } else {
                        t.eliminarProductos();
                    }
                    break;
                case 5:
                    System.out.println("\n--- Actualizar Cantidad de Producto en Stock ---");
                    if (t.getStock().getS().isEmpty()) {
                        System.out.println("No hay productos en el stock para actualizar.");
                    } else {
                        t.mostrarProductos();
                        System.out.print("Ingrese el ID del producto cuya cantidad desea actualizar: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Entrada inválida. Por favor, ingrese un número para el ID.");
                            scanner.next();
                            System.out.print("Ingrese el ID del producto cuya cantidad desea actualizar: ");
                        }
                        int productIdToUpdate = scanner.nextInt();
                        scanner.nextLine();

                        Producto productToUpdate = null;
                        for (Producto p : t.getStock().getS()) {
                            if (p.getId() == productIdToUpdate) {
                                productToUpdate = p;
                                break;
                            }
                        }

                        if (productToUpdate != null) {
                            t.getStock().actualizarStock(t, productToUpdate);
                            System.out.println("Cantidad de producto actualizada.");
                        } else {
                            System.out.println("Producto no encontrado en el stock.");
                        }
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del menú de gestión de productos.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        } while (op != 0);
    }
}
