/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

/**
 *
 * @author elser
 */
public class Filtrobusqueda {
//filtro clientes nit    
    public static cliente[] filtroNit(cliente[] arregloOriginal, String nit){
        
        cliente[] arregloFiltrado = new cliente[arregloOriginal.length];
        int contador = 0;
        
        for (int i = 0; i < arregloOriginal.length; i++) {
            if(arregloOriginal[i] != null && arregloOriginal[i].getNit().equals(nit)){
                arregloFiltrado[contador] = arregloOriginal[i];
                contador++;
            }
        }
        
        return arregloFiltrado;
        
    }

    
//filtro para el producto    
    public static producto[] filtroProducto(producto[] arregloOriginal, String nombre){
        producto[] arregloFiltrado = new producto[arregloOriginal.length];
        int contador = 0;
        
        for (int i = 0; i < arregloOriginal.length; i++) {
            if(arregloOriginal[i] != null && arregloOriginal[i].getNombre().toLowerCase().contains(nombre.toLowerCase())){
                arregloFiltrado[contador] = arregloOriginal[i];
                contador++;
            }
        }
        
        return arregloFiltrado;
    }    
    
    
}
