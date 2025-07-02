/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpoo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Fran
 */
public class CProductos {
    public void cargarTableroProductos(TiendaOnline tienda){
        CConexion oc = new CConexion();
        Connection conexion = null;
        String sql = "SELECT id, cantidad, name, tipoProd, costo FROM TProductos";  
        Statement st = null;
        ResultSet rs = null;

        try {
            conexion = oc.establecerConexion();
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int cantidad = rs.getInt("cantidad");  
                String name = rs.getString("name");
                String tipoProd = rs.getString("tipoProd");
                double costo = rs.getDouble("costo");  
                
                Producto prod = null;

                switch (tipoProd) {
                    case "s": // Smartphone
                        PreparedStatement psSmart = null;
                        ResultSet rsSmart = null;
                        try {
                            String sqlSmart = "SELECT sistOperativo, almacenamiento, marca, mesesGarantia FROM TSmartphone WHERE id = ?";
                            psSmart = conexion.prepareStatement(sqlSmart);
                            psSmart.setInt(1, id);
                            rsSmart = psSmart.executeQuery();
                            if (rsSmart.next()) {
                                String sistOperativo = rsSmart.getString("sistOperativo");
                                int almacenamiento = rsSmart.getInt("almacenamiento");
                                String marca = rsSmart.getString("marca");
                                int mesesGarantia = rsSmart.getInt("mesesGarantia");

                                Smartphone smartphone = new Smartphone();
                                smartphone.setId(id);
                                smartphone.setCantidad(cantidad);
                                smartphone.setName(name);
                                smartphone.setTipoProd(tipoProd);
                                smartphone.setCosto(costo);
                                smartphone.setSistOperativo(sistOperativo);
                                smartphone.setAlmacenamiento(almacenamiento);
                                smartphone.setMarca(marca);
                                smartphone.setMesesGarantia(mesesGarantia);
                                smartphone.setPrecio(smartphone.calcularPrecioVenta()); // Calcular precio de venta
                                prod = smartphone;
                            }
                        } finally {
                            if (rsSmart != null) rsSmart.close();
                            if (psSmart != null) psSmart.close();
                        }
                        break;

                    case "t": // Tv
                        PreparedStatement psTv = null;
                        ResultSet rsTv = null;
                        try {
                            String sqlTv = "SELECT pulg, tipoPantalla, hz, smartTv, marca, mesesGarantia FROM TTv WHERE id = ?";
                            psTv = conexion.prepareStatement(sqlTv);
                            psTv.setInt(1, id);
                            rsTv = psTv.executeQuery();
                            if (rsTv.next()) {
                                double pulg = rsTv.getDouble("pulg");
                                String tipoPantalla = rsTv.getString("tipoPantalla");
                                int hz = rsTv.getInt("hz");
                                String smartTv = rsTv.getString("smartTv");
                                String marca = rsTv.getString("marca");
                                int mesesGarantia = rsTv.getInt("mesesGarantia");

                                Tv tv = new Tv();
                                tv.setId(id);
                                tv.setCantidad(cantidad);
                                tv.setName(name);
                                tv.setTipoProd(tipoProd);
                                tv.setCosto(costo);
                                tv.setPulg(pulg);
                                tv.setTipoPantalla(tipoPantalla);
                                tv.setHz(hz);
                                tv.setSmartTv(smartTv);
                                tv.setMarca(marca);
                                tv.setMesesGarantia(mesesGarantia);
                                tv.setPrecio(tv.calcularPrecioVenta());
                                prod = tv;
                            }
                        } finally {
                            if (rsTv != null) rsTv.close();
                            if (psTv != null) psTv.close();
                        }
                        break;

                    case "c": // Cpu
                        PreparedStatement psCpu = null;
                        ResultSet rsCpu = null;
                        try {
                            String sqlCpu = "SELECT generacion, velocidadGhz, nucleos, marca, mesesGarantia FROM TCpu WHERE id = ?";
                            psCpu = conexion.prepareStatement(sqlCpu);
                            psCpu.setInt(1, id);
                            rsCpu = psCpu.executeQuery();
                            if (rsCpu.next()) {
                                double generacion = rsCpu.getDouble("generacion");
                                double velocidadGhz = rsCpu.getDouble("velocidadGhz");
                                int nucleos = rsCpu.getInt("nucleos");
                                String marca = rsCpu.getString("marca");
                                int mesesGarantia = rsCpu.getInt("mesesGarantia");

                                Cpu cpu = new Cpu();
                                cpu.setId(id);
                                cpu.setCantidad(cantidad);
                                cpu.setName(name);
                                cpu.setTipoProd(tipoProd);
                                cpu.setCosto(costo);
                                cpu.setGeneracion(generacion);
                                cpu.setVelocidadGhz(velocidadGhz);
                                cpu.setNucleos(nucleos);
                                cpu.setMarca(marca);
                                cpu.setMesesGarantia(mesesGarantia);
                                cpu.setPrecio(cpu.calcularPrecioVenta());
                                prod = cpu;
                            }
                        } finally {
                            if (rsCpu != null) rsCpu.close();
                            if (psCpu != null) psCpu.close();
                        }
                        break;

                    case "m": // Mueble
                        PreparedStatement psMueble = null;
                        ResultSet rsMueble = null;
                        try {
                            String sqlMueble = "SELECT tipoMueble, requiereEnsamblaje, material, alto, ancho, profundidad FROM TMueble WHERE id = ?";
                            psMueble = conexion.prepareStatement(sqlMueble);
                            psMueble.setInt(1, id);
                            rsMueble = psMueble.executeQuery();
                            if (rsMueble.next()) {
                                String tipoMueble = rsMueble.getString("tipoMueble");
                                String requiereEnsamblaje = rsMueble.getString("requiereEnsamblaje");
                                String material = rsMueble.getString("material");
                                double alto = rsMueble.getDouble("alto");
                                double ancho = rsMueble.getDouble("ancho");
                                double profundidad = rsMueble.getDouble("profundidad");

                                Mueble mueble = new Mueble();
                                mueble.setId(id);
                                mueble.setCantidad(cantidad);
                                mueble.setName(name);
                                mueble.setTipoProd(tipoProd);
                                mueble.setCosto(costo);
                                mueble.setTipoMueble(tipoMueble);
                                mueble.setRequiereEnsamblaje(requiereEnsamblaje);
                                mueble.setMaterial(material);
                                mueble.setAlto(alto);
                                mueble.setAncho(ancho);
                                mueble.setProfundiad(profundidad);
                                mueble.setPrecio(mueble.calcularPrecioVenta());
                                prod = mueble;
                            }
                        } finally {
                            if (rsMueble != null) rsMueble.close();
                            if (psMueble != null) psMueble.close();
                        }
                        break;

                    default:
                         System.err.println("Tipo de producto desconocido: " + tipoProd + " para ID: " + id);
                        break;
                }

                if (prod != null) {
                    tienda.getStock().getS().add(prod);
                }  
            }
        } catch (Exception e) {
            System.out.println( "Error al cargar productos desde la base de datos: " + e.toString());
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
            } catch (Exception e) {
                System.out.println( "Error al cerrar recursos de la BD: " + e.toString());
            }
            oc.cerrarConexion();  
        }  
    }////**
    
    public int insertarTableroProductos(int cantidad, String name, String tipoProd, Double costo) throws SQLException{
        CConexion o = new CConexion();
        ResultSet rs = null;
        int newid = -1;
        String sql = "INSERT INTO TProductos(cantidad, name, tipoProd, costo) VALUES (?,?,?,?)";
        
        try {
            PreparedStatement ps = o.establecerConexion().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cantidad);
            ps.setString(2, name);
            ps.setString(3, tipoProd);
            ps.setDouble(4, costo);
            
            ps.execute();
            rs = ps.getGeneratedKeys();
            newid = rs.getInt(1);
        } catch (Exception e) {
            System.out.println( "SAFE..FAIL: "+ e.toString());
        }finally{
            o.cerrarConexion();
        }
        return newid;
    }//**
    
    public void insertarSmartphone(Smartphone smartphone) throws SQLException {
        int idProductoBase = insertarTableroProductos(
            smartphone.getCantidad(),
            smartphone.getName(),
            smartphone.getTipoProd(),
            smartphone.getCosto()
        );
        
        if (idProductoBase != -1) {
            smartphone.setId(idProductoBase);
            CConexion o = new CConexion();
            Connection conexion = null;
            PreparedStatement ps = null;
            String sql = "INSERT INTO TSmartphone(id, sistOperativo, almacenamiento, marca, mesesGarantia) VALUES (?,?,?,?,?)";
            try {
                conexion = o.establecerConexion();
                ps = conexion.prepareStatement(sql);
                ps.setInt(1, idProductoBase); // Usa el ID de TProductos como FK
                ps.setString(2, smartphone.getSistOperativo());
                ps.setInt(3, smartphone.getAlmacenamiento());
                ps.setString(4, smartphone.getMarca());
                ps.setInt(5, smartphone.getMesesGarantia());
                ps.executeUpdate();
            } catch (Exception e) { 
                e.printStackTrace();
            } finally {
             try {
                 if (ps != null) ps.close();
                 if (conexion != null) conexion.close();
             } catch (Exception e) {
                 System.out.println( "Error al cerrar recursos de la BD (Smartphone): " + e.toString());
             }
         }
        }
    }//**

    public void insertarTv(Tv tv) throws SQLException {
        int idProductoBase = insertarTableroProductos(
            tv.getCantidad(),
            tv.getName(),
            tv.getTipoProd(),
            tv.getCosto()
        );

        if (idProductoBase != -1) {
            tv.setId(idProductoBase);
            CConexion o = new CConexion();
            Connection conexion = null;
            PreparedStatement ps = null;
            String sql = "INSERT INTO TTv(id, pulg, tipoPantalla, hz, smartTv, marca, mesesGarantia) VALUES (?,?,?,?,?,?,?)";
            try {
                conexion = o.establecerConexion();
                ps = conexion.prepareStatement(sql);
                ps.setInt(1, idProductoBase); // Usa el ID de TProductos como FK
                ps.setDouble(2, tv.getPulg());
                ps.setString(3, tv.getTipoPantalla());
                ps.setInt(4, tv.getHz());
                ps.setString(5, tv.getSmartTv());
                ps.setString(6, tv.getMarca());
                ps.setInt(7, tv.getMesesGarantia());
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println( "SAFE..FAIL inserting TTv: " + e.toString());
                e.printStackTrace();
            } finally {
                try {
                    if (ps != null) ps.close();
                    if (conexion != null) conexion.close();
                    o.cerrarConexion();
                } catch (Exception e) {
                    System.out.println( "Error al cerrar recursos de la BD (TV): " + e.toString());
                }
            }
        }
    }//**

    public void insertarCpu(Cpu cpu) throws SQLException {
        int idProductoBase = insertarTableroProductos(
            cpu.getCantidad(),
            cpu.getName(),
            cpu.getTipoProd(),
            cpu.getCosto()
        );
        if (idProductoBase != -1) {
            cpu.setId(idProductoBase);
            CConexion o = new CConexion();
            Connection conexion = null;
            PreparedStatement ps = null;
            String sql = "INSERT INTO TCpu(id, generacion, velocidadGhz, nucleos, marca, mesesGarantia) VALUES (?,?,?,?,?,?)";
            try {
                conexion = o.establecerConexion();
                ps = conexion.prepareStatement(sql);
                ps.setInt(1, idProductoBase); // Usa el ID de TProductos como FK
                ps.setDouble(2, cpu.getGeneracion());
                ps.setDouble(3, cpu.getVelocidadGhz());
                ps.setInt(4, cpu.getNucleos());
                ps.setString(5, cpu.getMarca());
                ps.setInt(6, cpu.getMesesGarantia());
                ps.executeUpdate();
                } catch (Exception e) {
                System.out.println( "SAFE..FAIL inserting TCpu: " + e.toString());
                e.printStackTrace();
            } finally {
                try {
                    if (ps != null) ps.close();
                    if (conexion != null) conexion.close();
                } catch (Exception e) {
                    System.out.println( "Error al cerrar recursos de la BD (CPU): " + e.toString());
                }
            }
        }
    }//**

    public void insertarMueble(Mueble mueble) throws SQLException {
        int idProductoBase = insertarTableroProductos(
            mueble.getCantidad(),
            mueble.getName(),
            mueble.getTipoProd(),
            mueble.getCosto()
        );
 
        if (idProductoBase != -1) {
            mueble.setId(idProductoBase);
            CConexion o = new CConexion();
            Connection conexion = null;
            PreparedStatement ps = null;
            String sql = "INSERT INTO TMueble(id, tipoMueble, requiereEnsamblaje, material, alto, ancho, profundidad) VALUES (?,?,?,?,?,?,?)";
            try {
                conexion = o.establecerConexion();
                ps = conexion.prepareStatement(sql);
                ps.setInt(1, idProductoBase); // Usa el ID de TProductos como FK
                ps.setString(2, mueble.getTipoMueble());
                ps.setString(3, mueble.getRequiereEnsamblaje());
                ps.setString(4, mueble.getMaterial());
                ps.setDouble(5, mueble.getAlto());
                ps.setDouble(6, mueble.getAncho());
                ps.setDouble(7, mueble.getProfundiad()); // Ojo aquí, usé getProfundiad()
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println( "SAFE..FAIL inserting TMueble: " + e.toString());
                e.printStackTrace();
            } finally {
                try {
                    if (ps != null) ps.close();
                    if (conexion != null) conexion.close();
                } catch (Exception e) {
                    System.out.println( "Error al cerrar recursos de la BD (Mueble): " + e.toString());
                }
            }
        }
    }//**
    
    public void modificarTableroProductos(int id, int cantidad, String name, String tipoProd, Double costo){
        CConexion o = new CConexion();
        String sql = "UPDATE TProductos SET cantidad = ?, name = ?, tipoProd = ?, costo = ? WHERE id = ?;";
        
        try {
            PreparedStatement ps = o.establecerConexion().prepareStatement(sql);
           
            ps.setInt(1, cantidad);
            ps.setString(2, name);
            ps.setString(3, tipoProd);
            ps.setDouble(4, costo);
            ps.setInt(5, id);
            
            ps.execute();
            
        } catch (Exception e) {
            System.out.println( "MODIFY..FAIL: "+ e.toString());
        }finally{
            o.cerrarConexion();
        }
    
    }//**
    
     public void eliminarTableroProductos(int id){
        CConexion o = new CConexion();
        String sql = "DELETE FROM TProductos WHERE id = ?;";
        
        try {
            PreparedStatement ps = o.establecerConexion().prepareStatement(sql);
            ps.setInt(1, id);
            
            ps.execute();
             
        } catch (Exception e) {
            System.out.println( "DELETE..FAIL: "+ e.toString());
        }finally{
            o.cerrarConexion();
        }
    }//**
}
