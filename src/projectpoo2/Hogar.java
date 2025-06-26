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
public abstract class Hogar extends Producto{
    protected String material;
    protected double alto;
    protected double ancho;
    protected double profundiad;

    public Hogar() {
    }

    public Hogar(String material, double alto, double ancho, double profundiad, int id, int cantidad, String name, String tipoProd, double costo, double precio) {
        super(id, cantidad, name, tipoProd, costo, precio);
        this.material = material;
        this.alto = alto;
        this.ancho = ancho;
        this.profundiad = profundiad;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getProfundiad() {
        return profundiad;
    }

    public void setProfundiad(double profundiad) {
        this.profundiad = profundiad;
    }
    
    public void mostrarHogar(){
        this.mostrarProducto();
        System.out.println("Material:"+this.getMaterial()+"; Alto:"+this.getAlto()+"; Ancho:"+this.getAncho()+"; Profundidad:"+this.getProfundiad());
    }
    
    public void crearHogar(){
        this.crearProducto();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Material del producto: ");
        String material = sc.nextLine();
        this.setMaterial(material);
        
        System.out.print("Alto del producto: ");
        Double alto = sc.nextDouble();
        sc.nextLine();
        this.setAlto(alto);
        
        System.out.print("Ancho del producto: ");
        Double ancho = sc.nextDouble();
        sc.nextLine();
        this.setAncho(ancho);
        
        System.out.print("Profundidad del producto: ");
        Double profundidad = sc.nextDouble();
        sc.nextLine();
        this.setProfundiad(profundidad);
    }
    
}
