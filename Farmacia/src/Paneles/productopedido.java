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
public class productopedido extends JDialog{
//botones
    JButton jbrealizarcompra;
//texto Fijo
    JLabel jlnombre;
    JLabel jlcantidad;
    JLabel jlprecio;
    JLabel jlcantidadagregar;
//texto del producto a agregar
    public static JLabel jlnombreproducto;
    public static JLabel jlcantidadproducto;
    public static JLabel jlprecioproducto;
//cuadro de texto cantidad a agregar
    JTextField unidades;
            
    public productopedido() {
        setTitle("Pedidos");
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
        jbrealizarcompra= new JButton("Realizar Pedido");
        jbrealizarcompra.setBounds(145,180,150,25);
    //evento de realizar compra
        jbrealizarcompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreproducto= jlnombreproducto.getText();;
                int cantidadintroducida= Integer.parseInt(unidades.getText());
                double precio= Double.parseDouble(jlprecioproducto.getText());
                double preciototal= cantidadintroducida*precio;
                
                String datos[]={nombreproducto,String.valueOf(preciototal),String.valueOf(cantidadintroducida)};
                generarpedido1.modelopedido2.addRow(datos);
                
                        if (generarpedido1.cantidadprod>0) {
                         JOptionPane.showMessageDialog(null,"Gracias por tu compra.!!\n aun puedes agregar "+generarpedido1.cantidadprod+" poductos mas");
                         generarpedido1.cantidadprod--;
                        }else{
                        JOptionPane.showMessageDialog(null,"Gracias por tu compra.!!\n ya no puedes agregar mas productos");
                        generarpedido1.cantidadprod--;
                        }
                        
                        dispose();
                        
                
                
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
    }
    
    private void colocargrafico() {
    //boton
        add(jbrealizarcompra);
    //texto Fijo    
        add(jlnombre);
        add(jlprecio);
        add(jlcantidad);
        add(jlcantidadagregar);
    //cuadro de texto para la cantidad
        add(unidades);
    //texto del producto a agregar
        add(jlnombreproducto);
        add(jlprecioproducto);
        add(jlcantidadproducto);
        
    }


     
    
}
