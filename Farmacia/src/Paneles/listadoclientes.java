/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import ventana.ventanaprincipal;



public class listadoclientes extends JDialog{
        JScrollPane jspScrollLista;
        
        
    public listadoclientes(){
        setTitle("Listado de clientes");
        setModal(true);//bloquear uso de la ventana anterior
        setLayout(null);
        setSize(500,300);//tamaño, ancho, alto
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//terminar el proceso al cerrar la ventana
        setResizable(false);//no puede cambiarse el tamaño
        setLocationRelativeTo(null);//posicion de la ventana(centro de pantalla)
        
        iniciar();
        llenarmatriz();
        colocargrafico();
    }

    private void iniciar() {
        
        
       
        jspScrollLista = new JScrollPane(ventanaprincipal.jlLista);
        jspScrollLista.setBounds(0, 0, 500,300);
        
    }
    
    private void llenarmatriz() {

    }    
        
    
  
    
    private void colocargrafico() {
        add(jspScrollLista);
    }




}
