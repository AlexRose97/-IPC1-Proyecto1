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
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import ventana.ventanaprincipal;

/**
 *
 * @author elser
 */
    public class generarpedido1 extends JDialog {
        JTable tabla;
        JScrollPane scroll;
        DefaultTableModel modelopedido;
        Object[][] data=new Object[0][0];
        Object [] fila=new Object[8];
        static String[] titulosproducto = {"Producto","Precio","Cantidad disponible"};
        public static   int cantidadprod;//productosquepuedesagregar
        
        JTable tabla2;
        JScrollPane scroll2;
        public static DefaultTableModel modelopedido2;
        static String[] titulosproducto2 = {"Producto","Precio total","Cantidad agregada"};
        
    
//texto sin modificar titulos
        
    private JLabel jlinstrucciones;
    private JLabel jlnombres;
    private JLabel jlapellidos;
    private JLabel jledad;
    private JLabel jlcui;
    private JLabel jlnit;
    private JLabel jldireccion;
    private JLabel jlfecha;
    private JLabel jlfechaactual;
    private JLabel jllistadodepedidos;
//texto que ingresa el usuario clientes
    public static JLabel jlnombres1;
    public static JLabel jlapellidos1;
    public static JLabel jledad1;
    public static JLabel jlcui1;
    public static JLabel jlnit1;
    public static JLabel jldireccion1;
    public static JLabel jlfecha1;
    
    private JTextField jttextobusqueda;
    
//Botones
    private JButton jbgenerar;
    private JButton jbcancelar;
    private JButton jbbuscar;
//fecha separada
    private JTextField jtfechadia;
    private JTextField jtfechames;
    private JTextField jtfechaaño;    
    
    public generarpedido1() {
       
        setTitle("Generar Pedido");
        setModal(true);//bloquear uso de la ventana anterior
        setLayout(null);
        setSize(600,560);//tamaño, ancho, alto
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//terminar el proceso al cerrar la ventana
        setResizable(false);//no puede cambiarse el tamaño
        setLocationRelativeTo(null);//posicion de la ventana(centro de pantalla)

        cantidadprod=9;
        botones();
        texto();
        tablaproductos();
        productosdelpedido();
        colocargrafico();
    }    

    private void botones() {
        jbgenerar= new JButton("GENERAR PEDIDO");
        jbgenerar.setBounds(320,500,200,25);
        jbgenerar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pos=0;
                double gastototal=0;
                if(cantidadprod==8){pos=1;}
                if(cantidadprod==7){pos=2;}
                if(cantidadprod==6){pos=3;}
                if(cantidadprod==5){pos=4;}
                if(cantidadprod==4){pos=5;}
                if(cantidadprod==3){pos=6;}
                if(cantidadprod==2){pos=7;}
                if(cantidadprod==1){pos=8;}
                if(cantidadprod==0){pos=9;}
                if(cantidadprod==-1){pos=10;}
                    producto prod[]= new producto[pos];
                for (int i = 0; i < pos; i++) {
                        String productoseleccionado=tabla2.getValueAt(i,0).toString();//Copia el Nombre del producto ya que esta en columna 0
                        String preciototal=tabla2.getValueAt(i,1).toString();//Copia el precio del producto ya que esta en columna 1;
                        String cantidadselecionado=tabla2.getValueAt(i,2).toString();//Copia el cantidad del producto ya que esta en columna 2;
                        gastototal=gastototal+Double.parseDouble(preciototal);
                //enviar listado de productos al arreglopedidos
                        prod[i]= new producto(Double.parseDouble(tabla2.getValueAt(i,1).toString()),Integer.parseInt(tabla2.getValueAt(i,2).toString()),tabla2.getValueAt(i,0).toString());
                        
                //restar valores de productos        
                        if(ventanaprincipal.arregloproducto[i].getNombre().equals(productoseleccionado)){
                            int cantidadexistente=ventanaprincipal.arregloproducto[i].getCantidad();
                            cantidadexistente=cantidadexistente-Integer.parseInt(cantidadselecionado);
                            ventanaprincipal.arregloproducto[i].setCantidad(cantidadexistente);
                            }
                }
                JOptionPane.showMessageDialog(null,"gasto total es :"+gastototal);
                String estado="pendiente";
                String nitcliente=jlnit1.getText();
                int diapedido= Integer.parseInt(jtfechadia.getText());
                int mespedio=Integer.parseInt(jtfechames.getText());
                int añopedido=2017;
                
                ventanaprincipal.arreglopedidos[ventanaprincipal.conteopedido]= new datospedidos(estado,nitcliente,diapedido, mespedio,añopedido , prod,gastototal);
                ventanaprincipal.conteopedido++;
                dispose();
                              
                
                
            }
        });
 
        
        jbcancelar = new JButton("CANCELAR");
        jbcancelar.setBounds(70,500,200,25);
        //evento de cerrar la ventana al presionar "cancelar"
        jbcancelar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });
    
        jbbuscar= new JButton("BUSCAR");
        jbbuscar.setBounds(400,200,100,25);
        jbbuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtfiltrobusqueda();
               }    
        });
    }

    private void texto() {
    //textos titulo
        jlnombres= new JLabel("Nombres:",JLabel.RIGHT);
        jlnombres.setBounds(20,10,90,25);
        jlapellidos= new JLabel("Apellidos:",JLabel.RIGHT);
        jlapellidos.setBounds(20,50,90,25);
        jlfecha= new JLabel("Registrado:",JLabel.RIGHT);
        jlfecha.setBounds(20,90,90,25);
        
        jlcui= new JLabel("CUI:",JLabel.RIGHT);
        jlcui.setBounds(350,10,90,25);
        jlnit= new JLabel("NIT:",JLabel.RIGHT);
        jlnit.setBounds(350,50,90,25);
        jledad= new JLabel("Edad:",JLabel.RIGHT);
        jledad.setBounds(350,90,90,25);

        jldireccion= new JLabel("Direccion:",JLabel.RIGHT);
        jldireccion.setBounds(20,130,90,25);
    //textos que agregara el usuario
        jlnombres1= new JLabel("_",JLabel.LEFT);
        jlnombres1.setBounds(120,10,220,25);
        jlapellidos1= new JLabel("_",JLabel.LEFT);
        jlapellidos1.setBounds(120,50,220,25);
        jlfecha1= new JLabel("_",JLabel.LEFT);
        jlfecha1.setBounds(120,90,220,25);
        jlcui1= new JLabel("_",JLabel.LEFT);
        jlcui1.setBounds(450,10,220,25);
        jlnit1= new JLabel("_",JLabel.LEFT);
        jlnit1.setBounds(450,50,220,25);
        jledad1= new JLabel("_",JLabel.LEFT);
        jledad1.setBounds(450,90,90,25);
        jldireccion1= new JLabel("_",JLabel.LEFT);
        jldireccion1.setBounds(120,130,300,25);        
        
        //fecha separada
        jlfechaactual = new JLabel("Fecha en que se genera el pedido:",JLabel.RIGHT);
        jlfechaactual.setBounds(20,170,250,25);
        jtfechadia= new JTextField("01");
        jtfechadia.setBounds(270+5,170,25,25);
        jtfechames= new JTextField("01");
        jtfechames.setBounds(295+10,170,25,25);
        jtfechaaño= new JTextField("2017");
        jtfechaaño.setBounds(320+15,170,40,25);        
        jtfechaaño.setEditable(false);        
        
        jlinstrucciones= new JLabel("De doble clic sobre el producto que desea agregar a su pedido.");
        jlinstrucciones.setBounds(50,220,500,25);
        jllistadodepedidos= new JLabel("LISTADOS DE PEDIDOS",JLabel.CENTER);
        jllistadodepedidos.setBounds(0,340,600,25);
        jttextobusqueda= new JTextField("Escriba el nombre del producto");
        jttextobusqueda.setBounds(50,200,350,25);
        
    }
    private void colocargrafico() {
    //Botones
        add(jbgenerar);
        add(jbcancelar);
        add(jbbuscar);
    //fecha separada
            add(jtfechadia);
            add(jtfechames);
            add(jtfechaaño);
    //texto sin modificar titulos
        add(jlnombres);
        add(jlapellidos);
        add(jledad);
        add(jlcui);
        add(jlnit);
        add(jlfecha);
        add(jldireccion);
    //texto que ingresa el usuario
        add(jlnombres1);
        add(jlapellidos1);
        add(jledad1);
        add(jlcui1);
        add(jlnit1);
        add(jlfecha1);
        add(jldireccion1); 
        add(jlfechaactual);
        
        add(scroll);    
        add(scroll2);    
        
        
        add(jlinstrucciones);
        add(jllistadodepedidos);
        add(jttextobusqueda);

    
    
    }

