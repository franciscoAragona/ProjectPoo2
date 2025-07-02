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
public abstract class Electronico extends Producto{
    public String marca;
    public int mesesGarantia;

    public Electronico() {
    }

    public Electronico(String marca, int mesesGarantia, int id, int cantidad, String name, String tipoProd, double costo, double precio) {
        super(id, cantidad, name, tipoProd, costo, precio);
        this.marca = marca;
        this.mesesGarantia = mesesGarantia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getMesesGarantia() {
        return mesesGarantia;
    }

    public void setMesesGarantia(int mesesGarantia) {
        this.mesesGarantia = mesesGarantia;
    }
    //muestra atributos electronico
    public void mostrarElectronico(){
        this.mostrarProducto();
        System.out.println("Marca:"+this.getMarca()+"; Garantia:"+this.getMesesGarantia()+"meses");
    }
    
    public void crearElectronico(){
        this.crearProducto();
        Scanner sc = new Scanner(System.in);
        String marca = "";
        do {            
            try {
                System.out.print("Marca del Electronico: ");
                marca = sc.nextLine();
                this.setMarca(marca);
                if(marca.equals("")){
                    throw new EntradaVaciaException("No se ingreso ninguna marca");
                }
            } catch (EntradaVaciaException e) {
                System.out.println(e.getMessage());
            }
        } while (marca.trim().equals(""));
        
        int mesesGarantia = -1;
        do {            
            try {
                System.out.print("Meses de garantia del Electronico: ");
                mesesGarantia = sc.nextInt();
                sc.nextLine();
                this.setMesesGarantia(mesesGarantia);
            } catch (InputMismatchException e) {
                System.out.println("Dato incorrecto, ingrese un numero");
                sc.nextLine();
            }
        } while ( mesesGarantia == -1);
        
    }
    
}
