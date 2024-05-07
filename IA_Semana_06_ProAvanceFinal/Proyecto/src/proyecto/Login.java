package proyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	private JTextField txtUsuario;
	private JButton btnIngresar;
	private JPasswordField jPassContraseña;
 
	//Variables Globales
	int numErrores = 0, numIntentos = 3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login Cocina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 41, 80, 14);
		contentPane.add(lblUsuario);

		lblContraseña = new JLabel("Contraseña");
		lblContraseña.setBounds(10, 96, 92, 14);
		contentPane.add(lblContraseña);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(112, 38, 111, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(62, 172, 131, 45);
		contentPane.add(btnIngresar);

		jPassContraseña = new JPasswordField();
		jPassContraseña.setBounds(112, 93, 111, 20);
		contentPane.add(jPassContraseña);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}

	

	// ==============================================================
	protected void actionPerformedBtnIngresar(ActionEvent e) {

		numErrores++;
		numIntentos--;

		char[] contra = jPassContraseña.getPassword();
		String clave = new String(contra);

		if (txtUsuario.getText().equals("programa") && clave.equals("123")) {
			dispose();
			JOptionPane.showMessageDialog(null, "BIENVENIDO AL PROGRAMA", "Ingresaste",
					JOptionPane.INFORMATION_MESSAGE);
			Menu obj = new Menu();
			obj.setVisible(true);

		} else if (numIntentos != 0) {
			JOptionPane.showMessageDialog(null,
					"Usuario o Contraseña incorrectos \n " + "Le quedan " + numIntentos + " intentos", "Error",
					JOptionPane.ERROR_MESSAGE);
			txtUsuario.setText("");
			jPassContraseña.setText("");
			txtUsuario.requestFocus();
		} else {
			JOptionPane.showMessageDialog(null, "Ya no cuenta con mas intentos", "Limite de intentos",
					JOptionPane.INFORMATION_MESSAGE);
		}

		if (numErrores == 3)
			dispose();

	}

}