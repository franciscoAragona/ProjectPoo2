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
public class Cpu extends Electronico implements GenerarProducto<Cpu>{
    private double generacion;
    private double velocidadGhz;
    private int nucleos;

    public Cpu() {
    }

    public Cpu(double generacion, double velocidadGhz, int nucleos, String marca, int mesesGarantia, int id, int cantidad, String name, String tipoProd, double costo, double precio) {
        super(marca, mesesGarantia, id, cantidad, name, tipoProd, costo, precio);
        this.generacion = generacion;
        this.velocidadGhz = velocidadGhz;
        this.nucleos = nucleos;
    }

    

    public double getGeneracion() {
        return generacion;
    }

    public void setGeneracion(double generacion) {
        this.generacion = generacion;
    }

    public double getVelocidadGhz() {
        return velocidadGhz;
    }

    public void setVelocidadGhz(double velocidadGhz) {
        this.velocidadGhz = velocidadGhz;
    }

    public int getNucleos() {
        return nucleos;
    }

    public void setNucleos(int nucleos) {
        this.nucleos = nucleos;
    }
    
    @Override
    double calcularPrecioVenta() {return this.getCosto()*1.35;}

    @Override
    void mostrarDetalles() {
        this.mostrarElectronico();
        System.out.println("Generación:" + this.getGeneracion() + "; Velocidad:" + this.getVelocidadGhz() + "GHz; Núcleos:" + this.getNucleos());
    }

    @Override
    public Cpu inicializarProducto() {
        Scanner sc = new Scanner(System.in);
        this.crearElectronico();
        
        System.out.print("Generacion del Cpu: ");
        Double gen = sc.nextDouble();
        sc.nextLine();
        this.setGeneracion(gen);
        
        System.out.print("velocidadGhz del Cpu: ");
        Double velocidadGhz = sc.nextDouble();
        sc.nextLine();
        this.setVelocidadGhz(velocidadGhz);
        
        System.out.print("Cantidad de nucleos del Cpu: ");
        int nucleos = sc.nextInt();
        sc.nextLine();
        this.setNucleos(nucleos);
        
        this.setPrecio(this.calcularPrecioVenta());
        
        return this;
    }
    
    
}
