/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpoo2;

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
    
    public void mostrarProducto(){
        System.out.println("ID:"+this.getId()+"; Nombre:"+this.getName()+"; Precio:"+this.getPrecio()+"; cant:"+this.getCantidad());
    }
    
    public void crearProducto(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nombre del producto: ");
        String name = sc.nextLine();
        this.setName(name);
        
        System.out.print("Costo del producto: ");
        Double costo = sc.nextDouble();
        sc.nextLine();
        this.setCosto(costo);
        
        System.out.print("Cantidad de productos: ");
        int cant = sc.nextInt();
        sc.nextLine();
        this.setCantidad(cant);
    }
}
