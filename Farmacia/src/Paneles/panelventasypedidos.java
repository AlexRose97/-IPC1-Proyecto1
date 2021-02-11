/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;

/**
 *
 * @author elser
 */
public class panelventasypedidos extends JPanel {
//texto
    private JLabel jlpregunta1;//¿Desea generar un pedido?
    private JLabel jlpregunta2;//¿Desea ver el listado de pedidos generados?
//botones
    private JButton jbgenerar;
    private JButton jblistado;

    public panelventasypedidos(){
       
        setLayout(null);
        botones();
        texto();
        colocargrafico();
    }

    private void texto() {
        jlpregunta1= new JLabel("¿Desea generar un pedido?");
        jlpregunta1.setBounds(50,50,300,25);
        jlpregunta2= new JLabel("¿Desea ver el listado de pedidos generados?");
        jlpregunta2.setBounds(50,180,350,25);
    }

    private void botones() {
        jbgenerar = new JButton("GENERAR");
        jbgenerar.setBounds(250,50,100,25);
        //evento al presionar el boton "generar"
        jbgenerar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                verificacionnit registro = new verificacionnit();
                registro.setVisible(true);
            }
        }
        );
        
        jblistado = new JButton("LISTADO");
        jblistado.setBounds(380,180,100,25);
        jblistado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"acontinuacion vera el listado de pedidos");
                listado listadodeproductos=new listado();
                listadodeproductos.setVisible(true);   
            }
            
        });
        
                        
        
    }

    private void colocargrafico() {
    //botones
        add(jbgenerar);
        add(jblistado);
    //texto
        add(jlpregunta1);
        add(jlpregunta2);
    }
    
    
}
