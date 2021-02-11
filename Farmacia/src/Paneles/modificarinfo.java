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
public class modificarinfo extends JDialog{
    
    
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
    public static JTextField jtnombresr;
    public static JTextField jtapellidosr;
    public static JTextField jtedadr;
    public static JTextField jtcuir;
    public static JTextField jtnitr;
    //fecha separada
    public static JTextField jtfechadiar;
    public static JTextField jtfechamesr;
    public static JTextField jtfechaañor;
    
    //la direccion separada
    public static JTextField jtcasar;
    public static JTextField jtcoloniar;
    public static JTextField jtcaller;
    public static JTextField jtzonar;
    public static String identificador;//identifica el cliente el el arreglo para modificar su info
    
            
    public modificarinfo() {
        setTitle("Datos e Informacion de un Cliente");
        setModal(true);//bloquear uso de la ventana anterior
        setLayout(null);
        setSize(425,445);//tamaño, ancho, alto
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//terminar el proceso al cerrar la ventana
        setResizable(false);//no puede cambiarse el tamaño
        setLocationRelativeTo(null);//posicion de la ventana(centro de pantalla)
        identificador="";
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
        jtnombresr= new JTextField("");
        jtnombresr.setBounds(20+90,60,250,25);
        jtapellidosr= new JTextField("");
        jtapellidosr.setBounds(20+90,100,250,25);
        jtedadr= new JTextField("");
        jtedadr.setBounds(20+90,140,250,25);
        jtcuir= new JTextField("");
        jtcuir.setBounds(20+90,180,250,25);
        jtnitr= new JTextField("");
        jtnitr.setBounds(20+90,220,250,25);
        //fecha separada
        jtfechadiar= new JTextField("01");
        jtfechadiar.setBounds(110,260,25,25);
        jtfechamesr= new JTextField("01");
        jtfechamesr.setBounds(140,260,25,25);
        jtfechaañor= new JTextField("2017");
        jtfechaañor.setBounds(140+30,260,40,25);
        jtfechaañor.setEditable(false);
        //direccion separada
        jtcasar= new JTextField("#Casa");
        jtcasar.setBounds(110,300,75,25);
        jtcoloniar= new JTextField("Colonia");
        jtcoloniar.setBounds(165+25,300,170,25);
        jtcaller= new JTextField("Calle");
        jtcaller.setBounds(110,340,120,25);
        jtzonar= new JTextField("Zona");
        jtzonar.setBounds(235,340,125,25);
        
    }    
    
        public void jbaceptarAccion() {//accion al presionar boton "aceptar"
            
            String nombres = jtnombresr.getText();
            String apellidos = jtapellidosr.getText();
            int edad = Integer.parseInt(jtedadr.getText());
            String cui = jtcuir.getText();
            String nit = jtnitr.getText();
            int dia = Integer.parseInt(jtfechadiar.getText());
            int mes = Integer.parseInt(jtfechamesr.getText());
            int año = Integer.parseInt(jtfechaañor.getText());
            String nocasa = jtcasar.getText();
            String colonia = jtcoloniar.getText();
            String calle = jtcaller.getText();
            String zona = jtzonar.getText();
            
            for (int i = 0; i < ventanaprincipal.arreglocliente.length; i++) {
                if(ventanaprincipal.arreglocliente[i] !=null){//verifica si exite esa posicion en el arreglo
                    if(ventanaprincipal.arreglocliente[i].getNit().equals(identificador)){
                        ventanaprincipal.arreglocliente[i]=new cliente(nombres, apellidos, edad, cui, nit, dia, mes, año, nocasa, colonia, calle, zona);

                    }
                }
            }
     
            String datos[] = {nombres,apellidos,nit};
            ventanaprincipal.modeloclientes.addRow(datos);
            

            JOptionPane.showMessageDialog(this, "Se ha Modificado la informacion");
            dispose();
            
        //hacer que se limpien los campos de texto
            jtnombresr.setText("");
            jtapellidosr.setText("");
            jtedadr.setText("");
            jtnitr.setText("");
            jtcuir.setText("");
            jtfechadiar.setText("01");
            jtfechamesr.setText("01");
            jtfechaañor.setText("2017");
            jtcasar.setText("#Casa");
            jtcoloniar.setText("Colonia");
            jtcaller.setText("calle");
            jtzonar.setText("zona");
            
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
            add(jtnombresr);
            add(jtapellidosr);
            add(jtedadr);
            add(jtcuir);
            add(jtnitr);
            //fecha separada
            add(jtfechadiar);
            add(jtfechamesr);
            add(jtfechaañor);
            //direccion separada
            add(jtcasar);
            add(jtcoloniar);
            add(jtcaller);
            add(jtzonar);
            
    }


     
    
}
