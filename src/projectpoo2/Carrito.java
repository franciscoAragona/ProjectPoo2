/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpoo2;

import java.util.ArrayList;

/**
 *
 * @author Fran
 */
public class Carrito {
    private int id;
    private double total;
    private ArrayList<Producto> s = new ArrayList();

    public Carrito() {
    }

    public Carrito(int id, double total, ArrayList<Producto>  s) {
        this.id = id;
        this.total = total;
        this.s = s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Producto>  getS() {
        return s;
    }

    public void setS(ArrayList<Producto>  s) {
        this.s = s;
    }
    
}
