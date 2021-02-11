/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class verificacionnit extends JDialog{
    public static String textobusqueda;

//botones
    private JButton jbverificar;
    
//texto
    private JLabel jlporfavor1;//por favor ingrese el nit del cliente
    private JLabel jlporfavor2;//para verificar si se encuentra registrado.
    private JLabel jlnit;//NIT del Cliente
    
//campo de texto
    private JTextField jtnit;
    
    public verificacionnit(){
        setTitle("Verificacion");
        setModal(true);//bloquear uso de la ventana anterior
        setLayout(null);
        setSize(450,205);//tamaño, ancho, alto
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//terminar el proceso al cerrar la ventana
        setResizable(false);//no puede cambiarse el tamaño
        setLocationRelativeTo(null);//posicion de la ventana(centro de pantalla)
        
        botones();
        texto();
        campodetexto();
        colocargrafico();
        
        
    }

    private void botones() {
        jbverificar = new JButton("VERIFICAR");
        jbverificar.setBounds(300,130,130,25);
        jbverificar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                jbverificar();
            }  
        }
        );
    }

    private void texto() {
        jlporfavor1 = new JLabel("Por favor ingrese el NIT del cliente para");
        jlporfavor1.setBounds(50,50,350,25);
        jlporfavor2 = new JLabel("verificar si se encuentra registrado.");
        jlporfavor2.setBounds(50,75,350,25);
        jlnit = new JLabel("NIT del Cliente:");
        jlnit.setBounds(50,130,130,25);
        
    }

    private void campodetexto() {
        jtnit= new JTextField("3355446-4");
        jtnit.setBounds(165,130,130,25);
    }
    /**
     * accion del boton "verificar"
     */
    private void jbverificar() {
        
        jtfiltrobusqueda();
        
    }
    
    private void colocargrafico() {
    //botones
        add(jbverificar);
    //texto
        add(jlporfavor1);
        add(jlporfavor2);
        add(jlnit);
    //campo de texto
        add(jtnit);
    }
//filtro de la busqueda por nit    
    private void jtfiltrobusqueda() {
        textobusqueda = jtnit.getText();
        
        if(textobusqueda.isEmpty()){
            //mostrar mensaje que no existe un cliente registrado con ese nit
            JOptionPane.showMessageDialog(this,"Por favor ingresa un NIT","Error",2);
            
        }else{
            buscarenlista(Filtrobusqueda.filtroNit(ventanaprincipal.arreglocliente, textobusqueda));
        }
        
    }

    private void buscarenlista(cliente[] filtroNit) {
        
        
        if(filtroNit[0]==null){//el cliente no esta registrado
            int x = JOptionPane.showConfirmDialog(this, "El cliente no se encuentra registrado\n     ¿DESEA REGISTRARLO?","Error",0);
            
            if(x==JOptionPane.YES_OPTION){
                formularioclientes registro = new formularioclientes();
                formularioclientes.jtnit.setText(textobusqueda);//envia el nit que el usuario desea registrar
                registro.setVisible(true);
                jtnit.setText("");//limpiar area de texto a verificar 
                formularioclientes.jtnit.setText("");//envia el nit que el usuario desea registrar
            }else{
                jtnit.setText("");//limpiar area de texto a verificar
            }
            
            
        }else{//encontro al cliente registrado
            
            jtnit.setText("");//limpiar area de texto a verificar    
        //abrrir la ventana de generar el pedido
            generarpedido1 generar = new generarpedido1();
        //llenar los datos del cliente seleccionado
            generarpedido1.jlnombres1.setText(filtroNit[0].getNombres());
            generarpedido1.jlapellidos1.setText(filtroNit[0].getApellidos());
            generarpedido1.jledad1.setText(Integer.toString(filtroNit[0].getEdad()));
            generarpedido1.jlcui1.setText(filtroNit[0].getCui());
            generarpedido1.jlnit1.setText(filtroNit[0].getNit());
            generarpedido1.jlfecha1.setText(Integer.toString(filtroNit[0].getDia())+"/"+Integer.toString(filtroNit[0].getMes())+"/"+Integer.toString(filtroNit[0].getAño()));
            generarpedido1.jldireccion1.setText(filtroNit[0].getNocasa()+", "+filtroNit[0].getColonia()+", calle "+filtroNit[0].getCalle()+", zona "+filtroNit[0].getZona());
        //mostrar la ventana para generar el pedido    
            generar.setVisible(true);

        }
      
    }    
    
    
}
