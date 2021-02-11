/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ventana.ventanaprincipal;

/**
 *
 * @author elser
 */
public class listado extends JDialog{
        private JTable tabla;
        private JScrollPane scroll;
        public DefaultTableModel modpedido;
        Object[][] data=new Object[0][0];
        static String[] titulostabla = {"NIT","Monto Total","Estado"};
        private JButton jbayuda;
        private JLabel jltitulo;
    
    
    public listado(){
        setTitle("Listado De Pedidos");
        setModal(true);//bloquear uso de la ventana anterior
        setLayout(null);
        setSize(500,231+35);//tamaño, ancho, alto
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//terminar el proceso al cerrar la ventana
        setResizable(false);//no puede cambiarse el tamaño
        setLocationRelativeTo(null);//posicion de la ventana(centro de pantalla)
        
        jltitulo= new JLabel("Listado De Pedidos Realizados",JLabel.CENTER);
        jltitulo.setBounds(0,25,500,25);
        jbayuda = new JButton("Ayuda");
        jbayuda.setBounds(40,231,100,25);
        jbayuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Para obtener mas información acerca	\n" +
                                                    "de un pedido o cambiar su estado	\n" +
                                                    "debes dar doble clic sobre dicho pedido. ");

               }    
        });    
        
        
        tabla();
        llenartabla();
        colocargraficos();
        
        
        
        
        
    }

    private void tabla() {
    //tabla
        
        modpedido = new DefaultTableModel(data,titulostabla){
        public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
        };
        tabla=new JTable(modpedido); 
        tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me){
                if(me.getClickCount() == 2){// Cuenta la cantidad de clicks para saber si es doble
                    
                    
                    int fila = tabla.rowAtPoint(me.getPoint());// numero Fila que se selecciona
                    String Nitpedido=tabla.getValueAt(fila,0).toString();//Copia el Nombre del producto ya que esta en columna 0
                    String montototal=tabla.getValueAt(fila,1).toString();//Copia el precio del producto ya que esta en columna 1;
                    String estado=tabla.getValueAt(fila,2).toString();//Copia el cantidad del producto ya que esta en columna 2;
                    int x = JOptionPane.showConfirmDialog(null, "¿Desea ver o modificar la informacion del pedido?","Modificar Estado",0);
                //si elige que si debemos buscar en el arreglo el producto con ese nombre.    
                    if(x==JOptionPane.YES_OPTION){
                    cambioestado cambio=new cambioestado();
                //enviar datos
                    cambioestado.jlnitpedido.setText(Nitpedido);
                    cambioestado.jlmontototal1.setText(montototal);
                //enviar filas a la tabla
                
        
        for (int i = 0; i < ventanaprincipal.arreglopedidos.length; i++) {//busca en todo el arreglo de pedidos
            if (ventanaprincipal.arreglopedidos[i] !=null) {//verifica si existe esa posicion en el arreglo
                if (ventanaprincipal.arreglopedidos[i].getNitcliente().equals(Nitpedido)) {//encuentra el pedido registrado con ese nit
                    if (ventanaprincipal.arreglopedidos[i].getGastototal()==Double.parseDouble(montototal)) {//encuentra el pedido registrado con ese montototal
                        for (int bus = 0; bus < ventanaprincipal.arreglocliente.length; bus++) {
                            if (ventanaprincipal.arreglocliente[bus] !=null) {
                                if(ventanaprincipal.arreglocliente[bus].getNit().equals(Nitpedido) ){//enviar datos del cliente
                                  cambioestado.jlnombrespedido.setText(ventanaprincipal.arreglocliente[bus].getNombres()+" "+ventanaprincipal.arreglocliente[bus].getApellidos());  
                                  cambioestado.jlcuipedido.setText(ventanaprincipal.arreglocliente[bus].getCui());  
                                  cambioestado.jlcuipedido.setText(ventanaprincipal.arreglocliente[bus].getCui());  
                                  cambioestado.jledadpedido.setText(String.valueOf(ventanaprincipal.arreglocliente[bus].getEdad()));  
                                  cambioestado.jldireccionpedido.setText(ventanaprincipal.arreglocliente[bus].getCalle()+", "+ventanaprincipal.arreglocliente[bus].getColonia()+", "+ventanaprincipal.arreglocliente[bus].getNocasa()+", zona "+ventanaprincipal.arreglocliente[bus].getZona());  
                                }
                            }
                        }
                        cambioestado.jlfechadelpedidopedido.setText(String.valueOf(ventanaprincipal.arreglopedidos[i].getDiapedido())+"/"+String.valueOf(ventanaprincipal.arreglopedidos[i].getMespedido())+"/2017");
                        producto p[]= ventanaprincipal.arreglopedidos[i].getProducto();//copia los productos que compro en un nuevo arreglo
                        for(int j = 0; j < p.length; j++) {//obtener informacion del listado de productos agregados
                            if (p[j] != null) {//enviar filas a la tabla
                                String articulos[]={p[j].getNombre(),String.valueOf(p[j].getPrecio()),String.valueOf(p[j].getCantidad())};
                                cambioestado.modpedidocambio.addRow(articulos);
                            }
                        }
                    }
                }
            }
            
        }
                
                
                
                
                
                
                
                    cambio.setVisible(true);
                   
                    }else{
                        
                    }
                    
                //como borrar filas actualizar datos en la tabla
                    int contadordefilas = modpedido.getRowCount();
                    for (int i = 0;contadordefilas>i; i++) {
                            modpedido.removeRow(0);
                    }
                    llenartabla();
                    
                }
            }
        });
        
        
        
        
        
        scroll=new JScrollPane(tabla);
        scroll.setBounds(40,50,420,181);
        scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a la tabla
        

    }

    private void colocargraficos() {
        add(scroll);
        add(jbayuda);
        add(jltitulo);
    }

    private void llenartabla() {        
        for(int x=0; x<20;x++){//busca en todo el arreglo de pedidos en la posicion x
            if (ventanaprincipal.arreglopedidos[x] != null) {//verifica si existe la posicion en el arreglo de pedidos
            
                producto p[]= ventanaprincipal.arreglopedidos[x].getProducto();//copia los productos que compro en un nuevo arreglo
                //model.addElement("en la fecha: "+String.valueOf(ventanaprincipal.arreglopedidos[x].getDiapedido())+"/"+String.valueOf(ventanaprincipal.arreglopedidos[x].getMespedido())+"/2017");
                //model.addElement("el cliente con nit "+ventanaprincipal.arreglopedidos[x].getNitcliente()+" compro:");
                
                for(int i = 0; i < p.length; i++) {//obtener informacion del listado de productos agregados
                    if (p[i] != null) {
                        //model.addElement(String.valueOf(p[i].getCantidad())+" "+p[i].getNombre()+" por un total de: Q."+String.valueOf(p[i].getPrecio()));    
                    }
                }
                
            //Agregar a tabla
                String datos[]={ventanaprincipal.arreglopedidos[x].getNitcliente(),String.valueOf(ventanaprincipal.arreglopedidos[x].getGastototal()),ventanaprincipal.arreglopedidos[x].getEstado()};
                modpedido.addRow(datos);
                
            }
        }        
    }
    
    


}
