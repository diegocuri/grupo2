package unach.edu.ec.veterinaria.vistas;

import unach.edu.ec.veterinaria.Entidades.*;
import unach.edu.ec.veterinaria.dao.*;
import unach.edu.ec.veterinaria.impl.*;
import unach.edu.ec.veterinaria.accessodatos.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author FABRICIO CONSTANTE
 */ 
public class FrmMascota extends JInternalFrame{
    JLabel lblTitulo1,lblTitulo2,lblTitulo3;
   
    JLabel lblSexo;
    JLabel lblTitulo0;
    
    JTextField txtTitulo1,txtTitulo2,txtTitulo3;
    
    JComboBox cmbSexo;
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmMascota() {
        this.setSize(200,200);
        this.setLayout(new BorderLayout());
     
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(4, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("DATOS DE LA MASCOTA");
        
        lblTitulo1= new JLabel("CODIGO:");
        lblTitulo2= new JLabel(" NOMBRE:");
        lblSexo = new JLabel("SEXO:");
        lblTitulo3= new JLabel("RAZA:");
        
        txtTitulo1 = new JTextField(2);
        txtTitulo2= new JTextField(2);
        cmbSexo= new JComboBox(new String[]{"macho","hembra"});
        txtTitulo3= new JTextField(2);

        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblTitulo1);
        pnlCentral.add(txtTitulo1);
        pnlCentral.add(lblTitulo2);
        pnlCentral.add(txtTitulo2);
         pnlCentral.add(lblSexo);
        pnlCentral.add(cmbSexo);
        pnlCentral.add(lblTitulo3);
        pnlCentral.add(txtTitulo3);
        
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
        FrmMascota frmMenu= new FrmMascota();
        frmMenu.setVisible(true);
    } 
    public void btnAceptarActionListener(ActionEvent e){
       try {
            Mascota mascota = new Mascota();
            mascota.setCodigo(Integer.parseInt(txtTitulo1.getText()));
            mascota.setNombre(txtTitulo2.getText());
            mascota.setSexo(cmbSexo.getSelectedIndex()==1 ? "m" : "f");
            mascota.setRaza(txtTitulo3.getText());
            IMascota mascotaDao = new MascotaImpl();
            
            if(mascotaDao.insertar(mascota)>0){
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
}