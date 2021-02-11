/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import ventana.ventanaprincipal;

/**
 *
 * @author elser
 */
public class formularioclientes extends JDialog{
    
    
//botones
    private JButton jbaceptar;
    private JButton jbcancelar;
    
//texto sin modificar
    private JLabel jlporfavor;
    private JLabel jlnombres;
    private JLabel jlapellidos;
    private JLabel jledad;
    private JLabel jlcui;
    private JLabel jlnit;
    private JLabel jldireccion;
    private JLabel jlfecha;
        
//texto que debe ingresar el usuario
    private JTextField jtnombres;
    private JTextField jtapellidos;
    private JTextField jtedad;
    private JTextField jtcui;
    public static JTextField jtnit;
    //fecha separada
    private JTextField jtfechadia;
    private JTextField jtfechames;
    private JTextField jtfechaaño;
    
    //la direccion separada
    private JTextField jtcasa;
    private JTextField jtcolonia;
    private JTextField jtcalle;
    private JTextField jtzona;
    
            
    public formularioclientes() {
        setTitle("Datos e Informacion de un Cliente");
        setModal(true);//bloquear uso de la ventana anterior
        setLayout(null);
        setSize(425,445);//tamaño, ancho, alto
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//terminar el proceso al cerrar la ventana
        setResizable(false);//no puede cambiarse el tamaño
        setLocationRelativeTo(null);//posicion de la ventana(centro de pantalla)
        
        botones();
        texto();
        camposdetexto();
        colocargrafico();
    }

    private void botones() {
        jbcancelar =new JButton("CANCELAR");
        jbcancelar.setBounds(90,400,110,25);
        jbcancelar.addActionListener(new AbstractAction() {//fucionamiento del boton cancelar
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });
        
        jbaceptar =new JButton("ACEPTAR");
        jbaceptar.setBounds(225,400,110,25);
        jbaceptar.addActionListener(new AbstractAction() {//fucionamiento del boton cancelar
            @Override
            public void actionPerformed(ActionEvent e) {
                jbaceptarAccion();
            }


        });
    
    }

    private void texto() {
        jlporfavor = new JLabel("FORMULARIO DE REGISTRO",JLabel.CENTER);
        jlporfavor.setBounds(0,20,425,25);
        jlnombres= new JLabel("Nombres:",JLabel.RIGHT);
        jlnombres.setBounds(20,60,90,25);
        jlapellidos= new JLabel("Apellidos:",JLabel.RIGHT);
        jlapellidos.setBounds(20,100,90,25);
        jledad= new JLabel("Edad:",JLabel.RIGHT);
        jledad.setBounds(20,140,90,25);
        jlcui= new JLabel("CUI:",JLabel.RIGHT);
        jlcui.setBounds(20,180,90,25);
        jlnit= new JLabel("NIT:",JLabel.RIGHT);
        jlnit.setBounds(20,220,90,25);
        jlfecha= new JLabel("Fecha:",JLabel.RIGHT);
        jlfecha.setBounds(20,260,90,25);
        jldireccion= new JLabel("Direccion:",JLabel.RIGHT);
        jldireccion.setBounds(20,300,90,25);
        
    }
    
    private void camposdetexto() {//texto que el usuario debe ingresar
        jtnombres= new JTextField("");
        jtnombres.setBounds(20+90,60,250,25);
        jtapellidos= new JTextField("");
        jtapellidos.setBounds(20+90,100,250,25);
        jtedad= new JTextField("");
        jtedad.setBounds(20+90,140,250,25);
        jtcui= new JTextField("");
        jtcui.setBounds(20+90,180,250,25);
        jtnit= new JTextField("");
        jtnit.setBounds(20+90,220,250,25);
        //fecha separada
        jtfechadia= new JTextField("01");
        jtfechadia.setBounds(110,260,25,25);
        jtfechames= new JTextField("01");
        jtfechames.setBounds(140,260,25,25);
        jtfechaaño= new JTextField("2017");
        jtfechaaño.setBounds(140+30,260,40,25);
        jtfechaaño.setEditable(false);
        //direccion separada
        jtcasa= new JTextField("#Casa");
        jtcasa.setBounds(110,300,75,25);
        jtcolonia= new JTextField("Colonia");
        jtcolonia.setBounds(165+25,300,170,25);
        jtcalle= new JTextField("Calle");
        jtcalle.setBounds(110,340,120,25);
        jtzona= new JTextField("Zona");
        jtzona.setBounds(235,340,125,25);
        
    }    
    
        public void jbaceptarAccion() {//accion al presionar boton "aceptar"
            
            String nombres = jtnombres.getText();
            String apellidos = jtapellidos.getText();
            int edad = Integer.parseInt(jtedad.getText());
            String cui = jtcui.getText();
            String nit = jtnit.getText();
            int dia = Integer.parseInt(jtfechadia.getText());
            int mes = Integer.parseInt(jtfechames.getText());
            int año = Integer.parseInt(jtfechaaño.getText());
            String nocasa = jtcasa.getText();
            String colonia = jtcolonia.getText();
            String calle = jtcalle.getText();
            String zona = jtzona.getText();
            
            ventanaprincipal.arreglocliente[ventanaprincipal.conteoagregar]=new cliente(nombres, apellidos, edad, cui, nit, dia, mes, año, nocasa, colonia, calle, zona);
            
            String datos[] = {nombres,apellidos,nit};
            ventanaprincipal.modeloclientes.addRow(datos);
            

            JOptionPane.showMessageDialog(this, "Un cliente ha sido agregado.!!");
            setVisible(false);//luego de agregar la persona cerrar la ventana
            
        //hacer que se limpien los campos de texto
            jtnombres.setText("");
            jtapellidos.setText("");
            jtedad.setText("");
            jtnit.setText("");
            jtcui.setText("");
            jtfechadia.setText("01");
            jtfechames.setText("01");
            jtfechaaño.setText("2017");
            jtcasa.setText("#Casa");
            jtcolonia.setText("Colonia");
            jtcalle.setText("calle");
            jtzona.setText("zona");
            
            ventanaprincipal.conteoagregar++;//agrega un cliente en la siguiente posicion de la matriz
        }    
    
    
    
        private void colocargrafico() {
        //agregar botones
            add(jbaceptar);
            add(jbcancelar);

        //agregar texto
            add(jlporfavor);
            add(jlnombres);
            add(jlapellidos);
            add(jledad);
            add(jlcui);
            add(jlnit);
            add(jldireccion);
            add(jlfecha);
                    
        //agregar campos de texto
            add(jtnombres);
            add(jtapellidos);
            add(jtedad);
            add(jtcui);
            add(jtnit);
            //fecha separada
            add(jtfechadia);
            add(jtfechames);
            add(jtfechaaño);
            //direccion separada
            add(jtcasa);
            add(jtcolonia);
            add(jtcalle);
            add(jtzona);
            
    }


     
    
}
