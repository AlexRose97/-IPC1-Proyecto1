/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import ventana.ventanaprincipal;

/**
 *
 * @author elser
 */
public class panelproductos extends JPanel {
    JTable tabla;//tabla que contiene los productos
    JScrollPane scroll;//panel que contiene los productos
    DefaultTableModel modelo;//modelo que contine los productos
    Object[][] data=new Object[0][0];
    static String[] titulosproductos = {"Producto","Precio","Cantidad disponible"};//titulos de la tabla

    private JLabel jllistado;//texto: listado de productos que posees en inventario.
    private JLabel jlrealizar;
   
    private JButton jbbuscar;
    private JButton jbayuda;
    private JTextField jtbusqueda;//ingrese el nombre a buscar.
        
    public panelproductos(){

        setLayout(null);
        productos();
        botones();
        textos();
        colocargrafico();
  
    }

    private void botones() {
        jbayuda = new JButton("Ayuda");
        jbayuda.setBounds(50,340,100,25);
        jbayuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "1) Para realizar una búsqueda de productos      \n"
                        + "en el inventario debes escribir su nombre en      \n"
                        + "el cuadro de texto, luego presionar el botón      \n"
                        + "“Buscar”. En la tabla se mostraran los       \n"
                        + "resultados de tu búsqueda.      \n\n"
                        + "2) Si a un producto deseas agregarle mas     \n"
                        + "unidades debes darle doble clic a dicho      \n"
                        + "producto en la tabla.");

               }    
        });
        
        
        jbbuscar = new JButton("Buscar");
        jbbuscar.setBounds(500-75,80,100,25);
        jbbuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtfiltrobusqueda();
               }    
        });
 

    }

    private void textos() {
        jlrealizar = new JLabel("Realizar una busqueda en el inventario");
        jlrealizar.setBounds(50,50,300,25);
        jtbusqueda = new JTextField("Escriba el nombre del producto",30);
        jtbusqueda.setBounds(50,80,360,25);
        jllistado= new JLabel("Listado de productos que posees en el inventario");
        jllistado.setBounds(50,150,400,25);
        
    }
    private void productos() {
//mostrar con una tabla        
        scroll=new JScrollPane(ventanaprincipal.tablaproductos);
        scroll.setBounds(50,190,500,150);
        
        ventanaprincipal.tablaproductos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me){
                if(me.getClickCount() == 2){// Cuenta la cantidad de clicks para saber si es doble
                    
                    
                    int fila = ventanaprincipal.tablaproductos.rowAtPoint(me.getPoint());// numero Fila que se selecciona
                    String productoseleccionado=ventanaprincipal.tablaproductos.getValueAt(fila,0).toString();//Copia el Nombre del producto ya que esta en columna 0
                    String precioseleccionado=ventanaprincipal.tablaproductos.getValueAt(fila,1).toString();//Copia el precio del producto ya que esta en columna 1;
                    String cantidadselecionado=ventanaprincipal.tablaproductos.getValueAt(fila,2).toString();//Copia el cantidad del producto ya que esta en columna 2;
                    int x = JOptionPane.showConfirmDialog(null, "¿Desea agregar mas "+productoseleccionado+" al inventario?","Comprar Productos",0);
                //si elige que si debemos buscar en el arreglo el producto con ese nombre.    
                    if(x==JOptionPane.YES_OPTION){
                    agregarproducto agregar=new agregarproducto();
                    agregarproducto.jlnombreproducto.setText(productoseleccionado);
                    agregarproducto.jlcantidadproducto.setText(cantidadselecionado);
                    agregarproducto.jlprecioproducto.setText(precioseleccionado);
                    agregar.setVisible(true);
                    llenarLista(ventanaprincipal.arregloproducto);
                    }else{
                        
                    }
                    
                }
            }
        });

    }    
    private void colocargrafico() {
        add(jbayuda);
        add(jbbuscar);
        add(jlrealizar);
        add(jtbusqueda);
        add(jllistado);
        add(scroll);

                
    }
    
private void jtfiltrobusqueda() {
        String textobusqueda = jtbusqueda.getText();
        
        if(textobusqueda.isEmpty()){
            llenarLista(ventanaprincipal.arregloproducto);
        }else{
            llenarLista(Filtrobusqueda.filtroProducto(ventanaprincipal.arregloproducto, textobusqueda));
        }
        
    }

    private void llenarLista(producto[] filtroNit) {
//tabla
    //como borrar filas
        int contadordefilas = ventanaprincipal.modeloproductos.getRowCount();
        for (int i = 0;contadordefilas>i; i++) {
            ventanaprincipal.modeloproductos.removeRow(0);
        }
    //lenar las filas con los elementos encontrados
        int i = 0;
        while(filtroNit[i] != null){
            
            String nombre=filtroNit[i].getNombre();
            double precio=filtroNit[i].getPrecio();
            int cantidad=filtroNit[i].getCantidad();
            String datos[] = {nombre,String.valueOf(precio),Integer.toString(cantidad)};
            ventanaprincipal.modeloproductos.addRow(datos);
            
            i++;
        }

        
    }

}
