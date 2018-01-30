
package unach.edu.ec.veterinaria.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author WILCXMAC
 */

public class FmrMateria extends JInternalFrame{
       JLabel lblTitulo1,lblTitulo2;
    JLabel lblGenero;
    JLabel lblTitulo0;
    
    JTextField txtTitulo1,txtTitulo2;

    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FmrMateria() {
        
        this.setSize(250,160);
        this.setLayout(new BorderLayout());
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(2, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("MATERIA");
        
        lblTitulo1= new JLabel(" NOMBRE:");
        lblTitulo2= new JLabel("CODIGO:");
 
        

        txtTitulo1 = new JTextField(2);
        txtTitulo2= new JTextField(2);


        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblTitulo1);
        pnlCentral.add(txtTitulo1);
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
        
    }
    public static void main(String[] args) {
        FrmMascota frmMenu= new FrmMascota();
        frmMenu.setVisible(true);
    } 
    
    public void btnAceptarActionListener(ActionEvent e){
        JOptionPane.showMessageDialog(this,"Proceso correcto!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
    }
 
}
