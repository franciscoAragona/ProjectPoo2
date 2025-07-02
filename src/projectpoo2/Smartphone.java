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
public class Smartphone extends Electronico implements GenerarProducto<Smartphone>{
    
    private String sistOperativo;
    private int almacenamiento;

    public Smartphone() {
    }

    public Smartphone( String sistOperativo, int almacenamiento, String marca, int mesesGarantia, int id, int cantidad, String name, String tipoProd, double costo, double precio) {
        super(marca, mesesGarantia, id, cantidad, name, tipoProd, costo, precio);
        this.sistOperativo = sistOperativo;
        this.almacenamiento = almacenamiento;
    }

    public String getSistOperativo() {
        return sistOperativo;
    }

    public void setSistOperativo(String sistOperativo) {
        this.sistOperativo = sistOperativo;
    }

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }
    //implementacion abstract metod()
    @Override
    double calcularPrecioVenta() {return this.getCosto()*1.30;}
    //implementacion abstract metod()
    @Override
    void mostrarDetalles() {
        this.mostrarElectronico();
        System.out.println("SistemaO:"+this.getSistOperativo()+"; Almacenamiento:"+this.getAlmacenamiento());
    }
 
    @Override
    public Smartphone inicializarProducto() {
        Scanner sc = new Scanner(System.in);
        this.crearElectronico();
              
        String so = "";
        do {            
            try {
                System.out.print("Sistema Operativo del Smartphone: ");
                so = sc.nextLine();
                this.setSistOperativo(so);
                if(so.equals("")){
                    throw new EntradaVaciaException("No se ingreso el sistema operativo");
                }
            } catch (EntradaVaciaException e) {
                System.out.println(e.getMessage());
            }
             
        } while (so.trim().equals(""));  
        
        int alm = -1;
        do {            
            try {
                System.out.print("Almacenamiento del Smartphone: ");
                alm = sc.nextInt();
                sc.nextLine();
                this.setAlmacenamiento(alm); 
            } catch (InputMismatchException e) {
                System.out.println("Dato incorrecto, ingrese un numero");
                sc.nextLine();
            }
        } while (alm == -1); 
 
        this.setPrecio(this.calcularPrecioVenta());
        
        return this;
    }
    
}
