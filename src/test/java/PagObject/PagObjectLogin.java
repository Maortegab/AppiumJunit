package PagObject;

import java.io.File;
import java.util.Properties;

import MapObjectDemoQA.MapObjectLogin;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagObjectLogin extends MapObjectLogin {

	// Crear constructor de la clase

	public PagObjectLogin(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = driver;
	}

	// Método inicial Abrir link

	public void urlAcceso(String url) {
		driver.get(url);
	}

	// Método para escribir en buscador
	public void ejecucionInicioSesion(ReadExcelFile leer, Properties propiedades, String nomTest) throws Exception {

		File rutaFile = crearCarpeta(propiedades, nomTest);

		try {

			tiempoEspera(6);
			click(nomTest, btIngresoUsuarioContra, rutaFile);
			tiempoEspera(1);
			click(nomTest, btCorreo, rutaFile);
			tiempoEspera(1);
			sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Login", 1, 1), txCorreo, rutaFile);
			sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Login", 1, 2), txContraseña, rutaFile);

			click(nomTest, btIniciarSesion, rutaFile);

			tiempoEspera(2);
			click(nomTest, btCancelarGuardado, rutaFile);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void ejecucionCierreSesion(ReadExcelFile leer, Properties propiedades, String nomTest) throws Exception {

		File rutaFile = crearCarpeta(propiedades, nomTest);

		try {

			// en Pantalla Inicio

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