private void tablaproductos() {
        modelopedido = new DefaultTableModel(data,titulosproducto){
        public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
        };
       
        tabla=new JTable(modelopedido);
        for (int i = 0; i < 10; i++) {
            String nombre=ventanaprincipal.arregloproducto[i].getNombre();
            double precio=ventanaprincipal.arregloproducto[i].getPrecio();
            int cantidad=ventanaprincipal.arregloproducto[i].getCantidad();
            String datos[] = {nombre,String.valueOf(precio),Integer.toString(cantidad)};
            modelopedido.addRow(datos);
        }
        
        scroll=new JScrollPane(tabla);
        scroll.setBounds(50,240,500,70);
        scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a la tabla
        
        tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me){
                if(me.getClickCount() == 2){// Cuenta la cantidad de clicks para saber si es doble
                    
                    if (cantidadprod>=0) {
                        int fila = tabla.rowAtPoint(me.getPoint());// numero Fila que se selecciona
                        String productoseleccionado=tabla.getValueAt(fila,0).toString();//Copia el Nombre del producto ya que esta en columna 0
                        String precioseleccionado=tabla.getValueAt(fila,1).toString();//Copia el precio del producto ya que esta en columna 1;
                        String cantidadselecionado=tabla.getValueAt(fila,2).toString();//Copia el cantidad del producto ya que esta en columna 2;
                        int x = JOptionPane.showConfirmDialog(null, "¿Desea agregar "+productoseleccionado+" a su pedido?","Comprar Productos",0);
                //si elige que si debemos buscar en el arreglo el producto con ese nombre.    
                        if(x==JOptionPane.YES_OPTION){
                            productopedido producto=new productopedido();
                            productopedido.jlnombreproducto.setText(productoseleccionado);
                            productopedido.jlcantidadproducto.setText(cantidadselecionado);
                            productopedido.jlprecioproducto.setText(precioseleccionado);
                            producto.setVisible(true);
                        
                        llenarLista(ventanaprincipal.arregloproducto);
                        }else{
                        
                    }
                        
                    }else{
                        JOptionPane.showMessageDialog(null,"Ya no puedes agregar mas productos");
                    }
    
                    
                    
                    
                }
            }
        });
        
        
        //como borrar filas
        
        
    }

