package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Actions {
	
	File ficheroDeposito= new File ("baseDeDatos.txt");
	
	public Actions () {
		
	}
	
	public void existearchivo(){
        try{
            if (ficheroDeposito.exists()){
                ficheroDeposito.createNewFile();
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
	
	public void agregar(String codigo, String nombre, int precio) {
		 try{
	            BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ficheroDeposito,true)));
	            Fescribe.write(codigo +"    "+nombre+"    "+ precio);                          
	            Fescribe.write("\n");  
	            JOptionPane.showMessageDialog(null, "El producto ha sido agregado a la base de datos");
	            Fescribe.close();
	        }
	        catch(Exception ex) {
	            System.out.println(ex.getMessage());
	        }
	}
	
	public void buscar (String codigo) {
		String s = "";
		Producto producto = new Producto("", "", 0);
		try
        {
			Scanner entrada = new Scanner(ficheroDeposito);
            BufferedReader leer=new BufferedReader(new FileReader ("baseDeDatos.txt"));
            String linea="";
            while((linea=leer.readLine())!=null)
            {
                if (linea.indexOf(codigo)!=-1)
                {
                    producto.setCodigo(entrada.next());
                    producto.setNombre(entrada.next());
                    producto.setPrecio(entrada.nextInt());
                    s = "Codigo: " + producto.getCodigo() + "\nNombre del producto: " + producto.getNombre() + "\nPrecio del producto: " + producto.getPrecio()+"$";
            		JOptionPane.showMessageDialog(null, s);
                }
            }
            entrada.close();
            leer.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
		
	}

}
