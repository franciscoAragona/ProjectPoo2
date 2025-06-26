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
    
    @Override
    double calcularPrecioVenta() {return this.getCosto()*1.30;}

    @Override
    void mostrarDetalles() {
        this.mostrarElectronico();
        System.out.println("SistemaO:"+this.getSistOperativo()+"; Almacenamiento:"+this.getAlmacenamiento());
    }

    @Override
    public Smartphone inicializarProducto() {
        Scanner sc = new Scanner(System.in);
        this.crearElectronico();
              
        System.out.print("Sistema Operativo del Smartphone: ");
        String so = sc.nextLine();
        this.setSistOperativo(so);
        
        System.out.print("Almacenamiento del Smartphone: ");
        int alm = sc.nextInt();
        sc.nextLine();
        this.setAlmacenamiento(alm);
        
        this.setPrecio(this.calcularPrecioVenta());
        
        return this;
    }
    
}
