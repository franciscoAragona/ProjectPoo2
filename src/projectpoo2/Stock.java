/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpoo2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Fran
 */
public class Stock {
    private int id;
    private ArrayList<Producto> s = new ArrayList(); 
    private CProductos objCProductos = new CProductos();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Producto> getS() {
        return s;
    }

    public void setS(ArrayList<Producto> s) {
        this.s = s;
    }

    public CProductos getObjCProductos() {
        return objCProductos;
    }

    public void setObjCProductos(CProductos objCProductos) {
        this.objCProductos = objCProductos;
    }
    
    public boolean hayStock(Stock stock, Producto p, int cantidadRequerida){
        try {
            for(Producto prod: stock.getS()){
                if(prod.getId() == p.getId()){
                    if(prod.getCantidad() >= cantidadRequerida){
                        return true;                     
                    }else{
                        return false;
                    }
                }
            }    
        } catch (Exception e) {
            System.out.println("!!!hayStock()" + e.toString());
        }
        return false;
        
    }
    
    public void actualizarStock(TiendaOnline t, Producto prod){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Actuliza cantidad de: " + prod.getName());
            int cant = sc.nextInt();
            for(Producto p: t.getStock().getS()){
                if(p.getId() == prod.getId()){
                    p.setCantidad(cant);
                    t.modificarProductos(p.getId(), p.getName(),p.getTipoProd(), p.getCosto(), p.getCantidad());
                }
            }   
        } catch (Exception e) {
            System.out.println("!!!actualizarStock()" + e.toString());
        }
    }//  **|*
    
    public void stockMenu(TiendaOnline tienda){
        this.getObjCProductos().cargarTableroProductos(tienda);
    }
            
    public void createStock(TiendaOnline t) throws SQLException{
        Scanner sc = new Scanner(System.in);
        boolean answ = true ;
        int op = -1;
        while (answ) {            
            do {                
                try {
                    System.out.println("que tipo de producto se va a agregar a el Stock?");
                    System.out.println("1. Smartphone");
                    System.out.println("2. Tv");
                    System.out.println("3. Cpu");
                    System.out.println("4. Mueble");
                    System.out.println("5. salir");
                    op = sc.nextInt();
                    if(op<1 || op>5){
                        throw new ValorFueraDeRangoException("Ingrese un valor entero entre 1 y 5");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Dato incorrecto, ingrese un numero");
                    sc.nextLine();
                }catch(ValorFueraDeRangoException v){
                    System.out.println(v.getMessage());
                    op = -1;
                }
            } while (op ==-1);
            
            
            switch (op) {
                case 1:
                    Smartphone smartphone = new Smartphone();
                    smartphone.inicializarProducto();
                    smartphone.setTipoProd("s");
                    objCProductos.insertarSmartphone(smartphone);
                    this.getS().add(smartphone);
                    break;
                case 2:
                    Tv tv = new Tv();
                    tv.inicializarProducto();
                    tv.setTipoProd("t");
                    objCProductos.insertarTv(tv);
                    this.getS().add(tv);
                    break;
                case 3:
                    Cpu cpu = new Cpu();
                    cpu.inicializarProducto();
                    cpu.setTipoProd("c");
                    objCProductos.insertarCpu(cpu);
                    this.getS().add(cpu);
                    break;
                case 4:
                    Mueble mueble = new Mueble();
                    mueble.inicializarProducto();
                    mueble.setTipoProd("m");
                    objCProductos.insertarMueble(mueble);
                    this.getS().add(mueble);
                    break;
                case 5:
                    answ = false;
                    break;
            }
        }    
    }//  **|*
}
