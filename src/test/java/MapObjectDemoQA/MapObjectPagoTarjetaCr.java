package MapObjectDemoQA;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import semilleros.ClasesBase;

public class MapObjectPagoTarjetaCr extends ClasesBase {

	// constructor de la clase
	@SuppressWarnings("rawtypes")
	public MapObjectPagoTarjetaCr(AppiumDriver driver) {
		super(driver);
	}
	
	//Estando en Pagina Principal		
	
	protected By btnPagos = By.xpath("//android.widget.FrameLayout[@content-desc=\"Pagos\"]/android.widget.ImageView");
	protected By btnPagaTuFacturaAqui = By.xpath("//android.widget.Button[@text='Paga tu factura aquí']");
	protected By btnPagar = By.xpath("//android.widget.Button[@text='Pagar']");
	protected By listaMedioDePago = By.xpath("//android.view.View[@resource-id='select']");
	protected By btnTarjetaCr = By.xpath("//android.view.View[@content-desc=\"Tarjeta de Crédito - Débito Tarjeta de Crédito - Débito\"]");	
	protected By btnContinuar = By.xpath("//android.widget.Button[@resource-id='mySubmit_']");
	protected By btnContinuar2 = By.xpath("//android.widget.Button[@text='Continuar']");
	//Datos tarjeta
	protected By txNoTarjeta = By.xpath("//android.widget.EditText[@resource-id='NUMERO_TARJETA']");
	protected By listMesVencimiento = By.xpath("//android.view.View[@resource-id='FECHA_VENC_MES']");
	protected By listAnnoVencimiento = By.xpath("//android.view.View[@resource-id='FECHA_VENC_ANNO']");
	protected By tcCodigoSeguridad = By.xpath("//android.widget.EditText[@resource-id='CODIGO_SEGURIDAD']");
	protected By listCoutas = By.xpath("//android.view.View[@resource-id='CUOTAS']");
	protected By txNombreTarjeta = By.xpath("//android.widget.EditText[@resource-id='NOMBRE_TARJETA']");
	protected By listTipoDocumento = By.xpath("//android.view.View[@resource-id='TIPO_DOCUMENTO']");
	protected By txNumeroDoc = By.xpath("//android.widget.EditText[@resource-id='NUMERO_DOCUMENTO']");
	protected By txTelefono = By.xpath("//android.widget.EditText[@resource-id='TELEFONO']");
	protected By txCorreo = By.xpath("//android.widget.EditText[@resource-id='EMAIL']");
	protected By btnCancelar = By.xpath("//android.widget.Button[@resource-id='btnCancelar']");
	
	//Volver
	protected By btnVolver = By.xpath("//android.widget.ImageButton[@content-desc=\"Desplazarse hacia arriba\"]");
	//Falta el Map de BotonInicio
	
	
	
}
