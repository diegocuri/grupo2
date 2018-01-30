package unach.edu.ec.veterinaria.vistas;



import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import unach.edu.ec.veterinaria.Entidades.Veterinario;
import unach.edu.ec.veterinaria.dao.IVeterinario;
import unach.edu.ec.veterinaria.impl.VeterinarioImpl;

public class FrmVeterinario extends JInternalFrame{    
    JLabel lblCodigo;
    JLabel lblNombre; 
    JLabel lblTitulo0;
    
    JTextField txtCodigo;
    JTextField txtNombre;

    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmVeterinario() {
        this.setSize(400, 400);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(11, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Veterinario");
        
        lblCodigo= new JLabel("Código:");
        lblNombre= new JLabel("Nombre:");
       

        txtCodigo = new JTextField(2);
        txtNombre= new JTextField(2);
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
      
        pnlCentral.add(lblNombre);
        pnlCentral.add(txtNombre);
                         
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
        
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
    }
    public static void main(String[] args) {
        FrmVeterinario frmMenu= new FrmVeterinario();
        frmMenu.setVisible(true);
    }    
    public void btnAceptarActionListener(ActionEvent e){
        IVeterinario veterinarioDao = new VeterinarioImpl();
        Veterinario veterinario = new Veterinario();
        veterinario.setCodigo(Integer.parseInt(txtCodigo.getText()));
        veterinario.setNombre(txtNombre.getText());
        
        //DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
//        try {                        
//            veterinario.setFecha_nac( formatoFecha.parse(txtFechaNac.getText()));
//            veterinario.setFecha_ing( formatoFecha.parse(txtFechaIng.getText()));
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this,"Error en la fecha!!",
//                "Transacción", JOptionPane.INFORMATION_MESSAGE);
//        }
//        veterinario.setTelefono(txtTelefono.getText());
//        veterinario.setSexo(cmbSexo.getSelectedIndex() == 0 ? "m" : "f");          
//        veterinario.setDireccion(txtDireccion.getText());      
//        
        try {
            if(veterinarioDao.insertar(veterinario)>0){
                JOptionPane.showMessageDialog(this,"Guaradado correctamente!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Error desconocido!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error al guardar!!: " + ex.getMessage(),
                "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
}
 