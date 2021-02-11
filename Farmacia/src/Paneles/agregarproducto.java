/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class agregarproducto extends JDialog{
//botones
    JButton jbrealizarcompra;
//texto Fijo
    JLabel jlnombre;
    JLabel jlcantidad;
    JLabel jlprecio;
    JLabel jlfecha;
    JLabel jlcantidadagregar;
//texto del producto a agregar
    public static JLabel jlnombreproducto;
    public static JLabel jlcantidadproducto;
    public static JLabel jlprecioproducto;
//cuadro de texto cantidad a agregar
    JTextField unidades;
    JTextField dia;
    JTextField mes;
    JTextField año;
            
    public agregarproducto() {
        setTitle("Agregar Productos al inventario");
        setModal(true);//bloquear uso de la ventana anterior
        setLayout(null);
        setSize(450,220);//tamaño, ancho, alto
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//terminar el proceso al cerrar la ventana
        setResizable(false);//no puede cambiarse el tamaño
        setLocationRelativeTo(null);//posicion de la ventana(centro de pantalla)
        
        botones();
        texto();
        camposdetexto();
        colocargrafico();
    }

    private void botones() {
        jbrealizarcompra= new JButton("Realizar Compra");
        jbrealizarcompra.setBounds(145,180,150,25);
    //evento de realizar compra
        jbrealizarcompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreproducto= jlnombreproducto.getText();;
                int cantidadintroducida= Integer.parseInt(unidades.getText());//unidades que agrega al inventario
                int cantidadexistente= Integer.parseInt(jlcantidadproducto.getText());//cantidad que habia en el inventari
                int nuevacantidad= cantidadintroducida+cantidadexistente;//nueva cantidad al agregar producto
                int diaintroducido= Integer.parseInt(dia.getText());
                int mesintroducido= Integer.parseInt(mes.getText());
                int añointroducido= Integer.parseInt(año.getText());
                
            //cambiar la cantidad de producto en arreglo de productos    
                for (int i = 0; i < 10; i++) {
                    if(ventanaprincipal.arregloproducto[i].getNombre().equals(nombreproducto)){//busca el producto en el arreglo de productos
                        ventanaprincipal.arregloproducto[i].setCantidad(nuevacantidad);//mandar la nueva cantidad al inventario
                    //registrar la compra en un arreglo de compra
                        ventanaprincipal.arreglocompra[ventanaprincipal.conteocompra]= new producto2(nombreproducto,diaintroducido,mesintroducido,añointroducido,cantidadintroducida);
                        ventanaprincipal.conteocompra++;
                        JOptionPane.showMessageDialog(null,"Gracias por tu compra.!!\n bye..!!");
                        
                        dispose();
                    }    
                }
            
                
                
                
                
               }    
        });
        
    
    }
    private void texto() {
        jlnombre = new JLabel("Nombre:");
        jlnombre.setBounds(50,20,150,25);
        jlcantidad= new JLabel("Cantidad en inventario:");
        jlcantidad.setBounds(50,60,200,25);
        jlprecio= new JLabel("Precio:");
        jlprecio.setBounds(50,100,150,25);
        jlcantidadagregar= new JLabel("Cantidad que desea agregar:");
        jlcantidadagregar.setBounds(50,140,220,25);
        jlfecha= new JLabel("Fecha:");
        jlfecha.setBounds(200,100,200,25);
    //texto del producto que agregara el usuario
        jlnombreproducto = new JLabel("_**");
        jlnombreproducto.setBounds(115,20,200,25);
        jlcantidadproducto= new JLabel("_**");
        jlcantidadproducto.setBounds(225,60,200,25);
        jlprecioproducto= new JLabel("_**");
        jlprecioproducto.setBounds(105,100,200,25);
        
        
    }
    
    private void camposdetexto() {//texto que el usuario debe ingresar
        unidades= new JTextField("00");
        unidades.setBounds(270,140,50,25);
        
        dia= new JTextField("01");
        dia.setBounds(250,100,50,25);
        mes= new JTextField("01");
        mes.setBounds(300,100,50,25);
        año= new JTextField("2017");
        año.setBounds(350,100,50,25);
        año.setEditable(false);
    }
    
    private void colocargrafico() {
    //boton
        add(jbrealizarcompra);
    //texto Fijo    
        add(jlnombre);
        add(jlprecio);
        add(jlcantidad);
        add(jlcantidadagregar);
        add(jlfecha);
    //cuadro de texto para la cantidad
        add(unidades);
        add(dia);
        add(mes);
        add(año);
    //texto del producto a agregar
        add(jlnombreproducto);
        add(jlprecioproducto);
        add(jlcantidadproducto);
        
    }


     
    
}
