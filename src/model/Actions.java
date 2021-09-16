package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
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
			Fescribe.write(producto.getCodigo() + "    " + producto.getNombre() + "    " + producto.getPrecio());
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
			Scanner entrada = new Scanner(ficheroDeposito);
			try (BufferedReader leer = new BufferedReader(new FileReader("src/archivos/baseDeDatos.txt"))) {
				String linea = "";
				while ((linea = leer.readLine()) != null) {
					if (linea.indexOf(codigo) != -1) {
						producto.setCodigo(entrada.next());
						producto.setNombre(entrada.next());
						producto.setPrecio(entrada.nextInt());
						return producto;
					}
				}
				entrada.close();
				leer.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Producto no encontrado");		
		return null;
	}
	
	
	public void eliminar (String codigo) {
		Producto producto = new Producto();
		
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
				}
			}
			Fescribe.close();
			entrada.close();
			leer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		
		}
		vaciar();
		
	}
	
	public void vaciar () {
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
	
	public void modificar (String codigo) {
		Producto mod;
		mod = this.buscar(codigo);
		mod.setNombre(JOptionPane.showInputDialog(null, "ingrese el nuevo nombre para el producto con codigo: " + codigo));
		mod.setPrecio(Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el nuevo precio para el producto con codigo: " + codigo)));
		this.eliminar(codigo);
		try {
			File ficheroDeposito = new File("src/archivos/baseDeDatos.txt");
			BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ficheroDeposito, true)));
			Fescribe.write(mod.getCodigo() + "    " + mod.getNombre() + "    " + mod.getPrecio());				
			Fescribe.write("\n");
			Fescribe.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	
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
