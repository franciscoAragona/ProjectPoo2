/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpoo2;

import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Fran
 */
public class Cliente {
    private int id;
    private String cell;
    private String name;
    private Carrito carrito = new Carrito();

    public Cliente() {
    }

    public Cliente(int id, String cell, String name) {
        this.id = id;
        this.cell = cell;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }
    
    public void verCarrito(){ 
        for(Producto p: this.getCarrito().getS()){
            p.mostrarProducto();
        }
    }
    
    public void agregarAlCarrito(TiendaOnline t, Producto prod, int cant){
        if(t.getStock().hayStock(t.getStock(), prod, cant)){
            t.modificarProductos(prod.getId(), prod.getName(),prod.getTipoProd(), prod.getCosto(), prod.getCantidad() - cant);
            for(int i = 1; i <= cant; i ++){
                this.getCarrito().getS().add(prod);
            }
            this.getCarrito().setTotal(this.getCarrito().getTotal() + prod.getPrecio()*cant);
        }else{
            System.out.println("No hay suficiente cantidad de "+prod.getName()+" para el carrito");           
        }
    }//**
    
    public void eliminarDelCarrito(TiendaOnline t, Producto prod, int cant){
        try {
            for(int i = 1; i <= cant; i ++){
                this.getCarrito().getS().remove(prod);
            }
            for(Producto p: t.getStock().getS()){
                if(p.getId() == prod.getId()){
                    t.modificarProductos(prod.getId(), prod.getName(),prod.getTipoProd(), prod.getCosto(), prod.getCantidad() + cant);
                    this.getCarrito().setTotal(this.getCarrito().getTotal() - prod.getPrecio()*cant);
                }
            }    
        } catch (Exception e) {
            System.out.println("Problema al eliminar producto del carrito");
        }     
    }//**
    
    public void vaciarCarrito(TiendaOnline t){
        
        try {
            if(!this.getCarrito().getS().isEmpty()){
                ArrayList<Producto> auxArray =(ArrayList<Producto>) this.getCarrito().getS().clone();
                Producto auxProd = null;
                for(Producto p: auxArray){
                    if(p != auxProd || p == null ){
                        auxProd = p;
                        int cant = Collections.frequency(this.getCarrito().getS(), p);
                        this.eliminarDelCarrito(t, auxProd, cant);
                    }
                }
                this.getCarrito().getS().clear();
                this.getCarrito().setTotal(0);
            }    
        } catch (Exception e) {
            System.out.println("Error de carrito");
        }
        
        
    }//*
    
    public void realizarCompra(){
        this.verCarrito();
        System.out.println("Total $"+this.getCarrito().getTotal());
    }//*
}
