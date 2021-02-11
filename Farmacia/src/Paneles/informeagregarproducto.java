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
public class informeagregarproducto extends JDialog{
//botones
    private JButton jbgenerar1; 
    private JButton jbgenerar2; 
//texto Fijo
    private JLabel jlgenerar1;
    private JLabel jlgenerar2;
//cuadro de texto cantidad a agregar
    private JTextField jtmes;
            
    public informeagregarproducto() {
        setTitle("Productos Agregados");
        setModal(true);//bloquear uso de la ventana anterior
        setLayout(null);
        setSize(450,220);//tamaño, ancho, alto
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//terminar el proceso al cerrar la ventana
        setResizable(false);//no puede cambiarse el tamaño
        setLocationRelativeTo(null);//posicion de la ventana(centro de pantalla)
        
        botones();
        texto();
        colocargrafico();
        
    }

    private void botones() {
        jbgenerar1= new JButton("GENERAR");
        jbgenerar1.setBounds(330,25,100,25);
        jbgenerar1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                    
                
                
                
                try {
                    Document productosadquiridos= new Document();
                    FileOutputStream ficheroPdf = new FileOutputStream("Productos_Adquiridos.pdf");
                    
                    PdfWriter.getInstance(productosadquiridos, ficheroPdf);
                    productosadquiridos.open();
                    Paragraph titulo = new Paragraph("PRODUCTOS ADQUIRIDOS");
                    Paragraph espacio = new Paragraph(" ");
                    espacio.setAlignment(1);
                    titulo.setAlignment(1);
                    productosadquiridos.add(titulo);
                    productosadquiridos.add(espacio);
                    
                    
                    PdfPTable tabla =new PdfPTable(3);
                    tabla.addCell("Producto");
                    tabla.addCell("Cantidad adquirida");
                    tabla.addCell("Fecha");
                    
                    for (int i = 0; i < ventanaprincipal.arreglocompra.length; i++) {//recorre la matris de compras
                        if(ventanaprincipal.arreglocompra[i] !=null){//verifica si exite creada la posicion

                            tabla.addCell(ventanaprincipal.arreglocompra[i].getNombre());
                            tabla.addCell(String.valueOf(ventanaprincipal.arreglocompra[i].getCantidad()));
                            tabla.addCell(String.valueOf(ventanaprincipal.arreglocompra[i].getDia())+"/"+String.valueOf(ventanaprincipal.arreglocompra[i].getMes())+"/"+String.valueOf(ventanaprincipal.arreglocompra[i].getAño()));  

                        }
                    
                    }
                    
                    productosadquiridos.add(tabla);
                    productosadquiridos.close();
                    
                    File obje=new File("Productos_Adquiridos.pdf");
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
        
        
        
        jbgenerar2= new JButton("GENERAR");
        jbgenerar2.setBounds(300,120,100,25);
        jbgenerar2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            int mes=Integer.parseInt(jtmes.getText());
                    
                
                
                
                try {
                    Document productosadquiridos= new Document();
                    FileOutputStream ficheroPdf = new FileOutputStream("Productos_Adquiridos.pdf");
                    
                    PdfWriter.getInstance(productosadquiridos, ficheroPdf);
                    productosadquiridos.open();
                    Paragraph titulo = new Paragraph("PRODUCTOS ADQUIRIDOS");
                    Paragraph espacio = new Paragraph(" ");
                    espacio.setAlignment(1);
                    titulo.setAlignment(1);
                    productosadquiridos.add(titulo);
                    productosadquiridos.add(espacio);
                    
                    
                    PdfPTable tabla =new PdfPTable(3);
                    tabla.addCell("Producto");
                    tabla.addCell("Cantidad adquirida");
                    tabla.addCell("Fecha");
                    
                    for (int i = 0; i < ventanaprincipal.arreglocompra.length; i++) {//recorre la matris de compras
                        if(ventanaprincipal.arreglocompra[i] !=null){//verifica si exite creada la posicion
                            if (ventanaprincipal.arreglocompra[i].getMes()==mes) {//verifica compras en un mes
                                tabla.addCell(ventanaprincipal.arreglocompra[i].getNombre());
                                tabla.addCell(String.valueOf(ventanaprincipal.arreglocompra[i].getCantidad()));
                                tabla.addCell(String.valueOf(ventanaprincipal.arreglocompra[i].getDia())+"/"+String.valueOf(ventanaprincipal.arreglocompra[i].getMes())+"/"+String.valueOf(ventanaprincipal.arreglocompra[i].getAño()));  
   
                            }

                        }
                    
                    }
                    
                    productosadquiridos.add(tabla);
                    productosadquiridos.close();
                    
                    File obje=new File("Productos_Adquiridos.pdf");
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
        
        
    }

    private void texto() {
        jlgenerar1 = new JLabel("Generar un informe con todos los pedidos");
        jlgenerar1.setBounds(30,25,300,25);
        
        jlgenerar2 = new JLabel("Seleccione un mes especifico");
        jlgenerar2.setBounds(30,120,300,25);
        
        jtmes = new JTextField("01");
        jtmes.setBounds(250,120,40,25);
        
        
    }    

    private void colocargrafico() {
    //Botones
        add(jbgenerar1);
        add(jbgenerar2);
    //texto
        add(jlgenerar1);
        add(jlgenerar2);
        add(jtmes);
        
    }





     
    
}
