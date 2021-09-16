package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
        this.limpiar();
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.vista.btnGuardar) {
			if(!this.vista.txtCodigo.getText().trim().equals("") && !this.vista.txtProducto.getText().trim().equals("") && !this.vista.txtPrecio.getText().trim().equals("")) {
				this.producto.setCodigo(this.vista.txtCodigo.getText());
				this.producto.setNombre(this.vista.txtProducto.getText());
				this.producto.setPrecio(Integer.parseInt(this.vista.txtPrecio.getText()));
				if(this.actions.agregar(producto)) {
					JOptionPane.showMessageDialog(null, "Producto agregado");
					//Cargar
				} else {
					JOptionPane.showMessageDialog(null, "Error al guardar el producto");
				}				
			} else {
				JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
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
				this.vista.txtCodigo.enable(false);
			} else {
				this.limpiar();
			}
		}
		if(e.getSource() == this.vista.btnEliminar) {
			this.producto.setCodigo(this.vista.txtCodigo.getText());
			try {
				if(this.actions.eliminar(this.producto.getCodigo())) {
					JOptionPane.showMessageDialog(null, "Producto elimiando");
				} else {
					JOptionPane.showMessageDialog(null, "Error al eliminar");
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Error al eliminar");
				e1.printStackTrace();
			}
			this.limpiar();
		}
		
		if(e.getSource() == this.vista.btnModificar) {
			this.producto.setCodigo(this.vista.txtCodigo.getText());
			try {
				if(this.actions.modificar(this.producto.getCodigo())) {
					JOptionPane.showMessageDialog(null, "Producto modificado");
				} else {
					JOptionPane.showMessageDialog(null, "Error al modificar");
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Error al modificar");
				e1.printStackTrace();
			}
			
			
			
			
			
			
			
			
			
			
			
			//			try {
//					if(this.actions.eliminar(producto.getCodigo())) {
//						this.producto.setCodigo(this.vista.txtCodigo.getText());
//						this.producto.setNombre(this.vista.txtProducto.getText());
//						this.producto.setPrecio(Integer.parseInt(this.vista.txtPrecio.getText()));
//						if(this.actions.agregar(producto)) {
//							JOptionPane.showMessageDialog(null, "Producto Actualizado");
//							//Cargar
//						} else {
//							JOptionPane.showMessageDialog(null, "Error al modificar el producto");
//						}
//						this.limpiar();
//					}					
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			this.limpiar();
		}
		
		if(e.getSource() == this.vista.btnLimpiar) {
			this.limpiar();
		}
//		if(e.getSource() == this.vista.btnCargar) {
//			List<Producto> productos = this.actions.buscarTodo();
//			if(productos != null && productos.size() > 0) {
//				productos.forEach(producto -> System.out.println(producto.getCodigo() + "\t" +producto.getNombre()));
//			}
//		}
		
	}
	
	public void limpiar() {
		this.vista.txtCodigo.setText("");
		this.vista.txtProducto.setText("");
		this.vista.txtPrecio.setText("");
		this.vista.txtCodigo.enable(true);
	}
}
