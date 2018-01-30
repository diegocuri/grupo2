 
package unach.edu.ec.veterinaria.vistas;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import unach.edu.ec.veterinaria.Entidades.Veterinario;
import unach.edu.ec.veterinaria.dao.IVeterinario;
import unach.edu.ec.veterinaria.impl.VeterinarioImpl;


public class FrmListaVeterinario extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    
    public FrmListaVeterinario(){
    
        this.setSize(800,600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo=new JLabel ("Listado de Veterinarios");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla,BorderLayout.CENTER);
        cargarTabla();
    }
    public void cargarTabla(){
        
        
   
        
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
   
        
        List<Veterinario> lista= new ArrayList<>();
        try{
            IVeterinario veterinarioDao = new VeterinarioImpl();
            lista= veterinarioDao.obtener();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE
            );
            
        }
        

        
        for (Veterinario doc : lista){
            modelo.addRow(new Object[] { doc.getCodigo(), doc.getNombre(), });
            
        }
        
        tabla.setModel(modelo);
    }
}
