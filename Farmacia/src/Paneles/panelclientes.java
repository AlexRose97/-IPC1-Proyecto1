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
public class panelclientes extends JPanel{
//tabla que contine los clientes
    JTable tabla;
    JScrollPane scroll;


//Botones
    private JButton jbregistrar;
    private JButton jbbuscar;
    
//textos sin modificar    
    private JLabel jlpregunta1;//¿Desea registrar un nuevo cliente?
    private JLabel jlpregunta2;//¿Desea buscar y modidicar la informacion de un cliente?
    private JLabel jlpregunta3;//¿Desea ver el listado de clientes?
//cuadro de texto
    private JTextField jtnitbusqueda;
    private JScrollPane jspScrollLista;
    public panelclientes(){
        setLayout(null);
        
        botones();
        texto();
        cuadrotexto();
        colocargrafico();
    }

    private void botones() {
        jbregistrar = new JButton("REGISTRAR");
        jbregistrar.setBounds(310,40,120,25);
        //evento al presionar el boton "regristrar"
        jbregistrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                formularioclientes registro = new formularioclientes();
                registro.setVisible(true);
            
            }
        }
        );
        
        
        
        jbbuscar = new JButton("BUSCAR");
        jbbuscar.setBounds(405,110,100,25);
        //evento al presionar buscar
        jbbuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtfiltrobusqueda();
               }    
        });
        
    }

    private void cuadrotexto() {
        jtnitbusqueda = new JTextField("Escriba el numero de NIT del cliente");
        jtnitbusqueda.setBounds(60,110,330,25);

//area donde se mustra el listado de clientes            
        scroll=new JScrollPane(ventanaprincipal.tablaclientes);
        scroll.setBounds(50, 180, 500,150);
        
        ventanaprincipal.tablaclientes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me){
                if(me.getClickCount() == 2){// Cuenta la cantidad de clicks para saber si es doble
                    
                    
                    int fila = ventanaprincipal.tablaclientes.rowAtPoint(me.getPoint());// numero Fila que se selecciona
                    String nombreseleccionado=ventanaprincipal.tablaclientes.getValueAt(fila,0).toString();//Copia el Nombre del cliente ya que esta en columna 0
                    String apellidoseleccionado=ventanaprincipal.tablaclientes.getValueAt(fila,1).toString();//Copia el apellido del cliente ya que esta en columna 1;
                    String nitselecionado=ventanaprincipal.tablaclientes.getValueAt(fila,2).toString();//Copia el nit del cliente ya que esta en columna 2;
                    
                    int x = JOptionPane.showConfirmDialog(null, "¿Desea modificar la informacion de "+nombreseleccionado+"?","modiicar informacion",0);
                //si elige que si debemos buscar en el arreglo el cliente con ese nombre.    
                    if(x==JOptionPane.YES_OPTION){
                        modificarinfo modificar=new modificarinfo();//abrir la ventana para cambiar datos
                        
                        for (int i = 0; i <ventanaprincipal.arreglocliente.length; i++) {
                            if(ventanaprincipal.arreglocliente[i] !=null){//verifica si exite esa posicion en el arreglo
                            if (ventanaprincipal.arreglocliente[i].getNit().equals(nitselecionado)) {//encuentra el cliente y copia sus datos
                                String nombres =ventanaprincipal.arreglocliente[i].getNombres();
                                String apellidos = ventanaprincipal.arreglocliente[i].getApellidos();
                                int edad = ventanaprincipal.arreglocliente[i].getEdad();
                                String cuii = ventanaprincipal.arreglocliente[i].getCui();
                                String nit = ventanaprincipal.arreglocliente[i].getNit();
                                int dia = ventanaprincipal.arreglocliente[i].getDia();
                                int mes = ventanaprincipal.arreglocliente[i].getMes();
                                int año = ventanaprincipal.arreglocliente[i].getAño();
                                String nocasa = ventanaprincipal.arreglocliente[i].getNocasa();
                                String colonia = ventanaprincipal.arreglocliente[i].getColonia();
                                String calle = ventanaprincipal.arreglocliente[i].getCalle();
                                String zona = ventanaprincipal.arreglocliente[i].getZona();
                                
                            //enviar los datos a los campos de texto de la siguiente 
                                modificarinfo.identificador= nit;
                                modificarinfo.jtnombresr.setText(nombres);
                                modificarinfo.jtapellidosr.setText(apellidos);
                                modificarinfo.jtedadr.setText(Integer.toString(edad));
                                modificarinfo.jtcuir.setText(cuii);
                                modificarinfo.jtnitr.setText(nit);
                                modificarinfo.jtfechadiar.setText(Integer.toString(dia));
                                modificarinfo.jtfechamesr.setText(Integer.toString(mes));
                                modificarinfo.jtfechaañor.setText(Integer.toString(año));
                                modificarinfo.jtcasar.setText(nocasa);
                                modificarinfo.jtcoloniar.setText(colonia);
                                modificarinfo.jtcaller.setText(calle);
                                modificarinfo.jtzonar.setText(zona);
                            }
                        }
                        }
                        
                        modificar.setVisible(true);
                        llenarLista(ventanaprincipal.arreglocliente);//actualizar la tabla con los cambios
                    }else{
                        
                    }
                    
                }
            }
        });        
        
        

        
        
    }

    private void texto() {
        jlpregunta1 = new JLabel("¿Desea registrar un nuevo cliente?");
        jlpregunta1.setBounds(60,40,300,25);
        jlpregunta2 = new JLabel("Realiza la busqueda de un cliente");
        jlpregunta2.setBounds(60,80,400,25);
        jlpregunta3 = new JLabel("Listado de Clientes Registrados");
        jlpregunta3.setBounds(60,150,300,25);
    }

    private void colocargrafico() {
    //botones
        add(jbregistrar);
        add(jbbuscar); 
    //texto
        add(jlpregunta1);
        add(jlpregunta2);
        add(jlpregunta3);
    //cuadro de textp
        add(jtnitbusqueda);
        add(scroll);
    }
    
