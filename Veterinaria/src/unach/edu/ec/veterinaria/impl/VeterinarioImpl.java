
package unach.edu.ec.veterinaria.impl;
import unach.edu.ec.veterinaria.accessodatos.*;
import unach.edu.ec.veterinaria.Entidades.*;
import unach.edu.ec.veterinaria.dao.*;
import com.sun.javafx.tk.FocusCause;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author FABRICIO CONSTANTE
 */

public class VeterinarioImpl implements IVeterinario {

    @Override
    public int insertar(Veterinario veterinario) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into veterinario  values "
                + "(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, veterinario.getCodigo()));
        lstPar.add(new Parametro(2, veterinario.getNombre()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Veterinario veterinario) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE veterinario"
                + "   SET codigo=?, nombre=?, sexo=?, raza=?"
                + " where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, veterinario.getCodigo()));
        lstPar.add(new Parametro(2, veterinario.getNombre()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Veterinario veterinario) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM veterinario  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, veterinario.getCodigo()));       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public Veterinario obtener(int codigo) throws Exception {
        Veterinario veterinario = null;
        String sql = "SELECT * FROM veterinario where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                veterinario = new Veterinario();
                veterinario.setCodigo(rst.getInt(1));
                veterinario.setNombre(rst.getString(2));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return veterinario;
    }

    @Override
    public List<Veterinario> obtener() throws Exception {
        List<Veterinario> lista = new ArrayList<>();
         String sql = "SELECT * FROM veterinario ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Veterinario veterinario=null;
            while (rst.next()) {
                veterinario = new Veterinario();
                veterinario.setCodigo(rst.getInt(1));
                veterinario.setNombre(rst.getString(2));
                lista.add(veterinario);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }
}