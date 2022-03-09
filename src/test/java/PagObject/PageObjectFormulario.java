package PagObject;

import java.io.File;
import java.util.Properties;
import MapObjectDemoQA.MapObjectFormulario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PageObjectFormulario extends MapObjectFormulario {

	// Crear constructor de la clase

	public PageObjectFormulario(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = driver;
	}

	// Método inicial Abrir link

	public void urlAcceso(String url) {
		driver.get(url);
	}

	// Método para escribir en buscador
	public void ejecucionAppium(ReadExcelFile leer, Properties propiedades, String nomTest) throws Exception {

		File rutaFile = crearCarpeta(propiedades, nomTest);

		try {
			//Tiempo Provisional
			tiempoEspera(8);
			//Ingreso al menú
			click(nomTest, imgPerfil, rutaFile);
			tiempoEspera(1);
			tocarPantalla(700, 1000);
			tiempoEspera(3);
			click(nomTest, btActualizarDatos, rutaFile);
			
			click(nomTest, btCuenta, rutaFile);
			
			tiempoEspera(2);
			click(nomTest, btDireccion, rutaFile);
			tiempoEspera(3);
			
			//departamento
			click(nomTest, listDepartamento, rutaFile);
			click(nomTest, seleccionDepa, rutaFile);
			tiempoEspera(2);
			
			
			//Ciudad
			click(nomTest, listCiudad, rutaFile);
			click(nomTest, seleccionCiu, rutaFile);
			tiempoEspera(2);
			
			//Barrio
			sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Claro", 1, 3), txBarrio,rutaFile);
			
			//Tipo (calle,carrera)
			click(nomTest, listaTipo, rutaFile);
			click(nomTest, seleccionTipo, rutaFile);
			
			//Scroll Para llegar al final
			scrollVertical(rutaFile, 487, 1470, 790, 2);
			
			//No Principal
			sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Claro", 1, 5), txNoPrincipal,rutaFile);
			
			//sufijo1
			click(nomTest, listSufijo1, rutaFile);
			click(nomTest, seleccionSufi, rutaFile);
			
			//no Secundario
			sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Claro", 1, 7), txNoSecundario,rutaFile);
			
			//sufijo2
			click(nomTest, listSufijo2, rutaFile);
			click(nomTest, seleccionSufi2, rutaFile);
			
			//No Complemento
			sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Claro", 1, 9), txNoComplem,rutaFile);
			
			//complemento1
			click(nomTest, listComplem1, rutaFile);
			click(nomTest, seleccionComp1, rutaFile);
			//numero 1 
			sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Claro", 1, 11), txNumero1,rutaFile);
			clickEnter();
			//complemento2
			click(nomTest, listComplem2, rutaFile);
			click(nomTest, seleccionComp2, rutaFile);
			//numero 2
			sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Claro", 1, 13), txNumero2,rutaFile);
			clickEnter();
			
			tiempoEspera(1);
			click(nomTest, btnValidar, rutaFile);
			
			tiempoEspera(1);
			click(nomTest, btnAceptar, rutaFile);
			
			tiempoEspera(3);
			click(nomTest, btnCerrar, rutaFile);
			click(nomTest, btnInicio, rutaFile);
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		

	}

	
}
