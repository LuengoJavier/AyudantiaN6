package principal;

import data.DBGenerator;
import view.VentanaMenu;

public class Launcher {

	public static void main(String[] args) throws ClassNotFoundException {
		DBGenerator.iniciarBD("Biblioteca");
		VentanaMenu ventanaMenu = new VentanaMenu();
	}
}