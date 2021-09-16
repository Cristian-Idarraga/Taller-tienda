package main;

import controller.Controlador;
import model.Actions;
import model.Producto;
import view.Vista;

public class Main {

	public static void main(String[] args) {
		Vista vista = new Vista();
		Actions actions = new Actions();
		Producto producto = new Producto();
		Controlador controlador = new Controlador(vista, actions, producto);
		controlador.Inicio();
//		Producto producto = new Producto ("12345", "sopa", 3000);
//		Producto producto1 = new Producto ("11111", "sopa1", 3000);
//		Producto producto2 = new Producto ("22222", "sopa2", 3000);
//		Producto producto3 = new Producto ("33333", "sopa3", 3000);
//		Producto producto4 = new Producto ("44444", "sopa4", 3000);
//		
//		Actions obj = new Actions ();
//		obj.existearchivo();
//		obj.agregar(producto);
//		obj.agregar(producto1);
//		obj.agregar(producto2);
//		obj.agregar(producto3);
//		obj.agregar(producto4);
//		
//		obj.eliminar("33333");
	}
}
