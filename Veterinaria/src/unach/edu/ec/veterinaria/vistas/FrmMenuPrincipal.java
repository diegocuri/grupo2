package unach.edu.ec.veterinaria.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

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
/*DOCENTE*/
    JMenu mnDocente;
    JMenuItem mniNuevoDocente;
    JMenuItem mniModificaDocente;
    JMenuItem mniEliminaDocente;
    JMenuItem mniBuscaDocente;
    JMenuItem mniListaDocente;
    
    /**MATERIA*/
    JMenu mnMateria;
    JMenuItem mniNuevaMateria;
    JMenuItem mniModificarMateria;
    JMenuItem mniEliminarMateria;
    JMenuItem mniBuscarMateria;
    JMenuItem mniListarMateria;
  

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
        
        /*DOCENTE*/
        mnDocente= new JMenu("DOCENTE");
        mnDocente.setForeground(Color.BLACK);
        mniNuevoDocente= new JMenuItem("NUEVO");
             
        mniNuevoDocente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoDocenteActionPerformed(e);
            }
        });
        
        mniModificaDocente= new JMenuItem("MODIFICAR");
        mniEliminaDocente= new JMenuItem("ELIMINAR");
        mniBuscaDocente= new JMenuItem("BUSCAR");
        mniListaDocente= new JMenuItem("LISTAR");
        
        mniListaDocente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaDocenteActionPerformed(e);
            }
        });
       
        mnDocente.add(mniNuevoDocente);
        mnDocente.add(mniModificaDocente);
        mnDocente.add(mniEliminaDocente);
        mnDocente.addSeparator();
        mnDocente.add(mniBuscaDocente);
        mnDocente.addSeparator();
        mnDocente.add(mniListaDocente);
       
        
        /*MATERIA*/
        
        mnMateria = new JMenu("MATERIA");
        mnMateria.setForeground(Color.blue);
        mniNuevaMateria = new JMenuItem("NUEVA");
        mniBuscarMateria = new JMenuItem("BUSCAR");
        mniEliminarMateria = new JMenuItem("ELIMINAR");
        mniModificarMateria = new JMenuItem("MODIFICAR");
        mniListarMateria = new JMenuItem("LISTAR");
        
        mnMateria.add(mniNuevaMateria);
        mnMateria.add(mniModificarMateria);
        mnMateria.add(mniEliminarMateria);
        mnMateria.add(mniBuscaMascota);
        mnMateria.add(mniListarMateria);
        
        mniNuevaMateria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mniNuevaMateriaActionPerformed(e);
                } catch (Exception x) {System.out.println("ERROR"+x.getMessage());
                }
            }
        });
        /*UBICAION DE BOTONES*/
        mnbPrincipal.add(mnInicio);
        mnbPrincipal.add(mnMascota);
        mnbPrincipal.add(mnMateria);
        mnbPrincipal.add(mnDocente);
        
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
        public void mniNuevaMateriaActionPerformed(ActionEvent e){
        FmrMateria frm = new FmrMateria();
        dkpEscritorio.add(frm,BorderLayout.SOUTH);
        
        frm.setVisible(true);
    }
       public void mniNuevoDocenteActionPerformed(ActionEvent e){
        FmrDocente frm = new FmrDocente();
        frm.setTitle("DOCENTE");
        dkpEscritorio.add(frm,BorderLayout.SOUTH);
        
        frm.setVisible(true);
    }
        public void mniListaDocenteActionPerformed(ActionEvent e){
        FrmDocenteLista frm = new FrmDocenteLista();
        frm.setTitle("DOCENTES REGISTRADOS");
        dkpEscritorio.add(frm,BorderLayout.WEST);
      
        frm.setVisible(true);
    } 
    public void mniListaMascotaActionPerformed(ActionEvent e){
        FrmMascotaLista frm = new FrmMascotaLista();
        frm.setTitle("MASCOTAS REGISTRADOS");
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
