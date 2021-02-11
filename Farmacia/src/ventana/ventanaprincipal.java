/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana;

import javax.swing.JFrame;
import Paneles.panelclientes;
import Paneles.panelinformes;
import Paneles.panelproductos;
import Paneles.panelventasypedidos;
import javax.swing.JTabbedPane;
import Paneles.cliente;
import Paneles.datospedidos;
import Paneles.producto;
import Paneles.producto2;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elser
 */
public class ventanaprincipal extends JFrame{
    //tabla que contine los productos
    public static JTable tablaproductos; //tabla que contiene los productos
    public static DefaultTableModel modeloproductos;//modelo que contine los productos
    public static String[] titulosproductos = {"Producto","Precio","Cantidad disponible"};//titulos de la tabla
    //tabla que contine los clientes
    public static JTable tablaclientes;
    public static DefaultTableModel modeloclientes;//modelo que contine los clientes
    Object[][] data=new Object[0][0];
    static String[] titulosclientes = {"Nombre","Apellido","Nit"};//titulos de la tabla
    
    //instancias para llamar a alas clases
    panelclientes mipanelclientes;
    panelinformes mipanelinformes;
    panelproductos mipanelproductos;
    panelventasypedidos mipanelventasypedidos;
    
    JTabbedPane pestañas;
    //clientes
    public  static int conteoagregar;//permite agregar clientes en la siguiente posicion del arreglo
    public  static int conteopedido;//permite agregar nuevos pedidos
    public  static int conteocompra;//permite agregar productos y registrarlo en arreglo
    public static cliente arreglocliente[]= new cliente[20];//arreglo que posee la informacion de los clientes
    public static DefaultListModel dlmModelo;
    public static JList jlLista;//listado de los clientes
    //productos
    public static producto2 arreglocompra[]=new producto2[100];//arreglo que posee la informacion de compras al inventario
    public static producto arregloproducto[]=new producto[20];//arreglo que posee la informacion de los productos
    public static DefaultListModel dlmModeloproducto;
    public static JList jlListaproducto;//listado de los clientes
    //listado de pedidos
    public static datospedidos arreglopedidos[]= new datospedidos[20];
    
    
    public ventanaprincipal(){
        super.setTitle("Farmacia");
        setSize(600,400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        conteoagregar=10;
        conteopedido=10;
        conteocompra=10;
        
        llenarclientes();//informacion inicial clientes registrados
        llenarproductos();//informacion inicial productos en inventario
        listadopedidos();//informacion inicial pedidos realizados
        comprasinventario();//informacion inicial producto agregado al inventario
        iniciarcomponentes();//informacion inicial
    }


    private void iniciarcomponentes() {
     pestañas= new JTabbedPane();
     mipanelproductos= new panelproductos();
     mipanelclientes= new panelclientes();
     mipanelventasypedidos= new  panelventasypedidos();
     mipanelinformes= new panelinformes();
     
     //agregar los paneles
     pestañas.add("     PRODUCTOS     ",mipanelproductos);
     pestañas.add("     CLIENTES     ",mipanelclientes);
     pestañas.add("     VENTAS Y PEDIDOS    ",mipanelventasypedidos);
     pestañas.add("     INFORMES     ",mipanelinformes);
     
    add(pestañas);
    }

    private void llenarclientes() {
    //listado de los clientes   
    //iniciar la matriz con info de los clientes
        String nombres[]={"Jose Antonio","Sarah Elisabeth","Axel Ivan","Ricardo Alfredo","Estefani Mena","Jackeline","Ted","Barney","Karla","María Alejandra"};
        String apellidos[]={"Estrada Medina","Aguilar Rivas","Ruiz Garcia","Sontay","Molina","Escobar Flores","Mosby","Steanson","Mayorga","Arenas"};
        int edad[]={45,23,34,27,18,56,34,53,23,29};
        String cui[]={"2837463847384","3847265938273","3827495628383","8375927365324","2384729373834","5756293473829","5628394982639","2923774928374","3234958263948","2837502736492"};
        String nit[]={"3355446-4","334422-5","436423-4","2346434-3","5434634-4","3453234-3","334455-2","6534354-3","5346634-3","4365457-3"};
        int dia[]={1,1,1,1,1,1,1,1,1,1};
        int mes[]={10,10,10,10,10,10,10,10,10,10};
        int año[]={2017,2017,2017,2017,2017,2017,2017,2017,2017,2017};
        String nocasa[]={"54-34","3-43","5-23","9-43","4-23","5-23","9-23","2-53","5-23","3-21"};
        String colonia[]={"3 av","","","8 av","","","5 av","","7 av",""};
        String calle[]={"","5","6","8","9","4","5","4","7","9"};
        String zona[]={"11","8","9","12","11","12","10","1","2","8"};
        
        for(int i = 0; i <nombres.length; i++){
            arreglocliente[i] = new cliente(nombres[i], apellidos[i], edad[i], cui[i], nit[i], dia[i], mes[i], año[i], nocasa[i], colonia[i], calle[i], zona[i]);       
        }

//listado clientes en tabla
    //mostrar con una tabla        
        modeloclientes = new DefaultTableModel(data,titulosclientes){
        //evitar edicion de tabla
        public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
        };
        tablaclientes = new JTable(modeloclientes);
        for (int i = 0; i < nombres.length; i++) {
            String nombre= arreglocliente[i].getNombres();
            String apellido= arreglocliente[i].getApellidos();
            String nitt= arreglocliente[i].getNit();
            String datos[] = {nombre,apellido,nitt};
            modeloclientes.addRow(datos);
        }    
    }

    private void llenarproductos() {
//listado de los productos

        String nombre[]={"Aspirina 500mg","Aspirina 200mg","Alcoho","Agua oxigenada","Paracetamol","Jeringa 10ml","Neurovion","Venda elastica","Gasa esteril","guantes desechables"};
        int cantidad[]={1800,4000,300,500,800,80,250,100,20,3000};
        double precio[]={0.45,0.32,4.25,6.35,0.40,1.15,0.92,18.95,2.25,1.15};
        
        for(int i = 0; i <nombre.length; i++){
            arregloproducto[i] = new producto(precio[i],cantidad[i],nombre[i]);//crea el arreglo
        }
    
//mostrar con una tabla        
        modeloproductos = new DefaultTableModel(data,titulosproductos){
        //evitar edicion de tabla
        public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
        };
        tablaproductos = new JTable(modeloproductos);
        for (int i = 0; i < 10; i++) {
            String nombreproducto= arregloproducto[i].getNombre();
            double precioproducto=ventanaprincipal.arregloproducto[i].getPrecio();
            int cantidadproducto=ventanaprincipal.arregloproducto[i].getCantidad();
            String datosproducto[] = {nombreproducto,String.valueOf(precioproducto),Integer.toString(cantidadproducto)};
            modeloproductos.addRow(datosproducto);
        }
                
        
        
    }

    private void listadopedidos() {
        String estado[]={"entregado","pendiente","entregado","pendiente","entregado","pendiente","entregado","pendiente","entregado","pendiente"}; 
        String nitcliente[]={"3355446-4","4365457-3","436423-4","3355446-4","5346634-3","3453234-3","334455-2","3355446-4","5346634-3","4365457-3"}; 
        int diapedido[]={12,12,13,14,15,16,17,18,19,20}; 
        int mespedio[]={7,8,9,7,2,8,4,4,5,4}; 
        double gastototal[]={7,8,9,7,2,8,4,4,5,4}; 
        int añopedido[]={2017,2017,2017,2017,2017,2017,2017,2017,2017,2017};
        producto inicial[]= new producto[10];
        
    for(int i = 0; i <nitcliente.length; i++){
            arreglopedidos[i]=new datospedidos(estado[i],nitcliente[i],diapedido[i], mespedio[i],añopedido[i] , inicial,gastototal[i]);
        }
//productos que adquirieron 
    //compra 1
        producto inicial1[]= new producto[3];
        double total1=0;
        String nombreproducto[]={"Aspirina 500mg","Paracetamol","Alcoho"};
        int cantidadproducto[]={400,800,12};
        double totalproducto[]={0.45*400,0.4*800,4.25*12};
        for (int i = 0; i < 3; i++) {
            inicial1[i]= new producto(totalproducto[i],cantidadproducto[i],nombreproducto[i]);
            total1=total1+totalproducto[i];
        }
        arreglopedidos[0].setProducto(inicial1);
        arreglopedidos[0].setGastototal(total1);
        
    //compra 2
        producto inicial2[]= new producto[3];
        total1=0;
        String nombreproducto2[]={"Aspirina 200mg","Jeringa 10ml","Agua oxigenada"};
        int cantidadproducto2[]={300,60,30};
        double totalproducto2[]={300*0.32,60*1.15,30*6.35};
        for (int i = 0; i < 3; i++) {
            inicial2[i]= new producto(totalproducto2[i],cantidadproducto2[i],nombreproducto2[i]);
            total1=total1+totalproducto2[i];
        }
        arreglopedidos[1].setProducto(inicial2);
        arreglopedidos[1].setGastototal(total1);
    //compra 3
        producto inicial3[]= new producto[3];
        total1=0;
        String nombreproducto3[]={"Alcoho","Neurovion","Paracetamol"};
        int cantidadproducto3[]={20,200,250};
        double totalproducto3[]={4.25*20,0.92*200,0.4*250};
        for (int i = 0; i < 3; i++) {
            inicial3[i]= new producto(totalproducto3[i],cantidadproducto3[i],nombreproducto3[i]);
            total1=total1+totalproducto3[i];
        }
        arreglopedidos[2].setProducto(inicial3);
        arreglopedidos[2].setGastototal(total1);
    //compra 4    
        producto inicial4[]= new producto[2];
        total1=0;
        String nombreproducto4[]={"Agua oxigenada","Venda elastica"};
        int cantidadproducto4[]={5,14};
        double totalproducto4[]={5*6.35,14*18.95};
        for (int i = 0; i < 2; i++) {
            total1=total1+totalproducto4[i];
            inicial4[i]= new producto(totalproducto4[i],cantidadproducto4[i],nombreproducto4[i]);
        }
        arreglopedidos[3].setProducto(inicial4);
        arreglopedidos[3].setGastototal(total1);
    //compra 5
        producto inicial5[]= new producto[2];
        total1=0;
        String nombreproducto5[]={"Paracetamol","Gasa esteril"};
        int cantidadproducto5[]={300,200};
        double totalproducto5[]={300*0.4,200*2.25};
        for (int i = 0; i < 2; i++) {
            total1=total1+totalproducto5[i];
            inicial5[i]= new producto(totalproducto5[i],cantidadproducto5[i],nombreproducto5[i]);
        }
        arreglopedidos[4].setProducto(inicial5);
        arreglopedidos[4].setGastototal(total1);
    //compra 6
        producto inicial6[]= new producto[2];
        total1=0;
        String nombreproducto6[]={"Jeringa 10ml","guantes desechables"};
        int cantidadproducto6[]={12,80};
        double totalproducto6[]={12*1.15,80*1.15};
        for (int i = 0; i < 2; i++) {
            total1=total1+totalproducto6[i];
            inicial6[i]= new producto(totalproducto6[i],cantidadproducto6[i],nombreproducto6[i]);
        }
        arreglopedidos[5].setProducto(inicial6);
        arreglopedidos[5].setGastototal(total1);
    //compra 7
        producto inicial7[]= new producto[1];
        total1=30*0.92;
        inicial7[0]= new producto(30*0.92,30,"Neurovion");
        arreglopedidos[6].setProducto(inicial7);
        arreglopedidos[6].setGastototal(total1);
    //compra 8
        producto inicial8[]= new producto[1];
        total1=18.95*2;
        inicial8[0]= new producto(18.95*2,2,"Venda elastica");
        arreglopedidos[7].setProducto(inicial8);
        arreglopedidos[7].setGastototal(total1);
    //compra 9
        producto inicial9[]= new producto[1];
        total1=50*2.25;
        inicial9[0]= new producto(50*2.25,50,"Gasa esteril");
        arreglopedidos[8].setProducto(inicial9);
        arreglopedidos[8].setGastototal(total1);
    //compra 10
        producto inicial10[]= new producto[1];
        total1=20*1.15;
        inicial10[0]= new producto(20*1.15,20,"guantes desechables");
        arreglopedidos[9].setProducto(inicial10);
        arreglopedidos[9].setGastototal(total1);
        
    }

    private void comprasinventario() {
        String nombre[]={"Aspirina 500mg","Aspirina 200mg","Alcoho","Agua oxigenada","Paracetamol","Jeringa 10ml","Neurovion","Venda elastica","Gasa esteril","guantes desechables"};
        int dia[]={12,12,13,14,15,16,17,18,19,20};
        int mes[]={7,8,9,7,2,8,4,4,5,4};
        int año[]={2017,2017,2017,2017,2017,2017,2017,2017,2017,2017};
        int cantidad[]={8000,3000,200,300,2000,800,3000,100,2000,3000};
        
        for(int i = 0; i <nombre.length; i++){
            arreglocompra[i] = new producto2(nombre[i], dia[i], mes[i], año[i], cantidad[i]);//crea el arreglo
        }
        
    }
    
}
