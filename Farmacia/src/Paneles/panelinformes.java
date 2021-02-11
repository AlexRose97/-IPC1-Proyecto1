/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ventana.ventanaprincipal;

/**
 *
 * @author elser
 */
public class panelinformes extends JPanel {

    private JButton jbayuda;
    private JButton jbclientesregistrados;
    private JButton jbpedidos;//pedidos compras realizados
    private JButton jbproductosnecesarios;//productos con bajo inventario
    private JButton jbcomprainventario;//productos que fueron agregarso al inventario
    private JButton Jbmayor;//productos que fueron agregarso al inventario
    private JButton Jbmenor;//productos que fueron agregarso al inventario
    
    private JLabel jlpreg1; //seleccione el informe que desea generar.
    
    public panelinformes() {
        setLayout(null);
        
        texto();
        botones();
        agregargrafico();
    }

    private void texto() {
        jlpreg1 = new JLabel("Seleccione el informe que desea generar.");
        jlpreg1.setBounds(150,20,300,25);
    }

    private void botones() {
        
        
        jbclientesregistrados = new JButton("Clientes Registrados");
        jbclientesregistrados.setBounds(50,65,230,25);
        jbclientesregistrados.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    
                try {
                    Document productosnecesarios= new Document();
                    FileOutputStream ficheroPdf = new FileOutputStream("Clientes_Registrados.pdf");
                    
                    PdfWriter.getInstance(productosnecesarios, ficheroPdf);
                    productosnecesarios.open();
                    Paragraph titulo = new Paragraph("CLIENTES EN LOS ULTIMOS 30 DIAS");
                    Paragraph espacio = new Paragraph(" ");
                    espacio.setAlignment(1);
                    titulo.setAlignment(1);
                    productosnecesarios.add(titulo);
                    productosnecesarios.add(espacio);
                    
                    
                    PdfPTable tabla =new PdfPTable(3);
                    tabla.addCell("NOMBRE");
                    tabla.addCell("EDAD");
                    tabla.addCell("CUI");
                    

                    
                    for (int i = 0; i < ventanaprincipal.arreglocliente.length; i++) {
                        if (ventanaprincipal.arreglocliente[i] !=null) {
                            if (ventanaprincipal.arreglocliente[i].getMes()==9 || ventanaprincipal.arreglocliente[i].getMes()==8 ) {
                                if (ventanaprincipal.arreglocliente[i].getDia()>22 &&ventanaprincipal.arreglocliente[i].getMes()==8 || ventanaprincipal.arreglocliente[i].getDia()<22 &&ventanaprincipal.arreglocliente[i].getMes()==9) {
                                    tabla.addCell(ventanaprincipal.arreglocliente[i].getNombres());
                                    tabla.addCell(String.valueOf(ventanaprincipal.arreglocliente[i].getEdad()));
                                    tabla.addCell(ventanaprincipal.arreglocliente[i].getCui());
                                    tabla.addCell("NIT");
                                    tabla.addCell("DIRECCION");
                                    tabla.addCell("FECHA DE REGISTRO");
                                    tabla.addCell(ventanaprincipal.arreglocliente[i].getNit());
                                    tabla.addCell(ventanaprincipal.arreglocliente[i].getCalle()+" "+ventanaprincipal.arreglocliente[i].getColonia()+" "+ventanaprincipal.arreglocliente[i].getNocasa()+" zona "+ventanaprincipal.arreglocliente[i].getZona());
                                    tabla.addCell(String.valueOf(ventanaprincipal.arreglocliente[i].getDia())+"/"+String.valueOf(ventanaprincipal.arreglocliente[i].getMes())+"/2017");
                                    tabla.addCell(" ");
                                    tabla.addCell(" ");
                                    tabla.addCell(" ");
                                }
                            }
                            
                        }
                    
                    }
                    
                    
                    productosnecesarios.add(tabla);
                    productosnecesarios.close();
                    
                    File obje=new File("Clientes_Registrados.pdf");
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
        );
        
        
        jbpedidos = new JButton("Pedidos Realizados");
        jbpedidos.setBounds(50,75+35,230,25);
        jbpedidos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                informepedido informe = new informepedido();
                informe.setVisible(true);
                
            }
        }
        );
        
        
        
        
        
        
        
        
        jbproductosnecesarios = new JButton("Productos Necesarios");
        jbproductosnecesarios.setBounds(60+240,65,230,25);
        jbproductosnecesarios.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    Document productosnecesarios= new Document();
                    FileOutputStream ficheroPdf = new FileOutputStream("Productos_Necesarios.pdf");
                    
                    PdfWriter.getInstance(productosnecesarios, ficheroPdf);
                    productosnecesarios.open();
                    Paragraph titulo = new Paragraph("PRODUCTOS NECESARIOS");
                    Paragraph espacio = new Paragraph(" ");
                    espacio.setAlignment(1);
                    titulo.setAlignment(1);
                    productosnecesarios.add(titulo);
                    productosnecesarios.add(espacio);
                    
                    
                    PdfPTable tabla =new PdfPTable(3);
                    tabla.addCell("Producto");
                    tabla.addCell("Cantidad en inventario");
                    tabla.addCell("Precio");
                    
                    for (int i = 0; i < 10; i++) {
                        if (ventanaprincipal.arregloproducto[i].getCantidad()< 200) {
                            
                              tabla.addCell(ventanaprincipal.arregloproducto[i].getNombre());  
                              tabla.addCell(String.valueOf(ventanaprincipal.arregloproducto[i].getCantidad()));  
                              tabla.addCell(String.valueOf(ventanaprincipal.arregloproducto[i].getPrecio()));  
                            
                            
                        }
                    
                    }
                    
                    productosnecesarios.add(tabla);
                    productosnecesarios.close();
                    
                    File obje=new File("Productos_Necesarios.pdf");
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
        );
         
        jbcomprainventario = new JButton("Productos Agregados");
        jbcomprainventario.setBounds(60+240,75+35,230,25);
        jbcomprainventario.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                informeagregarproducto informe = new informeagregarproducto();
                informe.setVisible(true);
                
            }
        }
        );
        
        
        Jbmayor= new JButton("Mayor venta");
        Jbmayor.setBounds(60+240,75+35+35,230,25);
        Jbmayor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
        datospedidos arreglo[]= new datospedidos[20];
        arreglo= ventanaprincipal.arreglopedidos.clone();//copiar el arreglo para hacer un ordenamiento por fecha.
        
        datospedidos aux[]= new datospedidos[20];
        aux= ventanaprincipal.arreglopedidos.clone();
    //ordenar mayor  
        for (int i = 0; i < arreglo.length; i++) {//recorre el arreglo
            if(arreglo[i] !=null){//verifica si existe la posicion creada
                for (int j=i+1; j <arreglo.length; j++) {
                    if (arreglo[j]!=null) {
                        
                        if(arreglo[i].getGastototal()<arreglo[j].getGastototal()){
                            aux[0]=arreglo[i];
                            arreglo[i]=arreglo[j];
                            arreglo[j]=aux[0];
                        }
                    }
                    
                }
            
            }
            
        }
             
                
                
                
                
                
                try {
                    Document productosnecesarios= new Document();
                    FileOutputStream ficheroPdf = new FileOutputStream("Mayor_venta.pdf");
                    
                    PdfWriter.getInstance(productosnecesarios, ficheroPdf);
                    productosnecesarios.open();
                    Paragraph titulo = new Paragraph("MAYOR VENTA");
                    Paragraph espacio = new Paragraph(" ");
                    espacio.setAlignment(1);
                    titulo.setAlignment(1);
                    productosnecesarios.add(titulo);
                    productosnecesarios.add(espacio);
                    
                    
                    PdfPTable tabla =new PdfPTable(3);
                    tabla.addCell("Nombre");
                    tabla.addCell("Nit");
                    tabla.addCell("Cui");
                    
                    String nit= arreglo[0].getNitcliente();
                    for (int i = 0; i < 1; i++) {
                        for (int j = 0; j < ventanaprincipal.arreglocliente.length; j++) {
                            if (ventanaprincipal.arreglocliente[j] !=null) {
                                if (ventanaprincipal.arreglocliente[j].getNit().equals(nit)) {
                                    tabla.addCell(ventanaprincipal.arreglocliente[j].getNombres());
                                    tabla.addCell(ventanaprincipal.arreglocliente[j].getNit());
                                    tabla.addCell(ventanaprincipal.arreglocliente[j].getCui());
                                }

                                
                            }
                            
                        }
                        
                                tabla.addCell("producto");
                                tabla.addCell("cantidad adquirida");
                                tabla.addCell("precio total");
                                
                                producto m[]=arreglo[i].getProducto().clone();
                            for (int j = 0; j < m.length ; j++) {
                                tabla.addCell(m[j].getNombre());
                                tabla.addCell(String.valueOf(m[j].getCantidad()));
                                tabla.addCell(String.valueOf(m[j].getPrecio()));
                                
                                
                            }
                             
                              tabla.addCell(" "); 
                               tabla.addCell(" Total"); 
                              tabla.addCell(String.valueOf(arreglo[i].getGastototal())); 
                        
                    }
                    
                    productosnecesarios.add(tabla);
                    productosnecesarios.close();
                    
                    File obje=new File("Mayor_venta.pdf");
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
        );
        
     
        
        Jbmenor= new JButton("Menor venta");
        Jbmenor.setBounds(50,75+35+35,230,25);
        Jbmenor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
        datospedidos arreglo[]= new datospedidos[20];
        arreglo= ventanaprincipal.arreglopedidos.clone();//copiar el arreglo para hacer un ordenamiento por fecha.
        
        datospedidos aux[]= new datospedidos[20];
        aux= ventanaprincipal.arreglopedidos.clone();
    //ordenar mayor  
        for (int i = 0; i < arreglo.length; i++) {//recorre el arreglo
            if(arreglo[i] !=null){//verifica si existe la posicion creada
                for (int j=i+1; j <arreglo.length; j++) {
                    if (arreglo[j]!=null) {
                        
                        if(arreglo[i].getGastototal()>arreglo[j].getGastototal()){
                            aux[0]=arreglo[i];
                            arreglo[i]=arreglo[j];
                            arreglo[j]=aux[0];
                        }
                    }
                    
                }
            
            }
            
        }
             
                
                
                
                
                
                try {
                    Document productosnecesarios= new Document();
                    FileOutputStream ficheroPdf = new FileOutputStream("Menor_venta.pdf");
                    
                    PdfWriter.getInstance(productosnecesarios, ficheroPdf);
                    productosnecesarios.open();
                    Paragraph titulo = new Paragraph("MENOR VENTA");
                    Paragraph espacio = new Paragraph(" ");
                    espacio.setAlignment(1);
                    titulo.setAlignment(1);
                    productosnecesarios.add(titulo);
                    productosnecesarios.add(espacio);
                    
                    
                    PdfPTable tabla =new PdfPTable(3);
                    tabla.addCell("Nombre");
                    tabla.addCell("Nit");
                    tabla.addCell("Cui");
                    
                    String nit= arreglo[0].getNitcliente();
                    for (int i = 0; i < 1; i++) {
                        for (int j = 0; j < ventanaprincipal.arreglocliente.length; j++) {
                            if (ventanaprincipal.arreglocliente[j] !=null) {
                                if (ventanaprincipal.arreglocliente[j].getNit().equals(nit)) {
                                    tabla.addCell(ventanaprincipal.arreglocliente[j].getNombres());
                                    tabla.addCell(ventanaprincipal.arreglocliente[j].getNit());
                                    tabla.addCell(ventanaprincipal.arreglocliente[j].getCui());
                                }

                                
                            }
                            
                        }
                        
                                tabla.addCell("producto");
                                tabla.addCell("cantidad adquirida");
                                tabla.addCell("precio total");
                                
                                producto m[]=arreglo[i].getProducto().clone();
                            for (int j = 0; j < m.length ; j++) {
                                tabla.addCell(m[j].getNombre());
                                tabla.addCell(String.valueOf(m[j].getCantidad()));
                                tabla.addCell(String.valueOf(m[j].getPrecio()));
                                
                                
                            }
                             
                              tabla.addCell(" "); 
                               tabla.addCell(" Total"); 
                              tabla.addCell(String.valueOf(arreglo[i].getGastototal())); 
                        
                    }
                    
                    productosnecesarios.add(tabla);
                    productosnecesarios.close();
                    
                    File obje=new File("Menor_venta.pdf");
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
        );
        
        
        
        jbayuda = new JButton("ayuda");
        jbayuda.setBounds(50,400-75,100,25);
        jbayuda.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
            }
        }
        );
        
        
    }

    private void agregargrafico() {
        add(jlpreg1);
        add(jbclientesregistrados);
        add(jbpedidos);
        add(jbcomprainventario);
        add(jbproductosnecesarios);
        add(jbayuda);
        add(Jbmayor);
        add(Jbmenor);
    }
    
    
}
