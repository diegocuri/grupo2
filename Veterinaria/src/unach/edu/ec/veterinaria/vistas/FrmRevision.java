package unach.edu.ec.veterinaria.vistas;

import unach.edu.ec.veterinaria.Entidades.*;
import unach.edu.ec.veterinaria.dao.*;
import unach.edu.ec.veterinaria.impl.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
/**
 *
 * @author FABRICIO CONSTANTE
 */
public class FrmRevision extends JInternalFrame{
    JLabel lblTitulo0,lblTitulo1,lblTitulo2,lblMascota,lblVeterinario;
   
    JTextField txtTitulo1,txtTitulo2;
    
    JComboBox cmbMascota,cmbVeterinario;
    JButton btnLimpiar;
    JButton btnAceptar;
    
    List<Mascota> lstrevision1;
    JComboBox<Mascota> cmbRevision1;
    List<Veterinario> lstrevision2;
    JComboBox<Veterinario> cmbRevision2;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmRevision() {
        this.setSize(200,200);
        this.setLayout(new BorderLayout());
     
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(5, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("DATOS DE LA REVISION");
        
        lblTitulo1= new JLabel("CODIGO:");
        lblTitulo2= new JLabel("DESCRIPCION:");

        cargarMascotas();  
        cmbRevision1=new JComboBox(lstrevision1.toArray());
        lblMascota=new JLabel("MASCOTA");
        cargarVeterinarios();  
        cmbRevision2=new JComboBox(lstrevision2.toArray());
        lblVeterinario=new JLabel("VETERINARIO");
        txtTitulo1 = new JTextField(2);
        txtTitulo2= new JTextField(2);

        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblTitulo1);
        pnlCentral.add(txtTitulo1);
        pnlCentral.add(lblMascota);
        pnlCentral.add(cmbRevision1);
        pnlCentral.add(lblVeterinario);
        pnlCentral.add(cmbRevision2);
        pnlCentral.add(lblTitulo2);
        pnlCentral.add(txtTitulo2);
        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
        
        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);
        pnlCentral.setBackground(Color.getHSBColor(100,60,270).brighter());
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);  
        this.setClosable(true);        
        
    }
    public static void main(String[] args) {
        FrmRevision frmMenu= new FrmRevision();
        frmMenu.setVisible(true);
    } 
    public void btnAceptarActionListener(ActionEvent e){
        
        try {
            
            Revision revision = new Revision();
            revision.setCodigo(Integer.parseInt(txtTitulo1.getText()));
            revision.setMascota((Mascota)cmbRevision1.getSelectedItem());
            revision.setVeterinario((Veterinario)cmbRevision2.getSelectedItem());
            revision.setDescripcion(txtTitulo2.getText());

            IRevision revisionDao = new RevisionImpl();
            
            if(revisionDao.insertar(revision)>0){
                JOptionPane.showMessageDialog(this,"Registro Correcto!!",
                        "Transacción correcta",JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(this,"Error de Guardado!!",
                "ERROR", JOptionPane.ERROR_MESSAGE); 
            }
            
            
        } catch (Exception x) {
              JOptionPane.showMessageDialog(this,"Proceso incorrecto!!" + x.getMessage(),
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            
        }
      
    }
        public void cargarMascotas() {
        try {
       IMascota revision=new MascotaImpl();
       lstrevision1=revision.obtener();
   
        } catch (Exception e) {System.out.println("ERROR"+e.getMessage());
        }
 
    }
        public void cargarVeterinarios() {
        try {
       IVeterinario revision=new VeterinarioImpl();
       lstrevision2=revision.obtener();
   
        } catch (Exception e) {System.out.println("ERROR"+e.getMessage());
        }
 
    }
}

