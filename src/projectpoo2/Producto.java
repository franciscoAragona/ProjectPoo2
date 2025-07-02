/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpoo2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Fran
 */
public abstract class Producto {
    protected int id;
    protected int cantidad;
    protected String name;
    protected String tipoProd;
    protected double costo;
    protected double precio;

    public Producto() {
    }

    public Producto(int id, int cantidad, String name, String tipoProd, double costo, double precio) {
        this.id = id;
        this.cantidad = cantidad;
        this.name = name;
        this.tipoProd = tipoProd;
        this.costo = costo;
        this.precio = precio;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipoProd() {
        return tipoProd;
    }

    public void setTipoProd(String tipoProd) {
        this.tipoProd = tipoProd;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    abstract double calcularPrecioVenta();
    abstract void mostrarDetalles();
    //muestra atributos producto
    public void mostrarProducto(){
        System.out.println("ID:"+this.getId()+"; Nombre:"+this.getName()+"; Precio:"+this.getPrecio()+"; cant:"+this.getCantidad());
    }
    
    public void crearProducto() {
        Scanner sc = new Scanner(System.in);
        
        String name = "";
        do {            
            try {
                System.out.print("Nombre del producto: ");
                name = sc.nextLine();
                this.setName(name);
                if(name.equals("")){
                    throw new EntradaVaciaException("No se ingreso ningun nombre");
                }
            } catch (EntradaVaciaException e) {
                System.out.println(e.getMessage());
            }
        } while (name.trim().equals(""));
        
        Double costo = -1.0;
        do {            
            try {
                System.out.print("Costo del producto: ");
                costo = sc.nextDouble();
                sc.nextLine();
                this.setCosto(costo);
            } catch (InputMismatchException e) {
                System.out.println("Dato incorrecto, ingrese un numero");
                sc.nextLine();
            }
        } while (costo == -1.0);  
        
        int cant = -1;
        do {            
            try {
                System.out.print("Cantidad de productos: ");
                cant = sc.nextInt();
                sc.nextLine();
                this.setCantidad(cant);
            } catch (InputMismatchException e) {
                System.out.println("Dato incorrecto, ingrese un numero");
                sc.nextLine();
            }
        } while (cant == -1); 
        
    }
}
