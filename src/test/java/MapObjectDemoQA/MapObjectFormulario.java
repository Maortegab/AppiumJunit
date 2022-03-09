package MapObjectDemoQA;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import semilleros.ClasesBase;

public class MapObjectFormulario extends ClasesBase {
		
		protected String valorAsignado = "";
		// constructor de la clase
			@SuppressWarnings("rawtypes")
		public MapObjectFormulario(AppiumDriver driver) {
			super(driver);
		} 			
			
			//destino
//			protected By imgPerfil = By.xpath("//android.widget.ImageView[@resource-id='com.clarocolombia.miclaro.debug:id/imgPerfil']");
			protected By imgPerfil = By.id("com.clarocolombia.miclaro.debug:id/imgPerfil");
			protected By btActualizarDatos = By.xpath("//android.widget.Button[@text='Actualizar datos']");
			protected By btCuenta = By.xpath("//android.widget.Button[@text='6053122725']");
			protected By btDireccion = By.xpath("//android.widget.ImageView[@resource-id='com.clarocolombia.miclaro.debug:id/imgEditarDir']");
			
			//formulario
			protected By listDepartamento = By.id("com.clarocolombia.miclaro.debug:id/spDepartamento");
			protected By seleccionDepa = By.xpath("//android.widget.CheckedTextView[@text='BOGOTA']");
			protected By listCiudad = By.id("com.clarocolombia.miclaro.debug:id/spCiudad");
			protected By seleccionCiu = By.xpath("//android.widget.CheckedTextView[@text='BOGOTÁ, D.C.']");
			protected By txBarrio = By.id("com.clarocolombia.miclaro.debug:id/edtBarrio");
			protected By listaTipo = By.id("com.clarocolombia.miclaro.debug:id/spTipo");
			protected By seleccionTipo = By.xpath("//android.widget.CheckedTextView[@text='Avenida']");
			protected By txNoPrincipal = By.id("com.clarocolombia.miclaro.debug:id/txtNPricipal");
			protected By listSufijo1 = By.id("com.clarocolombia.miclaro.debug:id/spSufijo1");
			protected By seleccionSufi = By.xpath("//android.widget.CheckedTextView[@text='A']");
			protected By txNoSecundario = By.id("com.clarocolombia.miclaro.debug:id/txtNSecuendario");
			protected By listSufijo2 = By.id("com.clarocolombia.miclaro.debug:id/spSufijo2");
			protected By seleccionSufi2 = By.xpath("//android.widget.CheckedTextView[@text='B']");
			protected By txNoComplem = By.id("com.clarocolombia.miclaro.debug:id/txtNComponente");
			protected By listComplem1 = By.id("com.clarocolombia.miclaro.debug:id/spComplemento1");
			protected By seleccionComp1 = By.xpath("//android.widget.CheckedTextView[@text='Bloque']");
			protected By txNumero1 = By.id("com.clarocolombia.miclaro.debug:id/txtNumero1");
			protected By listComplem2 = By.id("com.clarocolombia.miclaro.debug:id/spComplemento2");
			protected By seleccionComp2 = By.xpath("//android.widget.CheckedTextView[@text='Buzon']");
			protected By txNumero2 = By.id("com.clarocolombia.miclaro.debug:id/txtNumero2");
			
			protected By btnValidar = By.id("com.clarocolombia.miclaro.debug:id/btnAgregar");
			protected By btnAceptar = By.id("com.clarocolombia.miclaro.debug:id/btn_aceptar");
			protected By btnCerrar = By.id("com.clarocolombia.miclaro.debug:id/btn_aceptar");
			protected By btnInicio = By.id("com.clarocolombia.miclaro.debug:id/btnInicio");
			
			
			
			
			protected By seleccionLista = By.xpath("//android.widget.CheckedTextView[@text='"+valorAsignado+"']");

			
			
}
