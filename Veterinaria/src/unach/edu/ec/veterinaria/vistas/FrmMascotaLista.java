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
public class FrmMascotaLista extends JInternalFrame{
    
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    public FrmMascotaLista(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        this.setBackground(Color.getHSBColor(100,60,270).brighter());
        lblTitulo=new JLabel("Lista de Mascotas");
        tabla= new JTable();
        this.add(lblTitulo,BorderLayout.NORTH);
        this.add(tabla,BorderLayout.NORTH);
        cargarTabla();        
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Sexo");
        modelo.addColumn("Raza");
        
        List<Mascota> list = new ArrayList<>();
        try {
            IMascota mascotaDao= new MascotaImpl();
            list = mascotaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        for(Mascota masc : list){
            modelo.addRow(new Object[]{masc.getCodigo(),masc.getNombre(),masc.getSexo(),masc.getRaza().toString()});
        }
        tabla.setModel(modelo);
    }
}