/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import ventana.ventanaprincipal;

/**
 *
 * @author elser
 */
public class cambioestado extends JDialog{
    private JTable tabla;
    private JScrollPane scroll;
    public static DefaultTableModel modpedidocambio;
    Object[][] data=new Object[0][0];
    static String[] titulostabla = {"Producto","Precio Total","Cantidad Agregada"};    
    
//botones
    private JButton jbguardar;
    public static JRadioButton jrbentregado;
    public static JRadioButton jrbpendiente;
//texto Fijo
    private JLabel jlnombres;
    private JLabel jledad;
    private JLabel jlcui;
    private JLabel jldireccion;
    private JLabel jlfechadelpedido;
    private JLabel jlmontototal;
    private JLabel jlestado;
    private JLabel jlnit;
    
//texto del pedido seleccionado    
    public static JLabel jlnombrespedido;
    public static JLabel jledadpedido;
    public static JLabel jlcuipedido;
    public static JLabel jldireccionpedido;
    public static JLabel jlfechadelpedidopedido;
    public static JLabel jlmontototal1;
    
    public static JLabel jlnitpedido;

            
    public cambioestado() {
        setTitle("Modificar Estado");
        setModal(true);//bloquear uso de la ventana anterior
        setLayout(null);
        setSize(600,400);//tamaño, ancho, alto
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//terminar el proceso al cerrar la ventana
        setResizable(false);//no puede cambiarse el tamaño
        setLocationRelativeTo(null);//posicion de la ventana(centro de pantalla)
        
        botones();
        texto();
        tabla();
        colocargrafico();
    }

    private void botones() {
        
        jbguardar= new JButton("Guardar cambios");
        jbguardar.setBounds(210,350,180,25);
        jbguardar.addActionListener(new AbstractAction() {//fucionamiento del boton cancelar
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrbentregado.isSelected()) {
                
                    for (int i = 0; i < ventanaprincipal.arreglopedidos.length; i++) {//busca en todo el arreglo de pedidos
                        if (ventanaprincipal.arreglopedidos[i] !=null) {//verifica si existe esa posicion en el arreglo
                            if (ventanaprincipal.arreglopedidos[i].getNitcliente().equals(jlnitpedido.getText())) {//encuentra el pedido registrado con ese nit
                                if (ventanaprincipal.arreglopedidos[i].getGastototal()==Double.parseDouble(jlmontototal1.getText())) {//encuentra el pedido registrado con ese montototal
                                    ventanaprincipal.arreglopedidos[i].setEstado("entregado");
                        
                                }
                            }
                        }
            
                    }
                    
                    
                }else if (jrbpendiente.isSelected()) {
                                        for (int i = 0; i < ventanaprincipal.arreglopedidos.length; i++) {//busca en todo el arreglo de pedidos
                        if (ventanaprincipal.arreglopedidos[i] !=null) {//verifica si existe esa posicion en el arreglo
                            if (ventanaprincipal.arreglopedidos[i].getNitcliente().equals(jlnitpedido.getText())) {//encuentra el pedido registrado con ese nit
                                if (ventanaprincipal.arreglopedidos[i].getGastototal()==Double.parseDouble(jlmontototal1.getText())) {//encuentra el pedido registrado con ese montototal
                                    ventanaprincipal.arreglopedidos[i].setEstado("pendiente");
                        
                                }
                            }
                        }
            
                    }
                    
                }
                setVisible(false);
                dispose();
            }
        });
        
        
         ButtonGroup grupo;
        jrbentregado = new JRadioButton("Entregado");
        jrbentregado.setBounds(350, 125, 100, 25);
        
        jrbpendiente = new JRadioButton("Pendiente");
        jrbpendiente.setBounds(350, 100, 100, 25);
        jrbpendiente.setSelected(true);
        grupo = new ButtonGroup();
        grupo.add(jrbentregado);
        grupo.add(jrbpendiente);
        
        
    
    }
    private void texto() {
        jlnombres=new JLabel("Nombre:");
        jlnombres.setBounds(50,25,300,25);
        
        jledad=new JLabel("Edad:");
        jledad.setBounds(50,50,300,25);
        
        jlcui=new JLabel("Cui:");
        jlcui.setBounds(50,75,300,25);
        
        jldireccion=new JLabel("Direccion:");
        jldireccion.setBounds(50,100,300,25);
        
        jlnit=new JLabel("NIT:");
        jlnit.setBounds(50,125,300,25);
        
        jlfechadelpedido=new JLabel("Fecha del pedido:");
        jlfechadelpedido.setBounds(350,25,300,25);
        
        jlmontototal=new JLabel("Monto Total: Q.");
        jlmontototal.setBounds(350,50,300,25);
        
        jlestado=new JLabel("Estado del pedido");
        jlestado.setBounds(350,75,300,25);
        
    //texto del pedido seleccionado
        jlnitpedido=new JLabel("***",JLabel.LEFT);
        jlnitpedido.setBounds(80,125,300,25);
        
        jlnombrespedido=new JLabel("***");
        jlnombrespedido.setBounds(110,25,300,25);
        
        jledadpedido=new JLabel("***");
        jledadpedido.setBounds(90,50,300,25);
        
        jlcuipedido=new JLabel("***");
        jlcuipedido.setBounds(80,75,300,25);
        
        jldireccionpedido=new JLabel("***");
        jldireccionpedido.setBounds(120,100,300,25);
        
        
        jlfechadelpedidopedido=new JLabel("***");
        jlfechadelpedidopedido.setBounds(480,25,300,25);
        
        jlmontototal1=new JLabel("0");
        jlmontototal1.setBounds(460,50,300,25);

        
        
        
        
        

    }
    
    private void tabla() {
        modpedidocambio = new DefaultTableModel(data,titulostabla){
        public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
        };
        tabla=new JTable(modpedidocambio); 
        
        
        
        
        scroll=new JScrollPane(tabla);
        scroll.setBounds(50,160,500,170);
        scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a la tabla
    }
    
    private void colocargrafico() {
    //Boton
        add(jbguardar);
        add(jrbpendiente);
        add(jrbentregado);
    //texto
        add(jlnombres);
        add(jledad);
        add(jlcui);
        add(jldireccion);
        add(jlfechadelpedido);
        add(jlmontototal);
        add(jlestado);
        add(jlnit);
    //texto pedido selecccionado    
        add(jlnitpedido);
        add(jlnombrespedido);
        add(jledadpedido);
        add(jlcuipedido);
        add(jldireccionpedido);
        add(jlfechadelpedidopedido);
        add(jlmontototal1);
    //tabla
        add(scroll);
    }


     
    
}
