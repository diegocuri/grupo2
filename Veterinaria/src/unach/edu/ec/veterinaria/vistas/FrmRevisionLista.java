package unach.edu.ec.veterinaria.vistas;

import unach.edu.ec.veterinaria.Entidades.*;
import unach.edu.ec.veterinaria.dao.*;
import unach.edu.ec.veterinaria.impl.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author FABRICIO CONSTANTE
 */
public class FrmRevisionLista extends JInternalFrame{
    
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    public FrmRevisionLista(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        this.setBackground(Color.getHSBColor(100,60,270).brighter());
        lblTitulo=new JLabel("Lista de Revisions");
        tabla= new JTable();
        this.add(lblTitulo,BorderLayout.NORTH);
        this.add(tabla,BorderLayout.NORTH);
        cargarTabla();        
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Mascota");
        modelo.addColumn("Veterinario");
        modelo.addColumn("Descripcion");
        modelo.addRow(new Object[]{"CODIGO","COD MASCOTA","COD VETERINARIO","DESCRIPCION"});
        List<Revision> list = new ArrayList<>();
        try {
            IRevision revisionDao= new RevisionImpl();
            list = revisionDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        for(Revision rev : list){
            modelo.addRow(new Object[]{rev.getCodigo(),rev.getMascota(),rev.getVeterinario(),rev.getDescripcion().toString()});
        }
        tabla.setModel(modelo);
    }
}