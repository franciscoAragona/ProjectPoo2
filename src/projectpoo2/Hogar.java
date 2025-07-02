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
    //muestra atributos hogar
    public void mostrarHogar(){
        this.mostrarProducto();
        System.out.println("Material:"+this.getMaterial()+"; Alto:"+this.getAlto()+"; Ancho:"+this.getAncho()+"; Profundidad:"+this.getProfundiad());
    }
    
    public void crearHogar() {
        this.crearProducto();
        Scanner sc = new Scanner(System.in);
        String material = "";
        do {            
            try {
                System.out.print("Material del producto: ");
                material = sc.nextLine();
                this.setMaterial(material);
                if(material.equals("")){
                    throw new EntradaVaciaException("No se ingreso ningun material");
                }
            } catch (EntradaVaciaException e) {
                System.out.println(e.getMessage());
            }
            
        } while (material.trim().equals(""));
        
        Double alto = -1.0;
        do {            
            try {
                System.out.print("Alto del producto: ");
                alto = sc.nextDouble();
                sc.nextLine();
                this.setAlto(alto);
            } catch (InputMismatchException e) {
                System.out.println("Dato incorrecto, ingrese un numero");
                sc.nextLine();
            }
        } while (alto == -1.0);  
        
        Double ancho = -1.0;
        do {            
            try {
                System.out.print("Ancho del producto: ");
                ancho = sc.nextDouble();
                sc.nextLine();
                this.setAncho(ancho);
            } catch (InputMismatchException e) {
                System.out.println("Dato incorrecto, ingrese un numero");
                sc.nextLine();
            }
        } while (ancho == -1.0); 
       
        Double profundidad = -1.0;
        do {            
            try {
                System.out.print("Profundidad del producto: ");
                profundidad = sc.nextDouble();
                sc.nextLine();
                this.setProfundiad(profundidad);
            } catch (InputMismatchException e) {
                System.out.println("Dato incorrecto, ingrese un numero");
                sc.nextLine();
            }
        } while (profundidad == -1.0); 
        
    }
    
}
