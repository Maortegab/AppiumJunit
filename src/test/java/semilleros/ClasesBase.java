package semilleros;



import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utilidadesExcel.ReadExcelFile;

public class ClasesBase {
	
	protected AppiumDriver<MobileElement> driver;
	

	// Constructor de la clase
	@SuppressWarnings("rawtypes")
	public ClasesBase(AppiumDriver driver) {
		super();
	}

	@SuppressWarnings("rawtypes")
	public static AppiumDriver appiumDriverConnection(Properties propiedades) {
		// Setear las opciones del navegador
		AppiumDriver _driver = null;
		try {
//			Crear las Capabilitys del movil
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", propiedades.getProperty("platformName"));
			caps.setCapability("deviceName", propiedades.getProperty("deviceName"));
			caps.setCapability("platformVersion", propiedades.getProperty("platformVersion"));
			caps.setCapability("appPackage", propiedades.getProperty("appPackage"));
			caps.setCapability("appActivity", propiedades.getProperty("appActivity"));
			caps.setCapability("noReset", propiedades.getProperty("noReset"));
			caps.setCapability("autoGrantPermissions", propiedades.getProperty("autoGrantPermissions"));

			
			
			//Instanciar Appium Driver
			try {
				printCo("Cargando capability de appium, favor esperar...");
				_driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
			}catch(MalformedURLException e) {
				printCo(e.getMessage());
			}
			return _driver;
		}catch (Exception e) {
			printCo(e.getMessage());
		}
		return _driver;
	}

	private static void printCo(String tx) {
		System.out.println(tx);
		
	}

	// Método Click
	public void click(String nomTest ,By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).click();
		tiempoEspera(2);
		captureScreen(rutaCarpeta);
	}
	
	//Metodo Scroll Vertical Descendente
	public void scrollVerticalDes(File rutafile)throws Exception{
		@SuppressWarnings("rawtypes")
		TouchAction touch = new TouchAction(driver);
		touch.press(PointOption.point(350,930))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(350,430))
		.release().perform();
		captureScreen(rutafile);
	}

	// Método Borrar
	public void borrar(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).clear();
		captureScreen(rutaCarpeta);
	}

	// Método enviar texto
	public void sendKey(String inputText, By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).sendKeys(inputText);
		captureScreen(rutaCarpeta);
	}

	// Método enter Submit
	public void submit(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).submit();
		captureScreen(rutaCarpeta);
	}

	// Método tiempo de espera
	public void tiempoEspera(long tiempo) throws InterruptedException {
		Thread.sleep(tiempo * 1000);
	}

	public String fechaHora() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();
		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
		// DAR FORMATO A LA FECHA DEL SITEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}

	public String horaSistema() {

		// Tomamos La fecha del sistema
		LocalTime horaSistema = LocalTime.now();

		// Definir formato de hora
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");

		// dar formato a la fecha del sistema
		String hora = fecha.format(horaSistema);
		return hora;

	}

	public void captureScreen(File rutaCarpeta) throws Exception {
		String hora = horaSistema();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(rutaCarpeta + "\\" + hora + ".png"));
	}

	public File crearCarpeta(Properties propiedades, String nomTest) {

		// Almacenamos la fecha del sistema
		String fecha = fechaHora();

		// Creamos el nombre de la carpeta
		String nomCarpeta = nomTest + "-" + fecha;

		// Obtenemos la ruta de alojamiento de salida y el nombre dek test a ejecutar
		File directorio = new File("./output/" + nomCarpeta);

		// Creamos la carpeta
		directorio.mkdir();
		return directorio;
	}

	// Método inicial
	public void urlAcceso(String url) {
		driver.get(url);
	}

	protected int posicionEliminado = 53;

	// metodo Busqueda fecha

	public void busquedaFecha(ReadExcelFile leer, Properties propiedades) throws Exception {
		leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja2", 1, 10);
	}
	//ScrollVertical ciclico
	public void scrollVertical(File rutaFile, int xini,int yini, int yfinal, int iteraciones) throws Exception
	{
		
	for (int i = 1 ;i<=iteraciones;i++)
	{
	@SuppressWarnings("rawtypes")
	TouchAction touch = new TouchAction(driver);
	touch.press(PointOption.point(xini,yini))
	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	.moveTo(PointOption.point(xini,yfinal))
	.release().perform();
	captureScreen(rutaFile);
	}
	}

	//Toca la pantalla simulando un click en una coordenada
	public void tocarPantalla(int x, int y)
	{
	@SuppressWarnings("rawtypes")
	TouchAction touch = new TouchAction(driver);
	touch.press(PointOption.point(x,y)).release().perform();
	}
	
	//Escribir desde el teclado android
	public void write(String palabra) throws Exception {
		
		char[] c = palabra.toCharArray();
		
		for(int i = 0; i<palabra.length();i++) {
			String C = String.valueOf(c[i]);
			if (C.equals("@"))
				((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.AT));
				else if (C.equals("."))
				((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.PERIOD));
				else if (NumberUtils.isParsable(C))
				((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.valueOf("DIGIT_" + C)));
				else
				((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.valueOf(C)));
		}
				tiempoEspera(2);
				((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.TAB));
	}
public void writeDate(String palabra) throws Exception {
		
		char[] c = palabra.toCharArray();
		
		for(int i = 0; i<palabra.length();i++) {
			String C = String.valueOf(c[i]);
			if (C.equals("@"))
				((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.AT));
				else if (C.equals("."))
				((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.PERIOD));
				else if (C.equals(" "))
					((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.SPACE));
				else if (C.equals(","))
					((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.COMMA));
//				else if (C.equals(":"))
//					((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.p));
				else if (NumberUtils.isParsable(C))
				((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.valueOf("DIGIT_" + C)));
				else
				((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.valueOf(C)));
		}				
	}

//Validar si el elemento está presente
	public boolean elementoPresente (By locator) {
		boolean estado = driver.findElement(locator).isDisplayed();
		return estado;
	}
	public void selectVisible(String datoExc, By locator, int x, int yPs, int yMt, int i, File rutaCarpeta)	throws Exception {

			String locatorPart1 = locator.toString();
			String[] parts = locatorPart1.split(" ");

			// String xpathSelect=locatorPart1+datoExc+"']";

			By localizador = By.xpath(parts[1] + datoExc + "']");
			boolean displayed = elementoPresente(localizador);
			while (displayed == false) {
			scrollVertical(rutaCarpeta, x, yPs, yMt, i);
			displayed = elementoPresente(localizador);
			}

			click(rutaCarpeta,1);
			}
	
	

	private void click(File rutaCarpeta, int i) {
		// TODO Auto-generated method stub
		
	}

	//Metodo boton enter Teclado
	public void clickEnter() {
		((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
	}
	public void clickTAB() {
		((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.TAB));
	}	
	public void clickSLASH() {
		((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.SLASH));
	}
}