//filtro de la busqueda por nit    
    private void jtfiltrobusqueda() {
        String textobusqueda = jtnitbusqueda.getText();
        
        if(textobusqueda.isEmpty()){
            llenarLista(ventanaprincipal.arreglocliente);
        }else{
            llenarLista(Filtrobusqueda.filtroNit(ventanaprincipal.arreglocliente, textobusqueda));
        }
        
    }

    private void llenarLista(cliente[] filtroNit) {
//llenar tabla
//tabla
    //como borrar filas
        int contadordefilas = ventanaprincipal.modeloclientes.getRowCount();
        for (int i = 0;contadordefilas>i; i++) {
            ventanaprincipal.modeloclientes.removeRow(0);
        }
    //lenar las filas con los elementos encontrados
        int i = 0;
        while(filtroNit[i] != null){
            
            String nombre=filtroNit[i].getNombres();
            String apellidos=filtroNit[i].getApellidos();
            String nit=filtroNit[i].getNit();
            String datos[] = {nombre,apellidos,nit};
            ventanaprincipal.modeloclientes.addRow(datos);
            
            i++;
        }

        if(filtroNit[0]==null){//el cliente no esta registrado
            int x = JOptionPane.showConfirmDialog(this, "El cliente no se encuentra registrado\n     ¿DESEA REGISTRARLO?","Error",0);
            
            if(x==JOptionPane.YES_OPTION){
                formularioclientes registro = new formularioclientes();
                formularioclientes.jtnit.setText(jtnitbusqueda.getText());//envia el nit que el usuario desea registrar
                registro.setVisible(true);
                jtnitbusqueda.setText("");//limpiar area de texto a verificar 
                formularioclientes.jtnit.setText("");//envia el nit que el usuario desea registrar
            }else{
                jtnitbusqueda.setText("");//limpiar area de texto a verificar
                jtfiltrobusqueda();
            }
            
            
        }
        
    }
}
