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

	File ficheroDeposito = new File("src/archivos/baseDeDatos.txt");

	public Actions() {

	}

	public void existearchivo() {
		try {
			if (ficheroDeposito.exists()) {
				ficheroDeposito.createNewFile();
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public boolean agregar(Producto producto) {
		try {
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

}
