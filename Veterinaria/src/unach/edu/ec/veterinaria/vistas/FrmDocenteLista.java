package unach.edu.ec.veterinaria.vistas;


import ec.edu.unach.sicoa.rnegocio.dao.*;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import ec.edu.unach.sicoa.rnegocio.impl.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmDocenteLista extends JInternalFrame{
    
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    public FrmDocenteLista(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        this.setBackground(Color.getHSBColor(100,60,272).brighter());
        lblTitulo=new JLabel("Lista de Docentes");
        tabla= new JTable();
        this.add(lblTitulo,BorderLayout.NORTH);
        this.add(tabla,BorderLayout.NORTH);
        cargarTabla();        
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Fecha de Nacimiento");
        modelo.addColumn("Fecha de Ingreso");
        modelo.addColumn("Sexo");
        modelo.addColumn("Categoria");
        modelo.addColumn("Salario");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        
        List<Docente> list = new ArrayList<>();
        try {
            IDocente docenteDao= new DocenteImp();
            list = docenteDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error Listado",JOptionPane.ERROR_MESSAGE);
        }
        for(Docente doc : list){
            modelo.addRow(new Object[]{doc.getCodigo(),doc.getCedula(),doc.getNombre(),doc.getApellidos(),
                doc.getFecha_nac(),doc.getFecha_ing(),doc.getSexo(),doc.getCategoria(),doc.getSalario(),doc.getDireccion(),
                        doc.getTelefono()});
        }
        tabla.setModel(modelo);
    }
}