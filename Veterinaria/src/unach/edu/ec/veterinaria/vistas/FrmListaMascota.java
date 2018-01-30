
package unach.edu.ec.veterinaria.vistas;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import unach.edu.ec.veterinaria.Entidades.Mascota;
import unach.edu.ec.veterinaria.dao.IMascota;
import unach.edu.ec.veterinaria.impl.MascotaImpl;

public class FrmListaMascota extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    
    public FrmListaMascota(){
    
        this.setSize(800,600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo=new JLabel ("Listado de Mascotas");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla,BorderLayout.CENTER);
        cargarTabla();
    }
    public void cargarTabla(){

        
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Sexo");
        modelo.addColumn("Raza");

        
        List<Mascota> lista= new ArrayList<>();
        try{
            IMascota mascotaDao = new MascotaImpl();
            lista= mascotaDao.obtener();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE
            );
            
        }
        
        for (Mascota mas : lista){
            modelo.addRow(new Object[] { mas.getCodigo(), mas.getNombre(), mas.getSexo(), mas.getRaza()});
            
        }
        
        tabla.setModel(modelo);
    }
}
