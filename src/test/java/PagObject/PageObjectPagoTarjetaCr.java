package PagObject;

import java.io.File;
import java.util.Properties;

import MapObjectDemoQA.MapObjectPagoTarjetaCr;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PageObjectPagoTarjetaCr extends MapObjectPagoTarjetaCr {

	// Crear constructor de la clase

	public PageObjectPagoTarjetaCr(AppiumDriver<MobileElement> driver) {
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
			tiempoEspera(6);
			//Estando en pagina Inicio
			click(nomTest,btnPagos, rutaFile);
			tiempoEspera(1);
			
			click(nomTest, btnPagaTuFacturaAqui, rutaFile);
			tiempoEspera(1);
			
			click(nomTest, btnPagar, rutaFile);
			tiempoEspera(3);
			
			click(nomTest, listaMedioDePago, rutaFile);
			tiempoEspera(1);
			
//			click(nomTest, btnTarjetaCr, rutaFile);
			tocarPantalla(500, 1393);
			tiempoEspera(1);
			
			click(nomTest, btnContinuar, rutaFile);
			tiempoEspera(3);
			
			scrollVerticalDes(rutaFile);
			click(nomTest, btnContinuar2, rutaFile);
			
			
			//Datos Tarjeta
			
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);

		}
	}
}