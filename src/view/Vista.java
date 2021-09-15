package view;

import javax.swing.*;
import java.util.logging.*;
import javax.swing.table.*;

import model.Actions;

public class Vista extends JFrame {

	public JButton btnBuscar;
	public JButton btnCargar;
	public JButton btnEliminar;
	public JButton btnGuardar;
	public JButton btnLimpiar;
	public JButton btnModificar;
	private JLabel jLabel1;
	private JLabel jlProducto;
	private JLabel jlPrecio;
	private JScrollPane jScrollPane1;
	private JSeparator jSeparator1;
	private JLabel jlSpace;
	public JTable jtPersonas;
	public JTextField txtCodigo;
	public JTextField txtPrecio;
	public JTextField txtID;
	public JTextField txtProducto;

	public Vista() {
		initComponents();
	}

	@SuppressWarnings("serial")
	private void initComponents() {

		txtCodigo = new JTextField();
		jLabel1 = new JLabel();
		jlProducto = new JLabel();
		txtProducto = new JTextField();
		jlPrecio = new JLabel();
		txtPrecio = new JTextField();
		jlSpace = new JLabel();
		btnBuscar = new JButton();
		btnGuardar = new JButton();
		btnModificar = new JButton();
		btnEliminar = new JButton();
		btnLimpiar = new JButton();
		jScrollPane1 = new JScrollPane();
		jtPersonas = new JTable();
		jSeparator1 = new JSeparator();
		btnCargar = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);

		jLabel1.setText("Codigo");

		jlProducto.setText("Producto");

		jlPrecio.setText("Precio");

		jlSpace.setText("\n");

		btnBuscar.setText("Buscar");

		btnGuardar.setText("Guardar");

		btnModificar.setText("Modificar");

		btnEliminar.setText("Eliminar");

		btnLimpiar.setText("Limpiar");

		jtPersonas
				.setModel(new DefaultTableModel(
						new Object[][] { { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null } },
						new String[] { "codigo", "producto", "precio" }) {
					boolean[] canEdit = new boolean[] { false, false, false };

					public boolean isCellEditable(int rowIndex, int columnIndex) {
						return canEdit[columnIndex];
					}
				});
		jScrollPane1.setViewportView(jtPersonas);

		jSeparator1.setOrientation(SwingConstants.VERTICAL);

		btnCargar.setText("Cargar");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1,
										GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(183, 183, 183).addComponent(btnCargar)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
						.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGap(7, 7, 7)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(btnGuardar).addGap(18, 18, 18)
										.addComponent(btnModificar).addGap(18, 18, 18).addComponent(btnEliminar)
										.addGap(18, 18, 18).addComponent(btnLimpiar))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jlProducto).addComponent(jLabel1).addComponent(jlPrecio)
												.addComponent(jlSpace))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addGroup(layout.createSequentialGroup()
														.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 117,
																GroupLayout.PREFERRED_SIZE)
														.addGap(44, 44, 44).addComponent(jlSpace))
												.addComponent(txtProducto).addComponent(txtPrecio,
														GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18).addComponent(btnBuscar)))
						.addContainerGap()));
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jSeparator1, GroupLayout.Alignment.TRAILING)
						.addGroup(GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addContainerGap(22, Short.MAX_VALUE)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel1)
												.addComponent(btnBuscar))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(jlProducto)
												.addComponent(txtProducto, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(jlPrecio).addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(jlSpace)
												.addComponent(btnGuardar).addComponent(btnModificar)
												.addComponent(btnEliminar).addComponent(btnLimpiar))
										.addGap(16, 16, 16))
						.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(btnCargar)
								.addGap(11, 11, 11)
								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pack();
	}

	public static void main(String args[]) {
//		try {
//			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//				if ("Windows".equals(info.getName())) {
//					UIManager.setLookAndFeel(info.getClassName());
//					break;
//				}
//			}
//		} catch (Exception ex) {
//			Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
//		}
//
//		run();
		
		Actions obj = new Actions();
		obj.existearchivo();
		obj.agregar("12345", "sopa", 3000);
		obj.buscar("12345");

	}

	public static void run() {
		new Vista().setVisible(true);
	}

}
