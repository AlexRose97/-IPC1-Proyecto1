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
public class cliente {
    private String nombres;
    private String apellidos;
    private int edad;
    private String cui;
    private String nit;
    private int dia;
    private int mes;
    private int año;
    private String nocasa;
    private String colonia;
    private String calle;
    private String zona;
    
    public  cliente(String nombres, String apellidos, int edad, String cui, String nit, int dia, int mes, int año, String nocasa, String colonia, String calle, String zona){
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.edad=edad;
        this.cui=cui;
        this.nit=nit;
        this.dia=dia;
        this.mes=mes;
        this.año=año;
        this.nocasa=nocasa;
        this.colonia=colonia;
        this.calle=calle;
        this.zona=zona;
    }
    
    public String getNombres() {
        return nombres;
    }


    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }


    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }


    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }


    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }


    public void setAño(int año) {
        this.año = año;
    }

    public String getNocasa() {
        return nocasa;
    }

    public void setNocasa(String nocasa) {
        this.nocasa = nocasa;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    
    public String getCalle() {
        return calle;
    }


    public void setCalle(String calle) {
        this.calle = calle;
    }


    public String getZona() {
        return zona;
    }


    public void setZona(String zona) {
        this.zona = zona;
    }

}
