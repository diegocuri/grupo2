package unach.edu.ec.veterinaria.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 *
 * @author FABRICIO YAMBAY
 */ 
public class FrmMenuPrincipal extends JFrame {

    JMenuBar mnbPrincipal;
    JMenu mnInicio;
    JMenuItem mniLogin;
    JMenuItem mniSalir;
        /*MASCOTA */
    JMenu mnMascota;
    JMenuItem mniNuevoMascota;
    JMenuItem mniModificaMascota;
    JMenuItem mniEliminaMascota;
    JMenuItem mniBuscaMascota;
    JMenuItem mniListaMascota;
    JDesktopPane dkpEscritorio;
    /*REVISION*/
    JMenu mnRevision;
    JMenuItem mniNuevoRevision;
    JMenuItem mniModificaRevision;
    JMenuItem mniEliminaRevision;
    JMenuItem mniBuscaRevision;
    JMenuItem mniListaRevision;
    /**VETERINARIO*/
    JMenu mnVeterinario;
    JMenuItem mniNuevaVeterinario;


    JMenuItem mniModificarVeterinario;
    JMenuItem mniEliminarVeterinario;
    JMenuItem mniBuscarVeterinario;
    JMenuItem mniListarVeterinario;
  

    public FrmMenuPrincipal() {
        dkpEscritorio= new JDesktopPane();
        dkpEscritorio.setBackground(Color.getHSBColor(10,200,200).brighter());
        
        
        mnbPrincipal = new JMenuBar();
        
        mnInicio = new JMenu("INICIO");
        mnInicio.setForeground(Color.BLACK);
        mniLogin = new JMenuItem("INICIAR SESION");
        mniSalir = new JMenuItem("SALIR");
        mniSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniSalirActionPerformed(e);
            }
        });
        
        /*MASCOTA*/
        mnMascota= new JMenu("MASCOTA");
        mnMascota.setForeground(Color.BLACK);
        mniNuevoMascota= new JMenuItem("NUEVO");
             
        mniNuevoMascota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoMascotaActionPerformed(e);
            }
        });
        
        mniModificaMascota= new JMenuItem("MODIFICAR");
        mniEliminaMascota= new JMenuItem("ELIMINAR");
        mniBuscaMascota= new JMenuItem("BUSCAR");
        mniListaMascota= new JMenuItem("LISTAR");
        
        mniListaMascota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaMascotaActionPerformed(e);
            }
        });
       
        mnMascota.add(mniNuevoMascota);
        mnMascota.addSeparator();
        mnMascota.add(mniModificaMascota);
        mnMascota.addSeparator();
        mnMascota.add(mniEliminaMascota);
        mnMascota.addSeparator();
        mnMascota.add(mniBuscaMascota);
        mnMascota.addSeparator();
        mnMascota.add(mniListaMascota);
        
        /*REVISION*/
        mnRevision= new JMenu("REVISION");
        mnRevision.setForeground(Color.BLACK);
        mniNuevoRevision= new JMenuItem("NUEVO");
             
        mniNuevoRevision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoRevisionActionPerformed(e);
            }
        });
        
        mniModificaRevision= new JMenuItem("MODIFICAR");
        mniEliminaRevision= new JMenuItem("ELIMINAR");
        mniBuscaRevision= new JMenuItem("BUSCAR");
        mniListaRevision= new JMenuItem("LISTAR");
        
        mniListaRevision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaRevisionActionPerformed(e);
            }
        });
       
        mnRevision.add(mniNuevoRevision);
        mnRevision.add(mniModificaRevision);
        mnRevision.add(mniEliminaRevision);
        mnRevision.addSeparator();
        mnRevision.add(mniBuscaRevision);
        mnRevision.addSeparator();
        mnRevision.add(mniListaRevision);
       
        
        /*VETERINARIO*/
        
        mnVeterinario = new JMenu("VETERINARIO");
        mnVeterinario.setForeground(Color.BLACK);
        mniNuevaVeterinario = new JMenuItem("NUEVA");
        mniBuscarVeterinario = new JMenuItem("BUSCAR");
        mniEliminarVeterinario = new JMenuItem("ELIMINAR");
        mniModificarVeterinario = new JMenuItem("MODIFICAR");
        mniListarVeterinario = new JMenuItem("LISTAR");
        
        mnVeterinario.add(mniNuevaVeterinario);
        mnVeterinario.add(mniModificarVeterinario);
        mnVeterinario.add(mniEliminarVeterinario);
        mnVeterinario.add(mniBuscaMascota);
        mnVeterinario.add(mniListarVeterinario);
        
        mniNuevaVeterinario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mniNuevoVeterinarioActionPerformed(e);
                } catch (Exception x) {System.out.println("ERROR"+x.getMessage());
                }
            }
        });
        mniListarVeterinario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaVeterinarioActionPerformed(e);
            }
        });
       
        /*UBICAION DE BOTONES*/
        mnbPrincipal.add(mnInicio);
        mnbPrincipal.add(mnMascota);
        mnbPrincipal.add(mnVeterinario);
        mnbPrincipal.add(mnRevision);
        
        mnbPrincipal.setBackground(Color.lightGray);
        mnInicio.add(mniLogin);
        mnInicio.add(mniSalir);
      
        this.setLayout(new BorderLayout());
        this.add(mnbPrincipal, BorderLayout.NORTH);
        this.add(dkpEscritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH); //Para maximizar
     
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Para terminar el programa
    }
    
    
    /*METODOS*/
    public void mniNuevoMascotaActionPerformed(ActionEvent e){
        FrmMascota frm = new FrmMascota();
        dkpEscritorio.add(frm,BorderLayout.WEST);
        frm.setVisible(true);
    }
    public void mniNuevoRevisionActionPerformed(ActionEvent e){
        FrmRevision frm = new FrmRevision();
        dkpEscritorio.add(frm,BorderLayout.WEST);
        frm.setVisible(true);
    }    
    public void mniListaMascotaActionPerformed(ActionEvent e){
        FrmMascotaLista frm = new FrmMascotaLista();
        dkpEscritorio.add(frm,BorderLayout.WEST);
        frm.setVisible(true);
    }
    public void mniNuevoVeterinarioActionPerformed(ActionEvent e){
        FrmVeterinario frm = new FrmVeterinario();
        dkpEscritorio.add(frm,BorderLayout.WEST);
        frm.setVisible(true);
    }     
    public void mniListaVeterinarioActionPerformed(ActionEvent e){
        FrmListaVeterinario frm = new FrmListaVeterinario();
        dkpEscritorio.add(frm,BorderLayout.WEST);
        frm.setVisible(true);
    }
    public void mniListaRevisionActionPerformed(ActionEvent e){
        FrmRevisionLista frm = new FrmRevisionLista();
        dkpEscritorio.add(frm,BorderLayout.WEST);
        frm.setVisible(true);
    }
    
    public void mniSalirActionPerformed(ActionEvent e){
        System.exit(0);
    }
    
    public static void main(String[] args) {
        FrmMenuPrincipal frm = new FrmMenuPrincipal();
        frm.setVisible(true);
    }
}