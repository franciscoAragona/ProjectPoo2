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
public class Tv extends Electronico implements GenerarProducto<Tv>{
    private double pulg;
    private String tipoPantalla;
    private int hz;
    private String smartTv;

    public Tv() {
    }

    public Tv(double pulg, String tipoPantalla, int hz, String smartTv, String marca, int mesesGarantia, int id, int cantidad, String name, String tipoProd, double costo, double precio) {
        super(marca, mesesGarantia, id, cantidad, name, tipoProd, costo, precio);
        this.pulg = pulg;
        this.tipoPantalla = tipoPantalla;
        this.hz = hz;
        this.smartTv = smartTv;
    }


    public double getPulg() {
        return pulg;
    }

    public void setPulg(double pulg) {
        this.pulg = pulg;
    }

    public String getTipoPantalla() {
        return tipoPantalla;
    }

    public void setTipoPantalla(String tipoPantalla) {
        this.tipoPantalla = tipoPantalla;
    }

    public int getHz() {
        return hz;
    }

    public void setHz(int hz) {
        this.hz = hz;
    }

    public String getSmartTv() {
        return smartTv;
    }

    public void setSmartTv(String smartTv) {
        this.smartTv = smartTv;
    }
    //implementacion abstract metod()
    @Override
    double calcularPrecioVenta() {return this.getCosto()*1.25;}
    //implementacion abstract metod()
    @Override
    void mostrarDetalles() {
        this.mostrarElectronico();
        System.out.println("Pulgadas:"+this.getPulg()+"; Tipo de pantalla:"+this.getTipoPantalla()+"; Hz:"+this.getHz()+"; Es SmartTv:"+this.getSmartTv());
    }

    @Override
    public Tv inicializarProducto() {
        Scanner sc = new Scanner(System.in);
        this.crearElectronico();
        
        Double pulg = -1.0;
        do {            
            try {
                System.out.print("Tamaño en pulgadas de la pantalla: ");
                pulg = sc.nextDouble();
                sc.nextLine(); 
                this.setPulg(pulg);
            } catch (InputMismatchException e) {
                System.out.println("Dato incorrecto, ingrese un numero");
                sc.nextLine();
            }
        } while (pulg == -1.0); 
        
        
        String tipoPantalla = "";
        do {            
            try {
                System.out.print("Tipo de pantalla (ej: LED, OLED): ");
                tipoPantalla = sc.nextLine();
                this.setTipoPantalla(tipoPantalla);
                if(tipoPantalla.equals("")){
                    throw new EntradaVaciaException("No se ingreso el tipo de pantalla");
                }
            } catch (EntradaVaciaException e) {
                System.out.println(e.getMessage());
            }
        } while (tipoPantalla.trim().equals(""));
        
        int hz = -1;
        do {            
            try {
                System.out.print("Frecuencia de actualización (Hz): ");
                hz = sc.nextInt();
                sc.nextLine(); // limpiar buffer
                this.setHz(hz); 
            } catch (InputMismatchException e) {
                System.out.println("Dato incorrecto, ingrese un numero");
                sc.nextLine();
            }
        } while (hz == -1); 
        
        
        String smartTv = "";
        do {            
            try {
                System.out.print("¿Es Smart TV? (si/no): ");
                smartTv = sc.nextLine();
                this.setSmartTv(smartTv);
                if(!smartTv.equals("si") && !smartTv.equals("no")){
                    throw new ValorFueraDeRangoException("Ingrese si o no");
                }
            } catch (ValorFueraDeRangoException e) {
                System.out.println(e.getMessage());
                smartTv = "";
            }
        } while (smartTv.trim().equals(""));
        
        this.setPrecio(this.calcularPrecioVenta());
        
        return this;
    }
    
    
}
