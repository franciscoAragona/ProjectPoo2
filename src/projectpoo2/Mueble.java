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
public class Mueble extends Hogar implements GenerarProducto<Mueble>{
    private String tipoMueble;
    private String requiereEnsamblaje;

    public Mueble() {
    }

    public Mueble(String tipoMueble, String requiereEnsamblaje, String material, double alto, double ancho, double profundiad, int id, int cantidad, String name, String tipoProd, double costo, double precio) {
        super(material, alto, ancho, profundiad, id, cantidad, name, tipoProd, costo, precio);
        this.tipoMueble = tipoMueble;
        this.requiereEnsamblaje = requiereEnsamblaje;
    }

    public String getTipoMueble() {
        return tipoMueble;
    }

    public void setTipoMueble(String tipoMueble) {
        this.tipoMueble = tipoMueble;
    }

    public String getRequiereEnsamblaje() {
        return requiereEnsamblaje;
    }

    public void setRequiereEnsamblaje(String requiereEnsamblaje) {
        this.requiereEnsamblaje = requiereEnsamblaje;
    }
    
    @Override
    double calcularPrecioVenta() {return this.getCosto()*1.20;}

    @Override
    void mostrarDetalles() {
        this.mostrarHogar();
        System.out.println("Requiere ensamblaje:"+this.getRequiereEnsamblaje());
    }

    @Override
    public Mueble inicializarProducto() {
        Scanner sc = new Scanner(System.in);
        this.crearHogar();
        
        System.out.print("¿Requiere ensamblaje? (true/false): ");
        String requiereEnsamblaje = sc.nextLine();
        this.setRequiereEnsamblaje(requiereEnsamblaje);

        this.setPrecio(this.calcularPrecioVenta());
        
        return this;
    }
    
    
}
