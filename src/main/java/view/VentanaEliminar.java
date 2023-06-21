package view;

import controller.BibliotecaController;
import model.Libro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VentanaEliminar extends Ventana {
	private JButton botonEliminar, botonRegresar;
	private JLabel textoEncabezado, textoCodigo;
	private JTextField campoCodigo;

	public VentanaEliminar() {
		super("Eliminar libro", 500, 520);
		generarElementosVentana();
	}

	private void generarElementosVentana() {
		generarCampoCodigo();
		generarBotonEliminarLibro();
		generarBotonCancelar();
	}

	private void generarCampoCodigo() {
		String textoCodigo = "Código libro:";
		super.generarJLabel(this.textoCodigo, textoCodigo, 20, 50, 150, 20);
		this.campoCodigo = super.generarJTextField(200, 50, 250, 20);
		this.add(this.campoCodigo);
	}

	private void generarBotonEliminarLibro() {
		String textoBoton = "Eliminar libro";
		this.botonEliminar = super.generarBoton(textoBoton, 75, 400, 150, 20);
		this.add(this.botonEliminar);
		this.botonEliminar.addActionListener(this);
	}

	private void generarBotonCancelar() {
		String textoBotonRegresar = "Regresar";
		this.botonRegresar = super.generarBoton(textoBotonRegresar, 275, 400, 150, 20);
		this.add(this.botonRegresar);
		this.botonRegresar.addActionListener(this);
	}

	private void eliminarLibro() throws ClassNotFoundException {
		if (this.campoCodigo.getText().length() == 0) {
			JOptionPane.showMessageDialog(this, "Ingrese datos validos");
		} else {
			BibliotecaController.eliminarLibro(Integer.parseInt(this.campoCodigo.getText()));
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.botonEliminar) {
			try {
				eliminarLibro();
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
		}
		if (e.getSource() == this.botonRegresar) {
			VentanaMenu ventanaMenu = new VentanaMenu();
			this.dispose();
		}

	}
}