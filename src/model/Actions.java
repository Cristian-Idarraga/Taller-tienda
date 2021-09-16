package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Actions {

	
	

	public Actions() {

	}

	public void existearchivo() {
		try {
			File ficheroDeposito = new File("src/archivos/baseDeDatos.txt");
			if (ficheroDeposito.exists()) {
				ficheroDeposito.createNewFile();
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public boolean agregar(Producto producto) {
		try {
			File ficheroDeposito = new File("src/archivos/baseDeDatos.txt");
			BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ficheroDeposito, true)));
			Fescribe.write(producto.getCodigo() + " " + producto.getNombre() + " " + producto.getPrecio());
			Fescribe.write("\n");
			Fescribe.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Producto buscar(String codigo) {
		Producto producto = new Producto("", "", 0);
		try {
			File ficheroDeposito = new File("src/archivos/baseDeDatos.txt");
			try (BufferedReader leer = new BufferedReader(new FileReader("src/archivos/baseDeDatos.txt"))) {
				String linea = "";
				while ((linea = leer.readLine()) != null) {
					String [] data = linea.split(" ");
					if (linea.indexOf(codigo) != -1 && data[0].equals(codigo)) {
						try {
							producto.setCodigo(data[0]);
							producto.setNombre(data[1]);
							producto.setPrecio(Integer.parseInt(data[2]));							
							return producto;
						} catch (Exception e) {
							return producto;
						}
					}
				}
				leer.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Producto no encontrado");
		return null;
	}
	
	
	public boolean eliminar (String codigo) throws Exception{
		Producto producto = new Producto();
		boolean found = false;
		String linea = "";
		try {
			File ficheroDeposito2 = new File("src/archivos/baseDeDatos2.txt");
			File ficheroDeposito = new File("src/archivos/baseDeDatos.txt");
			Scanner entrada = new Scanner(ficheroDeposito);
			BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ficheroDeposito2, true)));
			BufferedReader leer = new BufferedReader(new FileReader("src/archivos/baseDeDatos.txt"));
			while ((linea = leer.readLine()) != null) {
					producto.setCodigo(entrada.next());
					producto.setNombre(entrada.next());
					producto.setPrecio(entrada.nextInt());
				if (!(linea.indexOf(codigo) != -1)) {
					Fescribe.write(producto.getCodigo() + "    " + producto.getNombre() + "    " + producto.getPrecio());
					Fescribe.write("\n");
					found = true;
				}
			}
			if(!found) {
				throw new Exception("No se encontró el dato");
			}
			Fescribe.close();
			entrada.close();
			leer.close();
			vaciar();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	private void vaciar () {
		Producto producto = new Producto();
		String linea = "";
		try {
			File ficheroDeposito2 = new File("src/archivos/baseDeDatos2.txt");
			File ficheroDepositoAux = new File("src/archivos/baseDeDatos.txt");
			ficheroDepositoAux.delete();
			File ficheroDeposito = new File("src/archivos/baseDeDatos.txt");
			Scanner entrada = new Scanner(ficheroDeposito2);
			BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ficheroDeposito, true)));
			BufferedReader leer = new BufferedReader(new FileReader("src/archivos/baseDeDatos2.txt"));
			while ((linea = leer.readLine()) != null) {
					producto.setCodigo(entrada.next());
					producto.setNombre(entrada.next());
					producto.setPrecio(entrada.nextInt());
					Fescribe.write(producto.getCodigo() + "    " + producto.getNombre() + "    " + producto.getPrecio());				
					Fescribe.write("\n");
				
			}
			Fescribe.close();
			entrada.close();
			leer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		
		}
		
	}
//	public boolean mod(Producto producto) {
//		if(this.agregar(producto)) {
//			JOptionPane.showMessageDialog(null, "guardado");
//		}
//		
//		return false;
//	}
//	
//	public boolean modificar (String codigo) throws Exception {
//		Producto mod;
//		mod = this.buscar(codigo);
//		mod.setNombre(JOptionPane.showInputDialog(null, "ingrese el nuevo nombre para el producto con codigo: " + codigo));
//		mod.setPrecio(Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el nuevo precio para el producto con codigo: " + codigo)));
//		this.eliminar(codigo);
//		try {
//			File ficheroDeposito = new File("src/archivos/baseDeDatos.txt");
//			BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ficheroDeposito, true)));
//			Fescribe.write(mod.getCodigo() + "    " + mod.getNombre() + "    " + mod.getPrecio());				
//			Fescribe.write("\n");
//			Fescribe.close();
//			return true;
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			return false;
//		}
//	}
	
	
	
	
	public List<Producto> buscarTodo() {
		Producto producto = new Producto("", "", 0);
		List<Producto> productos = new ArrayList<Producto>();
		try {
			File ficheroDeposito = new File("src/archivos/baseDeDatos.txt");
			Scanner entrada = new Scanner(ficheroDeposito);
			try (BufferedReader leer = new BufferedReader(new FileReader("src/archivos/baseDeDatos.txt"))) {
				String linea = "";
				while ((linea = leer.readLine()) != null) {
						producto.setCodigo(entrada.next());
						producto.setNombre(entrada.next());
						producto.setPrecio(entrada.nextInt());
						productos.add(producto);
				}
				linea = "";
				entrada.close();
				leer.close();
				return productos;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Producto no encontrado");		
		return null;
	}

}
