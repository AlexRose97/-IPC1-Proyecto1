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
public class datospedidos {
    
    private String estado;
    private String nitcliente;
    private int diapedido;
    private int mespedido;
    private int añopedido;
    private producto producto[];
    double gastototal;
    
    public  datospedidos(String estado,String nitcliente, int diapedido, int mespedido, int añopedido, producto producto[],double gastototal){
        this.gastototal=gastototal;
        this.estado=estado;
        this.nitcliente=nitcliente;
        this.diapedido=diapedido;
        this.mespedido=mespedido;
        this.añopedido=añopedido;
        this.producto=producto;
    }

    public double getGastototal() {
        return gastototal;
    }
    
    public void setGastototal(double gastototal) {
        this.gastototal = gastototal;
    }    

    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNitcliente() {
        return nitcliente;
    }

    public void setNitcliente(String nitcliente) {
        this.nitcliente = nitcliente;
    }

    public int getDiapedido() {
        return diapedido;
    }
    
    public void setDiapedido(int diapedido) {
        this.diapedido = diapedido;
    }
    
    public int getMespedido() {
        return mespedido;
    }

    public void setMespedido(int mespedido) {
        this.mespedido = mespedido;
    }

    public int getAñopedido() {
        return añopedido;
    }


    public void setAñopedido(int añopedido) {
        this.añopedido = añopedido;
    }


    public producto[] getProducto() {
        return producto;
    }


    public void setProducto(producto[] producto) {
        this.producto = producto;
    }
    
    
}
