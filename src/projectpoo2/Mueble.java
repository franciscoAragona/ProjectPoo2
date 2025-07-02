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
    //implementacion abstract metod()
    @Override
    double calcularPrecioVenta() {return this.getCosto()*1.20;}
    //implementacion abstract metod()
    @Override
    void mostrarDetalles() {
        this.mostrarHogar();
        System.out.println("Requiere ensamblaje:"+this.getRequiereEnsamblaje());
    }

    @Override
    public Mueble inicializarProducto() {
        Scanner sc = new Scanner(System.in);
        this.crearHogar();
        
        String tipoMueble = "";
        do {            
            try {
                System.out.print("¿Que tipo de mueble es?");
                tipoMueble = sc.nextLine();
                this.setTipoMueble(tipoMueble);
                if(tipoMueble.equals("")){
                    throw new EntradaVaciaException("No se ingreso ningun tipo de mueble");
                }
            } catch (EntradaVaciaException e) {
                System.out.println(e.getMessage());
            }
            
        } while (tipoMueble.trim().equals(""));
        
        String requiereEnsamblaje = "";
        do {            
            try {
                System.out.print("¿Requiere ensamblaje? (si/no): ");
                requiereEnsamblaje = sc.nextLine();
                this.setRequiereEnsamblaje(requiereEnsamblaje);
                if(!requiereEnsamblaje.equals("si") && !requiereEnsamblaje.equals("no")){
                    throw new ValorFueraDeRangoException("Ingrese si o no");
                }
            } catch (ValorFueraDeRangoException e) {
                System.out.println(e.getMessage());
                requiereEnsamblaje = "";
            }
        } while (requiereEnsamblaje.trim().equals("")); 
        this.setPrecio(this.calcularPrecioVenta());
        return this;
    }
    
    
}
