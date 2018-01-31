
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

public class MascotaImpl implements IMascota {

    @Override
    public int insertar(Mascota mascota) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into mascota  values "
                + "(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, mascota.getCodigo()));
        lstPar.add(new Parametro(2, mascota.getNombre()));
        lstPar.add(new Parametro(3, mascota.getSexo()));
        lstPar.add(new Parametro(4, mascota.getRaza()));
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
    public int modificar(Mascota mascota) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE mascota"
                + "   SET codigo=?, nombre=?, sexo=?, raza=?"
                + " where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, mascota.getCodigo()));
        lstPar.add(new Parametro(2, mascota.getNombre()));
        lstPar.add(new Parametro(3, mascota.getSexo()));
        lstPar.add(new Parametro(4, mascota.getRaza()));
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
    public int eliminar(Mascota mascota) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM mascota  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, mascota.getCodigo()));       
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
    public Mascota obtener(int codigo) throws Exception {
        Mascota mascota = null;
        String sql = "SELECT * FROM mascota where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                mascota = new Mascota();
                mascota.setCodigo(rst.getInt(1));
                mascota.setNombre(rst.getString(2));
                mascota.setSexo(rst.getString(3));
                mascota.setRaza(rst.getString(4));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return mascota;
    }

    @Override
    public List<Mascota> obtener() throws Exception {
        List<Mascota> lista = new ArrayList<>();
         String sql = "SELECT * FROM mascota ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Mascota mascota=null;
            while (rst.next()) {
                mascota = new Mascota();
                mascota.setCodigo(rst.getInt(1));
                mascota.setNombre(rst.getString(2));
                mascota.setSexo(rst.getString(3));
                mascota.setRaza(rst.getString(4));
                lista.add(mascota);
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
