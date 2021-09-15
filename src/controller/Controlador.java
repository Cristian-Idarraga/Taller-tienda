package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Actions;
import model.Producto;
import view.Vista;

public class Controlador implements ActionListener{

	Vista vista;
	Actions actions;
	Producto producto;
	
	public Controlador(Vista vista, Actions actions, Producto producto) {
		super();
		this.vista = vista;
		this.actions = actions;
		this.producto = producto;
		this.vista.btnGuardar.addActionListener(this);
		this.vista.btnBuscar.addActionListener(this);
		this.vista.btnEliminar.addActionListener(this);
		this.vista.btnLimpiar.addActionListener(this);
		this.vista.btnModificar.addActionListener(this);
		this.vista.btnCargar.addActionListener(this);
	}

    public void Inicio(){
        this.vista.setTitle("Productos");
        this.vista.setVisible(true);  
        this.vista.setLocationRelativeTo(null);
        this.vista.setResizable(false);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.vista.btnGuardar) {
			this.producto.setCodigo(this.vista.txtCodigo.getText());
			this.producto.setNombre(this.vista.txtProducto.getText());
			this.producto.setPrecio(Integer.parseInt(this.vista.txtPrecio.getText()));
			if(this.actions.agregar(producto)) {
				JOptionPane.showMessageDialog(null, "Producto agregado");
				//Cargar
			} else {
				JOptionPane.showMessageDialog(null, "Error al guardar el producto");
			}
			this.limpiar();
		}
		if(e.getSource() == this.vista.btnBuscar) {
			this.producto.setCodigo(this.vista.txtCodigo.getText());
			Producto product = this.actions.buscar(this.producto.getCodigo());
			if(product != null) {
				JOptionPane.showMessageDialog(null, "producto encontrado");
				this.vista.txtCodigo.setText(product.getCodigo());
				this.vista.txtProducto.setText(product.getNombre());
				this.vista.txtPrecio.setText(String.valueOf(product.getPrecio()));
			}
		}
		
	}
	
	public void limpiar() {
		this.vista.txtCodigo.setText(null);
		this.vista.txtProducto.setText(null);
		this.vista.txtPrecio.setText(null);
	}
}