private void productosdelpedido(){
        modelopedido2 = new DefaultTableModel(data,titulosproducto2){
        public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
        };
       
        tabla2=new JTable(modelopedido2); 
        scroll2=new JScrollPane(tabla2);
        scroll2.setBounds(50,360,500,130);
        scroll2.setBorder(BorderFactory.createLineBorder(Color.BLACK));// Añade borde a la tabla
        

    }

        private void jtfiltrobusqueda() {
        String textobusqueda = jttextobusqueda.getText();
        
        if(textobusqueda.isEmpty()){
            llenarLista(ventanaprincipal.arregloproducto);
        }else{
            llenarLista(Filtrobusqueda.filtroProducto(ventanaprincipal.arregloproducto, textobusqueda));
        }
        
    }

private void llenarLista(producto[] filtroNit) {
//tabla
    //como borrar filas
        int contadordefilas = modelopedido.getRowCount();
        for (int i = 0;contadordefilas>i; i++) {
            modelopedido.removeRow(0);
        }
    //lenar las filas con los elementos encontrados
        int i = 0;
        while(filtroNit[i] != null){
            
            String nombre=filtroNit[i].getNombre();
            double precio=filtroNit[i].getPrecio();
            int cantidad=filtroNit[i].getCantidad();
            String datos[] = {nombre,String.valueOf(precio),Integer.toString(cantidad)};
            modelopedido.addRow(datos);
            
            i++;
        }

        
    }
    
    
}
