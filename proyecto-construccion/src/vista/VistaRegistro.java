package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VistaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private final Color BEIGE = new Color(199, 193, 183);
	private final Color CAFE_CLARO = new Color(199, 154, 108);
	private final Color CAFE = new Color(144, 120, 91);
	private final Color AZUL = new Color(51, 102, 255);
	private final Color AZUL_MARINO = new Color(46, 65, 83);

	private JTextField textoNombre;
	private JTextField textoCorreo;
	private JTextField textoContrasena;
	private JTextField textoConfirmarContrasena;
	private JButton botonRegistrarse;
	private JButton botonYaTengoCuenta;
	private JLabel mensajeLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				VistaRegistro frame = new VistaRegistro();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaRegistro() {
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 500, 550);
		getContentPane().setBackground(CAFE);
		getContentPane().setLayout(null);

		// Panel principal
		JPanel panel = new JPanel();
		panel.setBackground(BEIGE);
		panel.setBounds(50, 50, 400, 400);
		panel.setLayout(null);
		getContentPane().add(panel);

		// Título
		JLabel lblTitulo = new JLabel("Registrarse");
		lblTitulo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		lblTitulo.setForeground(AZUL_MARINO);
		lblTitulo.setBounds(30, 29, 340, 30);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTitulo);

		// Etiqueta Nombre
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblNombre.setForeground(AZUL_MARINO);
		lblNombre.setBounds(30, 70, 340, 20);
		panel.add(lblNombre);

		// Campo Nombre
		textoNombre = new JTextField();
		inicializarCampoTexto(textoNombre, 30, 90, panel);

		// Etiqueta Correo
		JLabel lblCorreo = new JLabel("Correo electrónico:");
		lblCorreo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblCorreo.setForeground(AZUL_MARINO);
		lblCorreo.setBounds(30, 130, 340, 20);
		panel.add(lblCorreo);

		// Campo Correo
		textoCorreo = new JTextField();
		inicializarCampoTexto(textoCorreo, 30, 150, panel);

		// Etiqueta Contraseña
		JLabel lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblContrasena.setForeground(AZUL_MARINO);
		lblContrasena.setBounds(30, 190, 340, 20);
		panel.add(lblContrasena);

		// Campo Contraseña
		textoContrasena = new JTextField();
		inicializarCampoTexto(textoContrasena, 30, 210, panel);

		// Etiqueta Confirmar Contraseña
		JLabel lblConfirmarContrasena = new JLabel("Confirmar contraseña:");
		lblConfirmarContrasena.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblConfirmarContrasena.setForeground(AZUL_MARINO);
		lblConfirmarContrasena.setBounds(30, 250, 340, 20);
		panel.add(lblConfirmarContrasena);

		// Campo Confirmar Contraseña
		textoConfirmarContrasena = new JTextField();
		inicializarCampoTexto(textoConfirmarContrasena, 30, 270, panel);

		// Botón Registrarse
		botonRegistrarse = new JButton("Registrarse");
		inicializarBoton(botonRegistrarse, CAFE_CLARO, 30, 310, panel);

		// Etiqueta de mensaje
		mensajeLabel = new JLabel();
		mensajeLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		mensajeLabel.setForeground(Color.RED);
		mensajeLabel.setBounds(30, 340, 340, 20);
		panel.add(mensajeLabel);

		// Separador
		JSeparator separador = new JSeparator();
		separador.setBounds(30, 350, 340, 10);
		panel.add(separador);

		// Botón "Ya tengo cuenta"
		botonYaTengoCuenta = new JButton("Ya tengo una cuenta");
		inicializarBotonTextoPlano(botonYaTengoCuenta, AZUL, 30, 360, panel);

		// Fondo
		JLabel fondo = new JLabel();
		fondo.setIcon(
				new ImageIcon("C:\\Users\\CASA\\eclipse-workspace\\proyecto_construccion\\src\\vista\\fondo-cafe.jpg"));
		fondo.setBounds(0, 0, 484, 511);
		getContentPane().add(fondo);

		// Mostrar ventana
		setVisible(true);
	}

	private void inicializarCampoTexto(JTextField campo, int x, int y, JPanel panel) {
		campo.setBounds(x, y, 340, 25);
		campo.setBackground(Color.WHITE);
		campo.setForeground(AZUL_MARINO);
		campo.setFont(new Font("Arial", Font.PLAIN, 14));
		campo.setBorder(null);
		panel.add(campo);
	}

	private void inicializarBoton(JButton boton, Color colorFondo, int x, int y, JPanel panel) {
		boton.setBounds(x, y, 340, 30);
		boton.setBackground(colorFondo);
		boton.setForeground(Color.WHITE);
		boton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		boton.setBorder(null);
		panel.add(boton);
	}

	private void inicializarBotonTextoPlano(JButton boton, Color colorTexto, int x, int y, JPanel panel) {
		boton.setBounds(x, y, 340, 20);
		boton.setForeground(colorTexto);
		boton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		boton.setBackground(BEIGE);
		boton.setBorder(null);
		boton.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(boton);
	}

	public void setMensaje(String mensaje) {
		mensajeLabel.setText(mensaje);
	}

	public String getCorreo() {
		return textoCorreo.getText();
	}

	public String getContrasena() {
		return textoContrasena.getText();
	}

	public String getConfirmarContrasena() {
		return textoConfirmarContrasena.getText();
	}

	// Métodos para añadir ActionListeners
	public void addRegistroListener(ActionListener actionListener) {
		botonRegistrarse.addActionListener(actionListener);
	}

	public void addBotonYaTengoCuentaListener(ActionListener actionListener) {
		botonYaTengoCuenta.addActionListener(actionListener);
	}
}