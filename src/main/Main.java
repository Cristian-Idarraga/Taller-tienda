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
	}
}
