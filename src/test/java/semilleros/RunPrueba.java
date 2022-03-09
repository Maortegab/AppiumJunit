package semilleros;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import PagObject.PagObjectLogin;
import PagObject.PageObjectFormulario;
import PagObject.PageObjectPagoTarjetaCr;
import io.appium.java_client.AppiumDriver;
import utilidadesExcel.ReadExcelFile;
import utilidadesExcel.WriteExcelFile;

public class RunPrueba {

	@SuppressWarnings("rawtypes")
	private static AppiumDriver driver;
	PagObjectLogin login;
	PageObjectFormulario formulario;
	PageObjectPagoTarjetaCr PagoTC;
	Properties propiedades;
	ReadExcelFile leer;
	WriteExcelFile escribir;
	String url = "";
	ClasesBase claseBase;

	@SuppressWarnings("unchecked")
	@Before

	public void setUp() throws IOException {
//		Instanciar la clase propiedades de javca util
		propiedades = new Properties();
//		Instanciar las lases de excel
		leer = new ReadExcelFile();
		escribir = new WriteExcelFile();
		
//	 	Crear variable tipo InputString
		InputStream entrada = null;

//		Validar si genera error al no encontrar el archivo
		try {
			entrada = new FileInputStream("./Properties/datos.propierties");
			propiedades.load(entrada);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		driver = ClasesBase.appiumDriverConnection(propiedades);
		claseBase = new ClasesBase(driver);
		login = new PagObjectLogin(driver);
		formulario = new PageObjectFormulario(driver);
		PagoTC = new PageObjectPagoTarjetaCr(driver);
	}

	@Test
	public void claroUpdateAdress() throws Exception {
		
//		if((leer.getCellValue(propiedades.getProperty("filePathExcel"), "Claro", 0, 1)=="Si")) {
			
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
//			login.ejecucionInicioSesion(leer, propiedades, nomTest);	
			formulario.ejecucionAppium(leer, propiedades, nomTest);
//		}
	}
	
//	@Test
//	public void claroPayTC() throws Exception {
//		
////		if((leer.getCellValue(propiedades.getProperty("filePathExcel"), "TarjetaCr", 0, 1)=="Si")) {
//					
//			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();			
////			login.ejecucionInicioSesion(leer, propiedades, nomTest);	
//			PagoTC.ejecucionAppium(leer, propiedades, nomTest);
////		}
//	}

	@After
	public void cerrar() {
		// cerrar proceso
//		driver.quit();
	}
}
