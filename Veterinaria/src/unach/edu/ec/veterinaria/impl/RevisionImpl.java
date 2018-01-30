
package unach.edu.ec.veterinaria.impl;
import unach.edu.ec.veterinaria.dao.IMascota;
import unach.edu.ec.veterinaria.dao.IRevision;
import unach.edu.ec.veterinaria.dao.IVeterinario;
import unach.edu.ec.veterinaria.accessodatos.Conexion;
import unach.edu.ec.veterinaria.accessodatos.Parametro;
import unach.edu.ec.veterinaria.Entidades.Veterinario;
import unach.edu.ec.veterinaria.Entidades.Revision;
import unach.edu.ec.veterinaria.Entidades.Mascota;
import java.sql.ResultSet;
import java.util.*;


public class RevisionImpl implements IRevision{

    @Override
    public int insertar(Revision revision) throws Exception{
        int numFilasAfectadas=0;
        String sql="instert into revision values (?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, revision.getCodigo()));
        lstPar.add(new Parametro(2, revision.getMascota()));
        lstPar.add(new Parametro(3, revision.getVeterinario()));
        lstPar.add(new Parametro(4, revision.getDescripcion()));

        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            numFilasAfectadas=con.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            throw e;
        }finally {
            if(con!=null)
            con.desconectar();
        }
        return numFilasAfectadas;
    }
    @Override
    public Revision obtener(int codigo) throws Exception{
        Revision revision = null;
        String sql="SELECT * FROM revision where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()){
                revision = new Revision();
                revision.setCodigo(rst.getString(1));
                IVeterinario veterinariodao = new VeterinarioImpl();
                Veterinario veterinario = veterinariodao.obtener(rst.getInt(2));
                IMascota mascotadao = new MascotaImpl();
                Mascota mascota = mascotadao.obtener(rst.getInt(10));
                revision.setMascota(mascota);

            }
        }catch (Exception e) {
            throw e;
        }finally {
            if(con!=null)
            con.desconectar();
        }
        return revision;
    }
    @Override
    public List<Revision> obtener() throws Exception{
        List<Revision> lista = new ArrayList<>();
        String sql="SELECT *  FROM revision";
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Revision revision = null;
            while (rst.next()){
                revision = new Revision();
                revision.setCodigo(rst.getString(1));
                IMascota mascotadao = new MascotaImpl();
                Mascota mascota = mascotadao.obtener(rst.getInt(2));
                revision.setMascota(mascota);
                IVeterinario veterinariodao = new VeterinarioImpl();
                Veterinario veterinario = veterinariodao.obtener(rst.getInt(3));
                revision.setVeterinario(veterinario);
                revision.setDescripcion(rst.getString(4));
            }
        }catch (Exception e) {
            throw e;
        }finally {
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }  
}