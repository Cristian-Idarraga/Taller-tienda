package view;

import javax.swing.*;
import java.util.logging.*;
import javax.swing.table.*;

public class Vista extends JFrame {

	public JButton btnBuscar;
	public JButton btnCargar;
	public JButton btnEliminar;
	public JButton btnGuardar;
	public JButton btnLimpiar;
	public JButton btnModificar;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JScrollPane jScrollPane1;
	private JSeparator jSeparator1;
	private JLabel jlabelcedula;
	public JTable jtPersonas;
	public JTextField txtCedula;
	public JTextField txtCodigo;
	public JTextField txtEdad;
	public JTextField txtID;
	public JTextField txtNombre;

	public Vista() {
		initComponents();
	}

	private void initComponents() {

		txtCodigo = new JTextField();
		jLabel1 = new JLabel();
		txtID = new JTextField();
		jLabel2 = new JLabel();
		txtNombre = new JTextField();
		jLabel3 = new JLabel();
		txtEdad = new JTextField();
		jlabelcedula = new JLabel();
		txtCedula = new JTextField();
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

		jLabel1.setText("Codigo");

		txtID.setEditable(false);

		jLabel2.setText("Nombre");

		jLabel3.setText("Edad");

		jlabelcedula.setText("Cedula");

		btnBuscar.setText("Buscar");

		btnGuardar.setText("Guardar");

		btnModificar.setText("Modificar");

		btnEliminar.setText("Eliminar");

		btnLimpiar.setText("Limpiar");

		jtPersonas
				.setModel(new DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "codigo", "nombre", "edad", "cedula" }) {
					boolean[] canEdit = new boolean[] { false, false, false, false };

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
												.addComponent(jLabel2).addComponent(jLabel1).addComponent(jLabel3)
												.addComponent(jlabelcedula))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addGroup(layout.createSequentialGroup()
														.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 117,
																GroupLayout.PREFERRED_SIZE)
														.addGap(44, 44, 44).addComponent(txtID,
																GroupLayout.PREFERRED_SIZE, 51,
																GroupLayout.PREFERRED_SIZE))
												.addComponent(txtNombre).addComponent(txtCedula).addComponent(txtEdad,
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
												.addComponent(txtID, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnBuscar))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2)
												.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel3).addComponent(txtEdad, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(jlabelcedula)
												.addComponent(txtCedula, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(28, 28, 28)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
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
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception ex) {
			Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
		}

		run();

	}

	public static void run() {
		new Vista().setVisible(true);
	}

}
