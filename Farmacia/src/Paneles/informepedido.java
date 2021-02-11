/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import ventana.ventanaprincipal;

/**
 *
 * @author elser
 */
public class informepedido extends JDialog{
//botones
    private JButton jbproductos; 
    private JButton jbgenerarestado; 
    private JButton jbgenerarzona; 
    private JButton jbgenerafecha; 
//texto Fijo
    private JLabel jlproductoscompra;
    private JLabel jlfecha;
    private JLabel jlzona;
    private JLabel jlestado;
//cuadro de texto cantidad a agregar
    private JTextField jtzona;
    private JRadioButton jrentregado;
    private JRadioButton jrpendiente;
            
    public informepedido() {
        setTitle("Informe Pedidos");
        setModal(true);//bloquear uso de la ventana anterior
        setLayout(null);
        setSize(500,300);//tamaño, ancho, alto
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//terminar el proceso al cerrar la ventana
        setResizable(false);//no puede cambiarse el tamaño
        setLocationRelativeTo(null);//posicion de la ventana(centro de pantalla)
        
        botones();
        texto();
        colocargrafico();
        
    }

    private void botones() {
   
       jrentregado= new JRadioButton("entregado");
       jrentregado.setBounds(50,240,125,25);
       jrentregado.setSelected(true);
       jrpendiente= new JRadioButton("pendiente");
       jrpendiente.setBounds(200,240,125,25);
       
       jbgenerafecha= new JButton("Generar");
       jbgenerafecha.setBounds(500-150,120,100,25);
       jbgenerafecha.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                informefecha();
                
            }

        }
        );

       jbgenerarzona= new JButton("Generar");
       jbgenerarzona.setBounds(500-150,180,100,25);       
       jbgenerarzona.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                informezona();
                
            }

        }
        );       

       jbgenerarestado= new JButton("Generar");
       jbgenerarestado.setBounds(500-150,240,100,25);        
       jbgenerarestado.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                informeestado();
                
            }

        }
        );        
       
       jbproductos= new JButton("Generar");
       jbproductos.setBounds(500-150,60,100,25); 
       jbproductos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                informeproductos();
                
            }

        }
        ); 

    
        ButtonGroup grupo;
        grupo = new ButtonGroup();
        grupo.add(jrentregado);
        grupo.add(jrpendiente);   
       
    }
    
    private void texto() {
        jlestado = new JLabel("Informe por estado",JLabel.LEFT);
        jlestado.setBounds(50,215,500,25);
        
        jlzona = new JLabel("Informe por zona",JLabel.LEFT);
        jlzona.setBounds(50,150,500,25);
        
        jlfecha = new JLabel("Informe por fecha",JLabel.LEFT);
        jlfecha.setBounds(50,150-65,500,25);
        
        jlproductoscompra = new JLabel("Productos de los pedidos",JLabel.LEFT);
        jlproductoscompra.setBounds(50,20,500,25);
        
        jtzona= new JTextField("11");
        jtzona.setBounds(150,180,50,25);
        
        
    }    

    private void colocargrafico() {
     //Botones   
        add(jbproductos);
        add(jbgenerarestado);
        add(jbgenerarzona);
        add(jbgenerafecha);
        add(jrentregado);
        add(jrpendiente);
    //Texto
        add(jlestado);
        add(jlzona);
        add(jlfecha);
        add(jlproductoscompra);
    //ingresar texto            
        add(jtzona);

        
    }

    private void informefecha() {
        datospedidos arreglo[]= new datospedidos[20];
        arreglo= ventanaprincipal.arreglopedidos.clone();//copiar el arreglo para hacer un ordenamiento por fecha.
        
        datospedidos aux[]= new datospedidos[20];
        aux= ventanaprincipal.arreglopedidos.clone();
    //ordenar por mes menor a mayor  
        for (int i = 0; i < arreglo.length; i++) {//recorre el arreglo
            if(arreglo[i] !=null){//verifica si existe la posicion creada
                for (int j=i+1; j <arreglo.length; j++) {
                    if (arreglo[j]!=null) {
                        
                        if(arreglo[i].getMespedido()>arreglo[j].getMespedido()){
                            aux[0]=arreglo[i];
                            arreglo[i]=arreglo[j];
                            arreglo[j]=aux[0];
                        }
                    }
                    
                }
            
            }
            
        }
    //ordenar por dia menor a mayor  
        for (int i = 0; i < arreglo.length; i++) {//recorre el arreglo
            if(arreglo[i] !=null){//verifica si existe la posicion creada
                for (int j=i+1; j <arreglo.length; j++) {
                    if (arreglo[j]!=null) {
                        
                        if(arreglo[i].getMespedido()==arreglo[j].getMespedido()){//veriica si son el mismo mes
                            if(arreglo[i].getDiapedido()>arreglo[j].getDiapedido()){
                            aux[0]=arreglo[i];
                            arreglo[i]=arreglo[j];
                            arreglo[j]=aux[0];
                            }
                            
                            
                        }
                    }
                    
                }
            
            }
            
        }        
      
        
        
        
        
                try {
                    Document productosnecesarios= new Document();
                    FileOutputStream ficheroPdf = new FileOutputStream("Informe_Fecha.pdf");
                    
                    PdfWriter.getInstance(productosnecesarios, ficheroPdf);
                    productosnecesarios.open();
                    Paragraph titulo = new Paragraph("Pedidos ordenados por fecha");
                    Paragraph espacio = new Paragraph(" ");
                    espacio.setAlignment(1);
                    titulo.setAlignment(1);
                    productosnecesarios.add(titulo);
                    productosnecesarios.add(espacio);
                    
                    
                    PdfPTable tabla =new PdfPTable(7);
                    
                    tabla.addCell("Nombres");
                    tabla.addCell("CUI");
                    tabla.addCell("NIT");
                    tabla.addCell("Direccion");
                    tabla.addCell("Fecha del Pedido");
                    tabla.addCell("Monto total");
                    tabla.addCell("Estado");
                    String nit;
                    for (int i = 0; i < arreglo.length; i++) {//recorre el arreglo de pedidos
                        if (arreglo[i] !=null) {//veriica si existe la posicion creada
                                 nit = arreglo[i].getNitcliente();//copia el nit del pedido
                                for (int j = 0; j < ventanaprincipal.arreglocliente.length; j++) {//recorre el arrglo de clinets
                                    if(ventanaprincipal.arreglocliente[j] !=null){
                                        if(ventanaprincipal.arreglocliente[j].getNit().equals(nit)){//busca un clinete con ese nit
                                          tabla.addCell(ventanaprincipal.arreglocliente[j].getNombres());
                                          tabla.addCell(ventanaprincipal.arreglocliente[j].getCui());
                                          tabla.addCell(ventanaprincipal.arreglocliente[j].getNit());
                                          tabla.addCell(ventanaprincipal.arreglocliente[j].getCalle()+" "+" "+ventanaprincipal.arreglocliente[j].getColonia()+"Zona "+ventanaprincipal.arreglocliente[j].getZona());
                                          tabla.addCell(String.valueOf(arreglo[i].getDiapedido())+"/"+String.valueOf(arreglo[i].getMespedido())+"/"+String.valueOf(arreglo[i].getAñopedido()));
                                          tabla.addCell(String.valueOf(arreglo[i].getGastototal()));
                                          tabla.addCell(String.valueOf(arreglo[i].getEstado()));
                                          
                                        
                                        }
                               
                                    }
                                    
                                }
            
                            
                        }
                    
                    }
                    
                    productosnecesarios.add(tabla);
                    productosnecesarios.close();
                    
                    File obje=new File("Informe_Fecha.pdf");
                    Desktop.getDesktop().open(obje);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(panelinformes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(panelinformes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(panelinformes.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        
        
        
    
    }

    
    private void informezona() {
        String zona=jtzona.getText();
        String estado;
        estado="pendiente";
        
                try {
                    Document productosnecesarios= new Document();
                    FileOutputStream ficheroPdf = new FileOutputStream("Informe_Zona.pdf");
                    
                    PdfWriter.getInstance(productosnecesarios, ficheroPdf);
                    productosnecesarios.open();
                    Paragraph titulo = new Paragraph("Pedidos con estado "+estado+"por zona");
                    Paragraph espacio = new Paragraph(" ");
                    espacio.setAlignment(1);
                    titulo.setAlignment(1);
                    productosnecesarios.add(titulo);
                    productosnecesarios.add(espacio);
                    
                    
                    PdfPTable tabla =new PdfPTable(6);
                    
                    tabla.addCell("Nombres");
                    tabla.addCell("CUI");
                    tabla.addCell("NIT");
                    tabla.addCell("Direccion");
                    tabla.addCell("Fecha del Pedido");
                    tabla.addCell("Monto total");
                    String nit;
                    for (int i = 0; i < ventanaprincipal.arreglopedidos.length; i++) {
                        if (ventanaprincipal.arreglopedidos[i] !=null) {
                            if(ventanaprincipal.arreglopedidos[i].getEstado().equals(estado)){//verifica si poseen ese estado
                                 nit = ventanaprincipal.arreglopedidos[i].getNitcliente();//copia el nit del pedido
                                for (int j = 0; j < ventanaprincipal.arreglocliente.length; j++) {//recorre el arrglo de clinets
                                    if(ventanaprincipal.arreglocliente[j] !=null){
                                        if(ventanaprincipal.arreglocliente[j].getNit().equals(nit)){//busca un clinete con ese nit
                                         if(ventanaprincipal.arreglocliente[j].getZona().equals(zona)){//veriica si un cliente posee dicha zona
                                          tabla.addCell(ventanaprincipal.arreglocliente[j].getNombres());
                                          tabla.addCell(ventanaprincipal.arreglocliente[j].getCui());
                                          tabla.addCell(ventanaprincipal.arreglocliente[j].getNit());
                                          tabla.addCell(ventanaprincipal.arreglocliente[j].getCalle()+" "+" "+ventanaprincipal.arreglocliente[j].getColonia()+"Zona "+ventanaprincipal.arreglocliente[j].getZona());
                                          tabla.addCell(String.valueOf(ventanaprincipal.arreglopedidos[i].getDiapedido())+"/"+String.valueOf(ventanaprincipal.arreglopedidos[i].getMespedido())+"/"+String.valueOf(ventanaprincipal.arreglopedidos[i].getAñopedido()));
                                          tabla.addCell(String.valueOf(ventanaprincipal.arreglopedidos[i].getGastototal()));
                                        }
                                        }
                               
                                    }
                                    
                                }
            
                            }
                        }
                    
                    }
                    
                    productosnecesarios.add(tabla);
                    productosnecesarios.close();
                    
                    File obje=new File("Informe_Zona.pdf");
                    Desktop.getDesktop().open(obje);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(panelinformes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(panelinformes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(panelinformes.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        
        
        
    
    }

    private void informeestado() {
        String estado;
        if (jrentregado.isSelected()) {
            estado="entregado";
        }else{
            estado="pendiente";
        }
        
        
                try {
                    Document productosnecesarios= new Document();
                    FileOutputStream ficheroPdf = new FileOutputStream("Informe_Estado.pdf");
                    
                    PdfWriter.getInstance(productosnecesarios, ficheroPdf);
                    productosnecesarios.open();
                    Paragraph titulo = new Paragraph("Pedidos con estado "+estado);
                    Paragraph espacio = new Paragraph(" ");
                    espacio.setAlignment(1);
                    titulo.setAlignment(1);
                    productosnecesarios.add(titulo);
                    productosnecesarios.add(espacio);
                    
                    
                    PdfPTable tabla =new PdfPTable(4);
                    
                    tabla.addCell("Nombres");
                    tabla.addCell("CUI");
                    tabla.addCell("NIT");
                    tabla.addCell("Monto total");
                    String nit;
                    for (int i = 0; i < ventanaprincipal.arreglopedidos.length; i++) {
                        if (ventanaprincipal.arreglopedidos[i] !=null) {
                            if(ventanaprincipal.arreglopedidos[i].getEstado().equals(estado)){
                                nit=ventanaprincipal.arreglopedidos[i].getNitcliente();
                                for (int j = 0; j < ventanaprincipal.arreglocliente.length; j++) {
                                    if(ventanaprincipal.arreglocliente[j] !=null){
                                        if(ventanaprincipal.arreglocliente[j].getNit().equals(nit)){
                                          tabla.addCell(ventanaprincipal.arreglocliente[j].getNombres());
                                          tabla.addCell(ventanaprincipal.arreglocliente[j].getCui());
                                        }
                                    
                                    }
                                    
                                }
                                tabla.addCell(ventanaprincipal.arreglopedidos[i].getNitcliente());
                                tabla.addCell(String.valueOf(ventanaprincipal.arreglopedidos[i].getGastototal()));
            
                            }
                        }
                    
                    }
                    
                    productosnecesarios.add(tabla);
                    productosnecesarios.close();
                    
                    File obje=new File("Informe_Estado.pdf");
                    Desktop.getDesktop().open(obje);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(panelinformes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(panelinformes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(panelinformes.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        
        
        
    
    }
    
    private void informeproductos() {
        datospedidos arreglo[]= new datospedidos[20];
        arreglo= ventanaprincipal.arreglopedidos.clone();//copiar el arreglo para hacer un ordenamiento por fecha.

                try {
                    Document productosnecesarios= new Document();
                    FileOutputStream ficheroPdf = new FileOutputStream("Informe_productos.pdf");
                    
                    PdfWriter.getInstance(productosnecesarios, ficheroPdf);
                    productosnecesarios.open();
                    Paragraph titulo = new Paragraph("Productos de los Pedidos");
                    Paragraph espacio = new Paragraph(" ");
                    espacio.setAlignment(1);
                    titulo.setAlignment(1);
                    productosnecesarios.add(titulo);
                    productosnecesarios.add(espacio);
                    
                    
                    PdfPTable tabla =new PdfPTable(6);
                    String nit;
                    for (int i = 0; i <arreglo.length; i++) {
                        if (arreglo[i] !=null) {//recorre el arreglo para copiar datos del pedido
                            nit= arreglo[i].getNitcliente();
                        //agregar los titutols    
                            tabla.addCell("Nombres");
                            tabla.addCell("CUI");
                            tabla.addCell("NIT");
                            tabla.addCell("Direccion");
                            tabla.addCell("Fecha del Pedido");
                            tabla.addCell("Estado");
                        //recorrer el arreglo de clientes pàra copiar los datos     
                            for (int j = 0; j <ventanaprincipal.arreglocliente.length; j++){ 
                                if (ventanaprincipal.arreglocliente[j] !=null) {
                                    if (ventanaprincipal.arreglocliente[j].getNit().equals(nit)) {
                                        tabla.addCell(ventanaprincipal.arreglocliente[j].getNombres());
                                        tabla.addCell(ventanaprincipal.arreglocliente[j].getCui());
                                        tabla.addCell(ventanaprincipal.arreglocliente[j].getNit());
                                        tabla.addCell(ventanaprincipal.arreglocliente[j].getCalle()+" "+" "+ventanaprincipal.arreglocliente[j].getColonia()+"Zona "+ventanaprincipal.arreglocliente[j].getZona());
                                        tabla.addCell(String.valueOf(arreglo[i].getDiapedido())+"/"+String.valueOf(arreglo[i].getMespedido())+"/"+String.valueOf(arreglo[i].getAñopedido()));
                                        tabla.addCell(String.valueOf(arreglo[i].getEstado()));
                                        
                                    }
                                    
                                }
                                
                            }
                            tabla.addCell("Producto");
                            tabla.addCell(" ");
                            tabla.addCell("Cantidad Total");
                            tabla.addCell(" ");
                            tabla.addCell("Precio total");
                            tabla.addCell(" ");
                            //recorre la info de los productos pedidos
                            producto p[]=arreglo[i].getProducto().clone(); 
                            for (int j = 0; j <p.length; j++) {
                                tabla.addCell(p[j].getNombre());
                                tabla.addCell(" ");
                                tabla.addCell(String.valueOf(p[j].getCantidad()));
                                tabla.addCell(" ");
                                tabla.addCell(String.valueOf(p[j].getPrecio()));
                                tabla.addCell(" "); 
                                
                            }
                            
                            
                            
                            
                            tabla.addCell(" ");
                            tabla.addCell(" ");
                            tabla.addCell(" ");
                            tabla.addCell(" ");
                            tabla.addCell("monto total");
                            tabla.addCell(String.valueOf(arreglo[i].getGastototal()));
                            tabla.addCell(" ");
                            tabla.addCell(" ");
                            tabla.addCell(" ");
                            tabla.addCell(" ");
                            tabla.addCell(" ");
                            tabla.addCell(" ");
                        }
                        
                    }
                    
                    productosnecesarios.add(tabla);
                    productosnecesarios.close();
                    
                    File obje=new File("Informe_productos.pdf");
                    Desktop.getDesktop().open(obje);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(panelinformes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(panelinformes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(panelinformes.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        
        
        
    
    }
     
    
}
